package com.example.Gcc;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.Gcc.data.source.local.event.Event;
import com.example.Gcc.usecase.AddCommentToEventUseCase;
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

    private Context context;

    private AddCommentToEventUseCase addCommentToEventUseCase;

    @Inject
    public ModifyEventUseCase modifyEventUseCase;

    public SearchEventListAdapter(Context context, CompositeDisposable compositeDisposable,
                                  ModifyEventUseCase modifyEventUseCase, AddCommentToEventUseCase addCommentToEventUseCase) {
        this.inflater = LayoutInflater.from(context);
        this.activityCompositeDisposable = compositeDisposable;
        this.modifyEventUseCase = modifyEventUseCase;
        this.addCommentToEventUseCase = addCommentToEventUseCase;
        this.context = context;
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
        searchEventViewHolder.getEventItemView().setOnClickListener(view -> showCommentDialog(eventList.get(position)));
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

    private void showCommentDialog(Event event) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.event_comment_pop_up);
        EditText editText = dialog.findViewById(R.id.editCommentText);
        Button dialogBtn = dialog.findViewById(R.id.buttonAddComment);
        dialogBtn.setOnClickListener(e -> {
            callAddCommentUseCase(editText.getText().toString(), event.getId());
            dialog.dismiss();
        });
        dialog.show();
    }

    private void callAddCommentUseCase(String comment, int idEvent) {
        activityCompositeDisposable.add(addCommentToEventUseCase
                .addCommentOnEventRx(comment, idEvent)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
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
