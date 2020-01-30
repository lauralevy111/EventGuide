package com.example.eventguide;


import java.util.Date;

public class Event {

    public Date when;
    public String name;
    public Admin organizer;

    private boolean happeningNow =false;

    public Event (Date when){
        this.when=when;
    }

    public void start(){
        happeningNow = true;

    }


}
