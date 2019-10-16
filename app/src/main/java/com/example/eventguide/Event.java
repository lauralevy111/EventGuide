package com.example.eventguide;


import java.util.Date;

public class Event {

    public Date when;
    public String name;
    public Admin organizer;

    public Event (Date when){
        this.when=when;
    }

}
