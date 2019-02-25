package com.example.Gcc.dagger;

import android.app.Application;
import com.example.Gcc.data.source.local.EventRepository;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    EventRepository provideEventRepository(Application application){
        return new EventRepository(application);
    }
}
