package com.example.eventguide;

public class Admin extends User{

    private String classification;

    public Admin (String userName, String emailAddress, String classification){
        super(userName, emailAddress);
        this.classification=classification;
    }

}
