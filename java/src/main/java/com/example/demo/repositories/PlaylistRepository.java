package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository {

    private final Map<Long, Playlist> playlistMap;
    private Long autoIncrement = 1L;

    public PlaylistRepository() {
        playlistMap = new HashMap<>();
    }

    @Override
    public Playlist save(Playlist playlist) {
        // Playlist play = new Playlist(autoIncrement,playlist.getName(), playlist.getSongs());
        // playlistMap.put(autoIncrement, play);
        // ++autoIncrement;
        // return play;

        if (playlist.getId() == null) {
            Playlist myPlaylist = new Playlist(autoIncrement,playlist.getName(), playlist.getSongs());
            playlistMap.put(myPlaylist.getId(), myPlaylist);
            autoIncrement++;
            return myPlaylist;
        }
        playlistMap.put(playlist.getId(), playlist);
        return playlist;
    }

    @Override
    public boolean existsById(Long id) {
        return playlistMap.containsKey(id);
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return Optional.ofNullable(playlistMap.get(id));
    }

    @Override
    public List<Playlist> findAll() {
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        playlistMap.remove(id);
    }

    @Override
    public long count() {
        return playlistMap.size();
    }
    
}
