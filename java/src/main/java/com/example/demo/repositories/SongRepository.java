package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository {

    private final Map<Long, Song> songMap;
    private Long autoIncrement = 1L;

    public SongRepository() {
        songMap = new HashMap<>();
    }

    @Override
    public Song save(Song song) {
        // Song play = new Song(autoIncrement,song.getName(), song.getAlbum(), song.getGenre(), song.getArtist());
        // songMap.put(autoIncrement, play);
        // ++autoIncrement;
        // return play;

        if(song.getId() == null){
            // autoIncrement++;
            Song songs = new Song(autoIncrement,song.getName(), song.getAlbum(), song.getGenre(), song.getArtist());
            songMap.put(songs.getId(), songs);
            ++autoIncrement;
            return songs;
        }
        songMap.put(song.getId(), song);
        return song;
    }

    @Override
    public boolean existsById(Long id) {
        return songMap.containsKey(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return Optional.ofNullable(songMap.get(id));
    }

    @Override
    public List<Song> findAll() {
        return songMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        songMap.remove(id);
    }

    @Override
    public long count() {
        return songMap.size();
    }
    
}
