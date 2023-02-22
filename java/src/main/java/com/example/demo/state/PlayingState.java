package com.example.demo.state;

import java.util.List;

public class PlayingState implements PlayerState {
    private Player player;
    // private Integer currentIndex=2;

    public PlayingState(Player player) {
        this.player = player;
    }

    public void play() {

        //System.out.println(nextSong);
        // int currentId = this.player.getCurrentSongId();
        // currentId+=1;
        
        System.out.println("Song [id=" + player.getSongIds().get(player.getCurrentSongId()) + "] is paused!");

        this.player.setState(new PausedState(this.player));
    
        // System.out.println("Song [id=" + currentIndex + "] is paused!");
    }

    public void stop() {
        // this.player.setState(new StoppedState(this.player));

        // System.out.println("Song [id=" + currentIndex + "] is stopped!");
    }

    public void next() {
        // List<Long> songIds = this.player.getSongIds();
        // this.player.setCurrentSongId(1);
        // currentIndex+=2;
       
        int nextSong = player.getCurrentSongId()+1;
        //System.out.println(nextSong);
        player.setCurrentSongId(nextSong);
        // int currentId = this.player.getCurrentSongId();
        // currentId+=1;
        
        System.out.println("Song [id=" + player.getSongIds().get(nextSong) + "] is playing!");
    }

    public void previous() {

        int nextSong = player.getCurrentSongId()-1;
        //System.out.println(nextSong);
        player.setCurrentSongId(nextSong);
        // int currentId = this.player.getCurrentSongId();
        // currentId+=1;
        
        System.out.println("Song [id=" + player.getSongIds().get(nextSong) + "] is playing!");
        // List<Long> songIds = this.player.getSongIds();

        // currentIndex-=2;
        // int currentId = this.player.getCurrentSongId();
        // currentId-=1;
        // int previousId = (currentId - 1 + songIds.size()) % songIds.size();
        // this.player.setCurrentSongId(previousId);
        // System.out.println("Song [id=" + (currentIndex) + "] is playing!");
    }
}
