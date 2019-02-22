package com.example.Gcc.dagger;

import com.example.Gcc.data.source.local.EventRepository;
import com.example.Gcc.usecase.ModifyEventUseCase;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class UseCaseModule {

    /*
    @Provides
    @Singleton
    ModifyEventUseCase provideModifyEventUseCase(EventRepository eventRepository){
        return new ModifyEventUseCase(eventRepository);
    } */

    @Provides
    @Singleton
    ModifyEventUseCase provideModifyEventUseCase(){
        return new ModifyEventUseCase();
    }
}
