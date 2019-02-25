package com.example.Gcc.usecase;

import com.example.Gcc.data.source.local.EventRepository;
import io.reactivex.Completable;

public class ModifyEventUseCase {

    EventRepository eventRepository;

    public ModifyEventUseCase(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }

    public Completable modifyEventAsync() {
        return Completable.create(e -> modifyEvent());
    }

    private void modifyEvent() {
        eventRepository.getAllEvents();
        System.out.println("dodo");
    }
}
