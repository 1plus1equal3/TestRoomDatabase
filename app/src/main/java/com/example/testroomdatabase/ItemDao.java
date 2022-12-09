package com.example.testroomdatabase;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insert(SongItem... songItems);
    @Update
    void update(SongItem... songItems);
    @Delete
    void delete(SongItem... songItem);
    @Query(" SELECT * FROM Saved_Song ")
    List<SongItem> getSongItems();
}
