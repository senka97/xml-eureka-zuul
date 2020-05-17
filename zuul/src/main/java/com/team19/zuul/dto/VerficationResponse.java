package com.team19.zuul.dto;

public class VerficationResponse {

    String permissions;
    String userID;

    public VerficationResponse(){

    }

    public VerficationResponse(String permissions, String userID){
        this.permissions = permissions;
        this.userID = userID;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
