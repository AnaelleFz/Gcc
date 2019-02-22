package com.example.Gcc;

import android.app.Application;
import com.example.Gcc.dagger.DaggerSearchActivityComponent;
import com.example.Gcc.dagger.SearchActivityComponent;

public class GccApp extends Application {

    private SearchActivityComponent searchActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        searchActivityComponent = DaggerSearchActivityComponent.create();
    }

    public SearchActivityComponent getSearchActivityComponent() {
        return searchActivityComponent;
    }
}
