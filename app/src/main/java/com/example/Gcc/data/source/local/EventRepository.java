package com.example.Gcc.data.source.local;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class EventRepository {

    private EventDao eventDao;

    private LiveData<List<Event>> allEvents;

    public EventRepository(Application application){
        GccRoomDatabase database = GccRoomDatabase.getDatabase(application);
        eventDao = database.eventDao();
        allEvents = eventDao.getAllEvents();
    }

    public LiveData<List<Event>> getAllEvents(){
        return allEvents;
    }

    public void insert(Event event){
        new insertAsyncTask(eventDao).execute(event);
    }

    // todo faire avec rx
    private static class insertAsyncTask extends AsyncTask<Event, Void, Void> {

        private EventDao mAsyncTaskDao;

        insertAsyncTask(EventDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Event... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }


    }

}
