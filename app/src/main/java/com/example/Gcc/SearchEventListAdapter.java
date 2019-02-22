package com.example.Gcc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.Gcc.data.source.local.Event;
import com.example.Gcc.usecase.ModifyEventUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.List;

public class SearchEventListAdapter extends RecyclerView.Adapter<SearchEventListAdapter.SearchEventViewHolder> {

    private final LayoutInflater inflater;

    private List<Event> eventList;

    private CompositeDisposable activityCompositeDisposable;

    @Inject
    public ModifyEventUseCase modifyEventUseCase;

    public SearchEventListAdapter(Context context, CompositeDisposable compositeDisposable,
                                  ModifyEventUseCase modifyEventUseCase) {
        this.inflater = LayoutInflater.from(context);
        this.activityCompositeDisposable = compositeDisposable;
        this.modifyEventUseCase = modifyEventUseCase;
    }

    @NonNull
    @Override
    public SearchEventViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.recyclerview_search_item, viewGroup, false);
        return new SearchEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchEventViewHolder searchEventViewHolder, int position) {
        if (eventList != null) {
            Event current = eventList.get(position);
            searchEventViewHolder.eventItemView.setText(current.getDesc());
        } else {
            searchEventViewHolder.eventItemView.setText("No Event");
        }

        searchEventViewHolder.getEventItemView().setOnClickListener(view -> activityCompositeDisposable.add(
                modifyEventUseCase
                        .modifyEventAsync()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe()));
    }

    @Override
    public int getItemCount() {
        if (eventList != null) {
            return eventList.size();
        } else {
            return 0;
        }
    }

    void setEventList(List<Event> eventList) {
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    class SearchEventViewHolder extends RecyclerView.ViewHolder {

        private final TextView eventItemView;

        private SearchEventViewHolder(View itemView) {
            super(itemView);
            eventItemView = itemView.findViewById(R.id.textReclViewSearch);
        }

        public TextView getEventItemView() {
            return eventItemView;
        }
    }
}
