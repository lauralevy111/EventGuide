package com.example.eventguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public Button toBrowseButton;
    public Button toCalendarButton;
    public Button toEventButton;

    //for consuming events from meetup
    private final String BASE_URL = "https://api.meetup.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toBrowseButton = findViewById(R.id.toBrowseButton);
        toCalendarButton = findViewById(R.id.toCalendarButton);

        //for testing
        toEventButton = findViewById(R.id.toEventButton);

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

        toEventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventActivity.class);

                startActivity(intent);
            }
        });

    }
}
