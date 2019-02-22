package com.example.Gcc.dagger;

import com.example.Gcc.SearchEventActivity;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class, RepositoryModule.class, UseCaseModule.class})
public interface ApplicationComponent {

    void inject(SearchEventActivity searchEventActivity);

}
