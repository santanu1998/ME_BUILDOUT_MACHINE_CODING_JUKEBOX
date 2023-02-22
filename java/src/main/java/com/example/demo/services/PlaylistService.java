package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Song;
import com.example.demo.exceptions.SongNotFoundException;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.state.Player;

public class PlaylistService {

    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;
    List<Playlist> playlist = new ArrayList<>(); 
    private Playlist currentPlaylist;
    private int currentSongIndex;
    Player player;
    private boolean isPlaying = false;

    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
        this.player = new Player();
    }

    public Playlist createPlaylist(String playlistName, List<Long> songId) {
        List<Song> songList = new ArrayList<>();

        for (Long id : songId) {
            Song song = songRepository.findById(id).orElseThrow(()-> new SongNotFoundException("Cannot find song. Song id- "+songId+" is not present!"));
            songList.add(song);
        }

        Playlist playlist = new Playlist(playlistName, songList);
        Playlist resultantPlaylist = playlistRepository.save(playlist);

        // List<Playlist> oldPlaylist = owner.getPlaylist();
        // if(oldPlaylist==null){
        //     List<Playlist> newPlaylist = new ArrayList<>();
        //     newPlaylist.add(resultantPlaylist);
        //     owner.setPlaylist(newPlaylist);
        // }else{
        //     oldPlaylist.add(resultantPlaylist);
        //     owner.setPlaylist(oldPlaylist);
        // }    

        //return "Playlist [id=" + resultantPlaylist.getId() + "]";
        return resultantPlaylist;
    }

    public String addSongToPlaylist(String playlistName, Long songId) {
        // Playlist playlist = new Playlist(songId, playlistName);
        
        // Here, add the songId to the existing playlist and save it using save() method of repository
        // This is incomplete code, change it according to line above.
        Song songs = songRepository.findById(songId).get();
        //List<Song> s = new ArrayList<>();
        Playlist playlist =  playlistRepository.findAll().stream().filter(t->t.getName().equals(playlistName)).findFirst().get();
       // s.add(songs);
        playlist.add(songs);
        return "Playlist " + playlist.getName() + " is revised with " + playlist.getSongs().toString();
    }

    public String deleteSongFromPlaylist(String playlistName, Long songId) {
//playlistRepository.deleteById(songId);

        Playlist playlist =  playlistRepository.findAll().stream().filter(t->t.getName().equals(playlistName)).findFirst().get();
        Song song = playlist.getSongs().stream().filter(t->t.getId().equals(songId)).findFirst().get();
        playlist.getSongs().remove(song);
        return "Playlist " + playlistName + " is revised with " + playlist.getSongs().toString();
    }

    public String deletePlaylist(String playlistName) {
        // List<Playlist> playlist = playlistRepository.findAll();
        // for (int i = 0; i < playlist.size(); i++) {
        //     if (playlist.get(i).getName().equals(playlistName)) {
        //         playlist.remove(i);
        //         break;
        //     }
        // }

        for (Playlist playlist : playlistRepository.findAll()) {
            if (playlist.getName().equals(playlistName)) {
                playlistRepository.deleteById(playlist.getId());
                break;
            }
        }

        //System.out.println("Playlist"+" " + playlistName + " is deleted!");
        return "Playlist"+" " + playlistName + " is deleted!";
    }

    // public String loadPlaylist(String playlistName) {
    //     for (Playlist play : playlist) {
    //         if (play.getName().equals(playlistName)) {
    //             Playlist currentPlaylist = play;
    //             break;
    //         }
    //     }
    //     return "Playlist" + playlistName + " is loaded!";
    // }

    public String loadPlaylist(String playlistName) {

        //Player player = new Player();
        //System.out.println(playlistRepository.findAll());
        currentPlaylist = playlistRepository.findAll().stream().filter(t->t.getName().equals(playlistName)).findFirst().get();
        //player.setsongIds(playlist.getSongIds());

        player.setsongIds(currentPlaylist.getSongIds());

        return "Playlist " + currentPlaylist.getName() + " is loaded!";
    }

    // public void loadPlaylist(String playlistName) {
    //     for (Playlist playlists : playlist) {
    //         if (playlists.getName().equals(playlistName)) {
    //             currentPlaylist = playlists;
    //             currentSongIndex = 0;
    //             System.out.println("Playlist " + playlistName + " is loaded!");
    //             break;
    //         }
    //     }
    // }

    public void setPlaylist(List<Playlist> playlist) {
        this.playlist = playlist;
    }

    public List<Playlist> getPlaylist() {
        return playlist;
    }

    public void playSong() {
        if (currentPlaylist == null) {
            System.out.println("No playlist is loaded!");
            return;
        }
        player.play();
        // Song currentSong = currentPlaylist.getSongs().get(currentSongIndex);
        // System.out.println(currentSong + " is playing!");
        // isPlaying = true;
        // if (isPlaying) {
        //     System.out.println(currentSong + " is paused!");
        // }
    }

    public void nextSong() {
        if (currentPlaylist == null) {
            System.out.println("No playlist is loaded!");
            return;
        }
        // currentSongIndex = (currentSongIndex + 1) % currentPlaylist.getSongs().size();
        // playSong();
        player.next();
    }

    public void previousSong() {
        if (currentPlaylist == null) {
            System.out.println("No playlist is loaded!");
            return;
        }
        // currentSongIndex = (currentSongIndex - 1 + currentPlaylist.getSongs().size()) % currentPlaylist.getSongs().size();
        // playSong();
        player.previous();
    }

    public void stopSong() {
        if (currentPlaylist == null) {
            System.out.println("No playlist is loaded!");
            return;
        }
        // System.out.println(currentPlaylist.getSongs().get(currentSongIndex) + " is stopped!");
        // isPlaying = false;
        player.stop();
    }
}
