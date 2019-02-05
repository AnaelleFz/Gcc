package com.example.Gcc.data.source.local

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "event_table")
class Event(var idEvent : Long, var desc : String){

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Long = idEvent;

    var description: String = desc;
}