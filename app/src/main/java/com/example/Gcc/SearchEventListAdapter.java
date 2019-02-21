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

public class SearchEventListAdapter extends RecyclerView.Adapter<SearchEventListAdapter.SearchEventViewHolder>{

    private final LayoutInflater inflater;

    private List<Event> eventList;

    public SearchEventListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SearchEventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recyclerview_search_item, viewGroup, false);
        return new SearchEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchEventViewHolder searchEventViewHolder, int position) {
        if(eventList != null){
            Event current = eventList.get(position);
            searchEventViewHolder.eventItemView.setText(current.getDesc());
        } else {
            searchEventViewHolder.eventItemView.setText("No Event");
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
    class SearchEventViewHolder extends RecyclerView.ViewHolder {
        private final TextView eventItemView;

        private SearchEventViewHolder(View itemView){
            super(itemView);
            eventItemView = itemView.findViewById(R.id.textReclViewSearch);
        }
    }
}
