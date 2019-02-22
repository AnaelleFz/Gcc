package com.example.Gcc.dagger;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApplicationModule {

    private final Application app;

    public ApplicationModule(Application app){
        this.app = app;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return app;
    }

}
