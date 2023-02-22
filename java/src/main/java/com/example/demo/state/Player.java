package com.example.demo.state;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistService;

public class Player {
    private List<Long> songIds;
    private int currentSongId;
    private Playlist currentPlaylist;
    private PlaylistService playlistService;
    private PlayerState state;
    private int id;

    public Player() {
        //this.currentSongId = null;
        // this.currentPlaylist = null;
        this.state = new StoppedState(this);
        this.songIds = new ArrayList<>();
    }


    
    public List<Long> getsongIds() {
        return songIds;
    }

    public void setsongIds(List<Long> songIds) {
        this.songIds = songIds;
    }

    // public void loadPlaylist(String playlistName) {
    //     this.currentPlaylist = Playlist.getPlaylist(playlistName);
    //     this.songIds = this.currentPlaylist.getSongIds();
    //     System.out.println("Playlist " + playlistName + " is loaded!");
    // }

    // public String loadPlaylist(String playlistName) {
    //     Playlist playlist = new Playlist();
    //     if (playlist.getName().equals(playlistName)) {
    //         currentPlaylist = playlist;
    //     }
    //     this.songIds = currentPlaylist.getSongIds();
    //     this.id = this.songIds.get(currentSongId).intValue();
    //     this.state = new StoppedState(this);
    //     // for (Playlist play : playlist) {
    //     //     if (play.getName().equals(playlistName)) {
    //     //         Playlist currentPlaylist = play;
    //     //         break;
    //     //     }
    //     // }
    //     return "Playlist" + playlistName + " is loaded!";
    // }

    public void play() {
        this.state.play();
    }

    public void stop() {
        this.state.stop();
    }

    public void next() {
        this.state.next();
    }

    public void previous() {
        this.state.previous();
    }

    // public void setCurrentSongId(int id) {
    //     this.currentSongId = id;
    //     System.out.println("Song [id=" + id + "] is playing!");
    // }

    public List<Long> getSongIds() {
        return this.songIds;
    }

    public int getCurrentSongId() {
        return this.currentSongId;
    }

    public Playlist getCurrentPlaylist() {
        return this.currentPlaylist;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public void setCurrentSongId(int currentSongId) {
        this.currentSongId = currentSongId;
    }
}
