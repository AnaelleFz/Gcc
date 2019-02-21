package com.example.Gcc;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.Gcc.data.source.local.Event;
import com.example.Gcc.viewmodel.SearchActivityViewModel;

import java.util.List;

public class SearchEventActivity extends AppCompatActivity {

    private SearchActivityViewModel viewModel;

    private SearchEventListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);

        RecyclerView recyclerView = findViewById(R.id.searchRecyclerView);
        adapter = new SearchEventListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = ViewModelProviders.of(this).get(SearchActivityViewModel.class);

        viewModel.getEventsSup30().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(@Nullable List<Event> events) {
                adapter.setEventList(events);
            }
        });
    }
}
