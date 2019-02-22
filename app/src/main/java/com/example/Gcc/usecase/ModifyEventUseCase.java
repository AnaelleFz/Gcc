package com.example.Gcc.usecase;

import com.example.Gcc.data.source.local.EventRepository;
import io.reactivex.Completable;

import javax.inject.Inject;

public class ModifyEventUseCase {

    @Inject
    EventRepository eventRepository;

    public Completable modifyEventAsync(){
        return Completable.create(e -> modifyEvent());
    }

    private void modifyEvent(){
        eventRepository.getAllEvents();
        System.out.println("dodo");
    }
}
