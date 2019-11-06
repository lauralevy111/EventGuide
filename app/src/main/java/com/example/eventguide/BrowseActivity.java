package com.example.eventguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static androidx.recyclerview.widget.RecyclerView.Adapter;
import static androidx.recyclerview.widget.RecyclerView.LayoutManager;

public class BrowseActivity extends AppCompatActivity {

    private static Adapter adapter;
    private LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<EventDataModel> data;
    static View.OnClickListener myOnClickListener;
    //private static ArrayList<Integer> removedItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        myOnClickListener = new MyOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<EventDataModel>();
        for (int i = 0; i < EventData.nameArray.length; i++) {
            data.add(new EventDataModel(
                    EventData.nameArray[i],
                    EventData.versionArray[i],
                    EventData.id_[i],
                    EventData.drawableArray[i]
            ));
        }

        //removedItems = new ArrayList<Integer>();

        adapter = new BrowseAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private static class MyOnClickListener implements View.OnClickListener {

        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View v) {
            //removeItem(v);

            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewName);
            String selectedName = (String) textViewName.getText();
            int selectedItemId = -1;
            for (int i = 0; i < EventData.nameArray.length; i++) {
                if (selectedName.equals(EventData.nameArray[i])) {
                    selectedItemId = EventData.id_[i];
                }
            }

            //this code sends to the selected Event's specific EventActivity.
            Intent selectedActivityIntent = new Intent(context.getApplicationContext(), EventActivity.class);
            selectedActivityIntent.putExtra( "selectedItemId", selectedItemId);
            context.startActivity(selectedActivityIntent);
        }

        /*private void removeItem(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.textViewName);
            String selectedName = (String) textViewName.getText();
            int selectedItemId = -1;
            for (int i = 0; i < EventData.nameArray.length; i++) {
                if (selectedName.equals(EventData.nameArray[i])) {
                    selectedItemId = EventData.id_[i];
                }
            }

            //this code removes an item once its been selected
            //removedItems.add(selectedItemId);
            //data.remove(selectedItemPosition);
            //adapter.notifyItemRemoved(selectedItemPosition);
        }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_browse, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.add_item) {
            //check if any items to add
            //if (removedItems.size() != 0) {
                //addRemovedItemToList();
            //} else {
                Toast.makeText(this, "Nothing to add", Toast.LENGTH_SHORT).show();
            //}
        }
        return true;
    }

    /*private void addRemovedItemToList() {
        int addItemAtListPosition = 3;
        data.add(addItemAtListPosition, new EventDataModel(
                EventData.nameArray[removedItems.get(0)],
                EventData.versionArray[removedItems.get(0)],
                EventData.id_[removedItems.get(0)],
                EventData.drawableArray[removedItems.get(0)]
        ));
        adapter.notifyItemInserted(addItemAtListPosition);
        removedItems.remove(0);
    }*/


}
