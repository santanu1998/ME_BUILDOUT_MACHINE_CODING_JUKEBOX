package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Artist;

public interface IArtistRepository {
    Artist save(Artist artist);
    boolean existsById(Long id);
    Optional<Artist> findById(Long id);
    List<Artist> findAll();
    void deleteById(Long id);
    long count();
}
