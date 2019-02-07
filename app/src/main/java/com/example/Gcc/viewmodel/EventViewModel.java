package com.example.Gcc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import com.example.Gcc.data.source.local.Event;
import com.example.Gcc.data.source.local.EventRepository;

import java.util.List;

public class EventViewModel extends AndroidViewModel {

    private EventRepository eventRepository;

    private LiveData<List<Event>> allEvents;

    public EventViewModel(@NonNull Application application) {
        super(application);
        eventRepository = new EventRepository(application);
        allEvents = eventRepository.getAllEvents();
    }

    @NonNull
    @Override
    public <T extends Application> T getApplication() {
        return super.getApplication();
    }

    public LiveData<List<Event>> getAllEvents() {
        return allEvents;
    }

    public void insert(Event event){
        eventRepository.insert(event);
    }
}
