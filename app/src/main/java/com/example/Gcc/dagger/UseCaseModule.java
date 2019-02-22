package com.example.Gcc.dagger;

import com.example.Gcc.usecase.ModifyEventUseCase;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class UseCaseModule {

    @Provides
    @Singleton
    ModifyEventUseCase provideModifyEventUseCase(){
        return new ModifyEventUseCase();
    }
}
