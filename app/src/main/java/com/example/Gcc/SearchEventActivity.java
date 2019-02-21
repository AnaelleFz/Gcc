package com.example.Gcc;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.Gcc.usecase.ModifyEventUseCase;
import com.example.Gcc.viewmodel.SearchActivityViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class SearchEventActivity extends AppCompatActivity {

    private SearchActivityViewModel viewModel;

    private SearchEventListAdapter adapter;

    private ModifyEventUseCase modifyEventUseCase;

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);

        compositeDisposable = new CompositeDisposable();

        modifyEventUseCase = ModifyEventUseCase.getInstance();

        RecyclerView recyclerView = findViewById(R.id.searchRecyclerView);
        adapter = new SearchEventListAdapter(this, modifyEventUseCase, compositeDisposable);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = ViewModelProviders.of(this).get(SearchActivityViewModel.class);

        viewModel.getEventsSup30().observe(this, events -> adapter.setEventList(events));
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }
}
