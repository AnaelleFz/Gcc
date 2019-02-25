package com.example.Gcc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.example.Gcc.data.source.local.Event;
import com.example.Gcc.data.source.local.EventRepository;

import java.util.List;

public class SearchActivityViewModel extends AndroidViewModel {

    private EventRepository eventRepository;

    private LiveData<List<Event>> eventsSup30;

    public SearchActivityViewModel(@NonNull Application application) {
        super(application);
        eventRepository = new EventRepository(application);
        eventsSup30 = eventRepository.getEventsSup30();
    }

    @NonNull
    @Override
    public <T extends Application> T getApplication() {
        return super.getApplication();
    }

    public LiveData<List<Event>> getEventsSup30() {
        return eventsSup30;
    }

    public void setEventsSup30(LiveData<List<Event>> eventsSup30) {
        this.eventsSup30 = eventsSup30;
    }
}
