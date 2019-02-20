package com.example.Gcc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.Gcc.data.source.local.Event;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder>{

    class EventViewHolder extends RecyclerView.ViewHolder {

        private final TextView eventItemView;

        private EventViewHolder(View itemView){
            super(itemView);
            eventItemView = itemView.findViewById(R.id.textViewRV);
        }
    }

    private final LayoutInflater inflater;

    private List<Event> eventList;

    public EventListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        if(eventList != null){
            Event current = eventList.get(position);
            holder.eventItemView.setText(current.getDesc());
        } else {
            holder.eventItemView.setText("No Event");
        }
    }


    @Override
    public int getItemCount() {
        if(eventList != null){
            return eventList.size();
        } else {
            return 0;
        }
    }

    void setEventList(List<Event> eventList) {
        eventList = eventList;
        notifyDataSetChanged();
    }

}
