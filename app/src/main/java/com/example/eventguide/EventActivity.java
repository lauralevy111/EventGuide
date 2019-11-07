package com.example.eventguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    private Button toastTestButton;
    public ImageView imageViewIcon;

    public ArrayList<EventDataModel> data;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        data = new ArrayList<EventDataModel>();
        for (int i = 0; i < EventData.nameArray.length; i++) {
            data.add(new EventDataModel(
                    EventData.nameArray[i],
                    EventData.versionArray[i],
                    EventData.id_[i],
                    EventData.drawableArray[i]
            ));
        }


        Intent intent = getIntent();
        int selectedItemId = (int)intent.getExtras().get("selectedItemId");
        final String selectedItemIdString = "selected: "+selectedItemId+".";

        int listPosition = data.indexOf(selectedItemId)+1;


        toastTestButton = findViewById(R.id.toastTestButton);

        ImageView imageView = findViewById(R.id.imageView2);

        if((data.get(selectedItemId))!=null){

            imageView.setImageResource(data.get(selectedItemId).getImage());
        }

        toastTestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        selectedItemIdString,
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
