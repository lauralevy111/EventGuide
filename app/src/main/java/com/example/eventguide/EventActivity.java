package com.example.eventguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity {

    private Button toastTestButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        Intent intent = getIntent();
        int selectedItemId = (int)intent.getExtras().get("selectedItemId");
        final String selectedItemIdString = "selected: "+selectedItemId+".";


        toastTestButton = findViewById(R.id.toastTestButton);

        toastTestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        selectedItemIdString,
                        Toast.LENGTH_SHORT).show();
            }
        });




    }
}
