package com.team19.zuul.filter;

import com.netflix.discovery.converters.Auto;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.team19.zuul.client.UserClient;
import com.team19.zuul.dto.VerficationResponse;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter extends ZuulFilter {

    @Autowired
    UserClient userClient;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private void setFailedRequest(String body, int code) {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.setResponseStatusCode(code);
        if (ctx.getResponseBody() == null) {
            ctx.setResponseBody(body);
            ctx.setSendZuulResponse(false);
        }
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        //ako nema tokena prosledi dalje, jer neke putanje ne zahtevaju ulogovanog
        //prilikom logovanja i registracije ne sme da bude token
        if (request.getHeader("Authorization") == null) {
            System.out.println("Nema tokena");
            return null;
        }
        System.out.println("Ima tokena");

        //Ako postoji token, proveri da li je validan i vrati permisije od usera i njegov id
        String token = request.getHeader("Authorization");
        token = token.split(" ")[1]; //da se izostavi Bearer
        System.out.println(token);
        try {
            VerficationResponse vr = userClient.verifyUser(token);
            if(vr==null){
                setFailedRequest("Token is not valid!", 403);
            }
            String permissions = vr.getPermissions();
            String userID = vr.getUserID();

            ctx.addZuulRequestHeader("userID", userID);
            ctx.addZuulRequestHeader("permissions", permissions);
            ctx.addZuulRequestHeader("Authorization", "Bearer " + token);

        } catch (FeignException.NotFound e) {
            setFailedRequest("User doesn't exist!", 403);
        }

        return null;

    }
}
