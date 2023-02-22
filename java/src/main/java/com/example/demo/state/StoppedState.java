package com.example.demo.state;

public class StoppedState implements PlayerState {
    private Player player;
    public StoppedState(Player player) {
        this.player=player;
    }

    public void play() {

        // int currentId = this.player.getCurrentSongId();
        player.setState(new PlayingState(player));
        player.setCurrentSongId(0);
        // this.player.setState(new PlayingState(this.player));
        System.out.println("Song [id="+player.getSongIds().get(0).toString()+"] is playing!");
   
    }

    public void stop() {
        // System.out.println("Player is already stopped!");
        System.out.println("Song [id=" + this.player.getCurrentSongId() + "] is stopped!");
    }

    public void next() {
        // ArrayList<Integer>songIds = this.player.getSongIds();
        int currentId = this.player.getCurrentSongId();
        // int nextId = (currentId + 1) %songIds.size();
        // this.player.setCurrentSongId(nextId);

    }

    public void previous() {
        // ArrayList<Integer>songIds = this.player.getSongIds();
        // int currentId = this.player.getCurrentSongId();
        // int previousId = (currentId - 1 +songIds.size()) %songIds.size();
        // this.player.setCurrentSongId(previousId);
    }
}
