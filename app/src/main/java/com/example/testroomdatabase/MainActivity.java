package com.example.testroomdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View's ids
        recyclerView = findViewById(R.id.rv);
        button = findViewById(R.id.button);

        SongDatabase database = Room.databaseBuilder(this, SongDatabase.class, "Song Database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        ItemDao itemDao = database.getItemDao();
        SongItem songItem = new SongItem();
        songItem.id = 1;
        songItem.name = "song_1";
        songItem.path = "song_1_path";

        //Set up recyclerView
        List<SongItem> songItems;
        songItems = itemDao.getSongItems();
        Adapter adapter = new Adapter(songItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemDao.insert(songItem);
                recyclerView.notifyAll();
            }
        });
    }
}

