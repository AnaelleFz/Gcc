package com.example.Gcc;

import android.app.Application;
import com.example.Gcc.dagger.*;

public class GccApp extends Application {

    private SearchActivityComponent searchActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        searchActivityComponent = DaggerSearchActivityComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .repositoryModule(new RepositoryModule())
                .useCaseModule(new UseCaseModule())
                .build();
    }

    public SearchActivityComponent getSearchActivityComponent() {
        return searchActivityComponent;
    }
}
