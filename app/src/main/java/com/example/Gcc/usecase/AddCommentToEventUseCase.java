package com.example.Gcc.usecase;

import com.example.Gcc.data.source.local.CommentRepository;
import com.example.Gcc.data.source.local.comment.Comment;
import io.reactivex.Completable;

public class AddCommentToEventUseCase {

    private CommentRepository commentRepository;

    public AddCommentToEventUseCase(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Completable addCommentOnEventRx(String comment, int idEvent) {
        return Completable.create(e -> commentOnEvent(comment, idEvent));
    }

    private void commentOnEvent(String comment, int idEvent) {
        Comment com = new Comment(comment, idEvent);
        commentRepository.insert(com);
    }
}
