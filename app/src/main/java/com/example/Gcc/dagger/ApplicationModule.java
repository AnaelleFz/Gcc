package com.example.Gcc.dagger;

import android.app.Application;
import com.example.Gcc.data.source.local.EventRepository;
import com.example.Gcc.usecase.ModifyEventUseCase;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application){
        this.application = application;
    }

    @Provides
    EventRepository provideEventRepository(Application application){
        return new EventRepository(application);
    }

    @Provides
    ModifyEventUseCase provideModifyEventUseCase(EventRepository eventRepository){
        return new ModifyEventUseCase(eventRepository);
    }
}
