package com.example.demo.state;

import java.util.List;

public class PausedState implements PlayerState{
    private Player player;

    public PausedState(Player player) {
        this.player = player;
    }

    public void play() {
        //this.player.setState(new PlayingState(this.player));
        // System.out.println("Song [id=" + this.player.getCurrentSongId() + "] is playing!");
       // int nextSong = player.getCurrentSongId()+1;
        //System.out.println(nextSong);
       // player.setCurrentSongId(nextSong);

    }

    public void stop() {

        // int nextSong = player.getCurrentSongId()+1;
        //System.out.println(nextSong);
        // player.setCurrentSongId(nextSong);
        // int currentId = this.player.getCurrentSongId();
        // currentId+=1;

        System.out.println("Song [id=" + player.getSongIds().get(player.getCurrentSongId()) + "] is stopped!");

        this.player.setState(new StoppedState(this.player));
    }

    public void next() {
        // List<Long> songIds = this.player.getSongIds();
        int currentId = this.player.getCurrentSongId();
        // int nextId = (currentId + 1) %songIds.size();
        // this.player.setCurrentSongId(nextId);
        System.out.println("Song [id=" + (currentId + 1) + "] is playing!");
    }

    public void previous() {
        // List<Long>songIds = this.player.getSongIds();
        int currentId = this.player.getCurrentSongId();
        // int previousId = (currentId - 1 +songIds.size()) %songIds.size();
        // this.player.setCurrentSongId(previousId);
        System.out.println("Song [id=" + (currentId - 1) + "] is playing!");
    }
}
