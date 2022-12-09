package com.example.testroomdatabase;



import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Saved_Song")
public class SongItem {
    @PrimaryKey
    public int id;
    public String name;
    public String path;

}
