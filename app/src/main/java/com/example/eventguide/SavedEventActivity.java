package com.example.eventguide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.LayoutManager;

public class SavedEventActivity extends AppCompatActivity {


    private static RecyclerView.Adapter adapter;
    private LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<EventDataModel> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_event);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<EventDataModel>();
        for (int i = 0; i < EventData.getSelectedEventCount(); i++) {
            data.add(new EventDataModel(
                    EventData.nameArray[i],
                    EventData.versionArray[i],
                    EventData.id_[i],
                    EventData.drawableArray[i]
            ));
        }

        adapter = new BrowseAdapter(data);
        recyclerView.setAdapter(adapter);

    }
}
