package com.example.Gcc;

import android.app.Application;
import com.example.Gcc.dagger.ApplicationComponent;
import com.example.Gcc.dagger.DaggerApplicationComponent;

public class GccApp extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.create();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
