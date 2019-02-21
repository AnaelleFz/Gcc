package com.example.Gcc.data.source.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import java.util.List;

// todo refactor en kotlin
@Dao
public interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Event event);

    @Query("DELETE FROM event_table")
    void deleteAll();

    @Query("SELECT * from event_table ORDER BY `desc` ASC")
    LiveData<List<Event>> getAllEvents();

    @Query("SELECT * from event_table WHERE nbDay > 30  ORDER BY `desc` ASC")
    LiveData<List<Event>> getEventDaySup30();
}