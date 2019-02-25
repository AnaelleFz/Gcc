package com.example.Gcc.data.source.local;

import android.app.Application;
import com.example.Gcc.data.source.local.comment.Comment;
import com.example.Gcc.data.source.local.comment.CommentDao;
import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

public class CommentRepository {

    private CommentDao commentDao;

    public CommentRepository(Application application) {
        GccRoomDatabase database = GccRoomDatabase.getDatabase(application);
        commentDao = database.commentDao();
    }

    public void insert(Comment comment) {
        Completable.create(emitter -> commentDao.insert(comment))
                .subscribeOn(Schedulers.io());
    }
}
