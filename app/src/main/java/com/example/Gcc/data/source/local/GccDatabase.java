package com.example.Gcc.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Event.class}, version = 1)
public abstract class GccRoomDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

    private static volatile GccRoomDatabase INSTANCE;

    static GccRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (GccRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GccRoomDatabase.class, "gcc_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}