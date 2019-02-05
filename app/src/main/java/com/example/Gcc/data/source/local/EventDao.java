package com.example.Gcc.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

// todo refactor en kotlin
@Dao
public interface EventDao {

    @Insert
    void insert(Event event);

    @Query("DELETE FROM event_table")
    void deleteAll();

    @Query("SELECT * from event_table ORDER BY description ASC")
    List<Event> getAllEvents();
}