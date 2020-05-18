package com.team19.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

        @RequestMapping({ "", "/login", "/registration" ,"/home", "/homePage", "/cart", "/vehicle/**", "/post/**", "/adminProfile" })
        public String gui() {
            return "forward:/index.html";
        }

}
