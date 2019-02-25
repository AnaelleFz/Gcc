package com.example.Gcc.data.source.local;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.example.Gcc.data.source.local.comment.Comment;
import com.example.Gcc.data.source.local.comment.CommentDao;
import com.example.Gcc.data.source.local.event.Event;
import com.example.Gcc.data.source.local.event.EventDao;

@Database(entities = {Event.class, Comment.class}, version = 1)
public abstract class GccRoomDatabase extends RoomDatabase {

    public abstract EventDao eventDao();

    public abstract CommentDao commentDao();

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
        private final EventDao eventDao;
        private final CommentDao commentDao;

        PopulateDbAsync(GccRoomDatabase db){
            eventDao = db.eventDao();
            commentDao = db.commentDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            eventDao.deleteAll();

            Event event = new Event("Hello event");
            eventDao.insert(event);

            Event event2 = new Event("Hello event 2");
            eventDao.insert(event2);

            Event event3 = new Event("Hello event 3", 30);
            eventDao.insert(event3);

            Event event4 = new Event("Hello event 4", 45);
            eventDao.insert(event4);

            Event event5 = new Event("Hello event 5", 60);
            eventDao.insert(event5);

            return null;
        }
    }
}