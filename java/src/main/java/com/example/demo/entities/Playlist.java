package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist {
    private Long id;
    private String name;
    private List<Song> songs;

    public Playlist(){}
    
    public Playlist(Long id, String name, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
    }

    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = songs;
    }

    public Playlist(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public List<Long> getSongIds() {
        List<Long> songIds = new ArrayList<>();
        for (Song song : songs) {
            songIds.add(song.getId());
        }
        return songIds;
    }
 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void add(Song song) {
        songs.add(song);
    }

    public void remove(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist playlist = (Playlist) o;

        if (id != playlist.id) return false;
        if (!Objects.equals(name, playlist.name)) return false;
        return Objects.equals(songs, playlist.songs);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (songs != null ? songs.hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
}
