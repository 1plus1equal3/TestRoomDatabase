package com.example.testroomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<SongItem> songItems;

    public Adapter(List<SongItem> songItems) {
        this.songItems = songItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       holder.songName.setText(songItems.get(position).name);
       holder.songPath.setText(songItems.get(position).path);
    }

    @Override
    public int getItemCount() {
        return songItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView songName, songPath;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songName = itemView.findViewById(R.id.song_name);
            songPath = itemView.findViewById(R.id.song_path);
        }
    }
}
