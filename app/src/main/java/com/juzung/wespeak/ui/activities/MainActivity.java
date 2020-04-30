package com.juzung.wespeak.ui.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.juzung.wespeak.R;
import com.juzung.wespeak.adapters.PlaylistAdapter;
import com.juzung.wespeak.listeners.RecyclerViewItemClickListener;
import com.juzung.wespeak.models.PlaylistItem;
import com.juzung.wespeak.utils.Utils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewItemClickListener {
    private RecyclerView rcvPlaylist;
    private PlaylistAdapter adapter;
    private ArrayList<PlaylistItem> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init view
        rcvPlaylist = findViewById(R.id.rcv_playlist);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);
        flexboxLayoutManager.setJustifyContent(JustifyContent.CENTER);
        rcvPlaylist.setLayoutManager(flexboxLayoutManager);
        adapter = new PlaylistAdapter(this, this);
        rcvPlaylist.setAdapter(adapter);

        // Load sample data
        listData = Utils.loadSamples();
        // Set data to list
        adapter.setListData(listData);

        //TODO: Init media player
    }

    @Override
    public void onItemClickListener(View view, int pos) {
        // Execute when click on an item on List view
        playSoundAt(pos);
    }

    private void playSoundAt(int pos) {
        Log.d("MainActivity", "Item click at " + pos);
        // Get sound path from listData at pos
        String soundPath = listData.get(pos).getMediaPath();
        // Add sound to media player
        //TODO: Play media
    }
}
