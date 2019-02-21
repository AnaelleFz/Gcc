package com.example.Gcc.usecase;

import com.example.Gcc.data.source.local.Event;
import io.reactivex.Completable;

public class ModifyEventUseCase {

    private ModifyEventUseCase(){}

    private static ModifyEventUseCase instance;

    public static ModifyEventUseCase getInstance(){
        if(instance == null){
            instance = new ModifyEventUseCase();
        }
        return instance;
    }

    public Completable modifyEventAsync(Event event){
        return Completable.create(e -> modifyEvent(event));
    }

    private void modifyEvent(Event event){

    }
}
