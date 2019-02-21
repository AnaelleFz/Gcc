package com.example.Gcc.data.source.local;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

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
                            .addCallback(sRoomDataBaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDataBaseCallback =
            new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>{
        private final EventDao dao;

        PopulateDbAsync(GccRoomDatabase db){
            dao = db.eventDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();

            Event event = new Event("Hello event");
            dao.insert(event);

            Event event2 = new Event("Hello event 2");
            dao.insert(event2);

            Event event3 = new Event("Hello event 3", 30);
            dao.insert(event3);

            Event event4 = new Event("Hello event 4", 45);
            dao.insert(event4);

            Event event5 = new Event("Hello event 5", 60);
            dao.insert(event5);

            return null;
        }
    }
}