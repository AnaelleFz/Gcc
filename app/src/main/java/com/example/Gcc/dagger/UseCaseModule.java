package com.example.Gcc.dagger;

import com.example.Gcc.data.source.local.CommentRepository;
import com.example.Gcc.data.source.local.EventRepository;
import com.example.Gcc.usecase.AddCommentToEventUseCase;
import com.example.Gcc.usecase.ModifyEventUseCase;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class UseCaseModule {

    @Provides
    @Singleton
    ModifyEventUseCase provideModifyEventUseCase(EventRepository eventRepository){
        return new ModifyEventUseCase(eventRepository);
    }

    @Provides
    @Singleton
    AddCommentToEventUseCase provideAddCommentToEventUseCase(CommentRepository commentRepository){
        return new AddCommentToEventUseCase(commentRepository);
    }

}
