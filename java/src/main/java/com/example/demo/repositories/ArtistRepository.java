package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Artist;

public class ArtistRepository implements IArtistRepository {

    private final Map<Long, Artist> artistMap;
    private Long autoIncrement = 1L;

    public ArtistRepository() {
        artistMap = new HashMap<>();
    }

    @Override
    public Artist save(Artist artist) {
        // Artist art = new Artist(autoIncrement,artist.getName());
        // artistMap.put(autoIncrement, art);
        // ++autoIncrement;
        // return art;

        if (artist.getId() == null) {
            Artist myArtist = new Artist(autoIncrement, artist.getName());
            artistMap.put(myArtist.getId(), myArtist);
            ++autoIncrement;
            return myArtist;
        }
        artistMap.put(artist.getId(), artist);
        return artist;
        
    }

    @Override
    public boolean existsById(Long id) {
        return artistMap.containsKey(id);
    }

    @Override
    public Optional<Artist> findById(Long id) {
        return Optional.ofNullable(artistMap.get(id));
    }

    @Override
    public List<Artist> findAll() {
        return artistMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        artistMap.remove(id);
    }

    @Override
    public long count() {
        return artistMap.size();
    }
    
}