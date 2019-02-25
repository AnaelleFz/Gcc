package com.example.Gcc.data.source.local.comment;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Comment comment);

    @Query("SELECT * from comment_table WHERE event_id = :eventId ORDER BY id DESC")
    LiveData<List<Comment>> getCommentsFromEvent(int eventId);
}
