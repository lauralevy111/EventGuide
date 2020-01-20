package com.example.eventguide;

public class Admin extends User{

    private String classification;

    public Admin (String userName, String emailAddress, String phoneNumber, String classification){
        super(userName, emailAddress, phoneNumber);
        this.classification=classification;
    }

}
