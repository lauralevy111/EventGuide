package com.example.eventguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public Button toBrowseButton;
    public Button toCalendarButton;
    public Button toSavedEventButton;
    public Button toMapButton;

    //for consuming events from meetup
    private final String BASE_URL = "https://api.meetup.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toBrowseButton = findViewById(R.id.toBrowseButton);
        toCalendarButton = findViewById(R.id.toCalendarButton);
        toSavedEventButton = findViewById(R.id.toSavedEventActivityButton);
        toMapButton = findViewById(R.id.toMapButton);

        toBrowseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BrowseActivity.class);

                startActivity(intent);
            }
        });

        toCalendarButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalendarActivity.class);

                startActivity(intent);
            }
        });

        toSavedEventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), SavedEventActivity.class);

                startActivity(intent);
            }
        });

        toMapButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), MapActivity.class);

                startActivity(intent);

                //TODO: REMOVE :~)
                //there once was a man named micheal finnegan
                //he had whiskers on his chinnegan
                //the wind blew them off but they grew in again
                //poor old micheal finnegan
            }
        });


    }
}
