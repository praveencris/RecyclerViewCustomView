package com.example.recyclerviewcustomview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MusicAdapter.OnItemCLickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Music> musicList = new ArrayList<Music>();
        for (int i = 0; i < 10; i++) {
            Music music = new Music(R.drawable.ic_music_note_24, "Music Number is " + i + 1);
            musicList.add(music);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MusicAdapter musicAdapter = new MusicAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(musicAdapter);

        musicAdapter.setMusicArrayList(musicList);


    }

    @Override
    public void onItemClick(Music music) {
        Toast.makeText(this,music.getTitle(),Toast.LENGTH_SHORT).show();
    }
}