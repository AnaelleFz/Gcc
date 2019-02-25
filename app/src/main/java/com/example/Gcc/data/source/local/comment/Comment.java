package com.example.Gcc.data.source.local.comment;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import com.example.Gcc.data.source.local.event.Event;

@Entity(tableName = "comment_table",
        foreignKeys = @ForeignKey(entity = Event.class, parentColumns = "id", childColumns = "event_id"))
public class Comment {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "event_id")
    private int eventId;

    public Comment(String content, int eventId) {
        this.content = content;
        this.eventId = eventId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
