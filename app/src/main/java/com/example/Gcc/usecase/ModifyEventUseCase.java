package com.example.Gcc.usecase;

import com.example.Gcc.data.source.local.Event;
import com.example.Gcc.data.source.local.EventRepository;
import io.reactivex.Completable;

public class ModifyEventUseCase {

    private EventRepository eventRepository;

    public ModifyEventUseCase(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public Completable modifyEventAsync(Event event){
        return Completable.create(e -> modifyEvent(event));
    }

    private void modifyEvent(Event event){

    }
}
