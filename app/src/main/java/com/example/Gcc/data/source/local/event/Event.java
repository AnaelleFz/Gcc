package com.example.Gcc.data.source.local.event;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "event_table")
public class Event {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "desc")
    private String desc;

    @ColumnInfo(name = "nbDay")
    private int nbDay;

    @Ignore
    public Event(String desc){
        this.desc = desc;
    }

    public Event(String desc, int nbDay){
        this.desc = desc;
        this.nbDay = nbDay;
    }

    public String getDesc(){
        return this.desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }

    public int getNbDay() {
        return nbDay;
    }

    public void setNbDay(int nbDay) {
        this.nbDay = nbDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
