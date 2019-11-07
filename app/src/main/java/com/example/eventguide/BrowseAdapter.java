package com.example.eventguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.BrowseViewHolder> {

    public ArrayList<EventDataModel> dataSet;

    public static class BrowseViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public BrowseViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public BrowseAdapter(ArrayList<EventDataModel> data) {
        this.dataSet = data;
    }

    @Override
    public BrowseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_event_card, parent, false);

        view.setOnClickListener(BrowseActivity.myOnClickListener);

        BrowseViewHolder browseViewHolder = new BrowseViewHolder(view);
        return browseViewHolder;
    }

    @Override
    public void onBindViewHolder(final BrowseViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}