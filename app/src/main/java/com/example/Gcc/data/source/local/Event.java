package com.example.Gcc.data.source.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "event_table")
public class Event {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "desc")
    private String desc;

    public Event(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }
}
