package com.example.demo.entities;

import java.util.Objects;

public class Song {
    private Long id;
    private String name;
    private String genre;
    private String album;
    private String artist;

    public Song(Long id, String name, String album, String genre, String artist) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.genre = genre;
        this.artist = artist;
    }

    public Song(Long id, String name, String album, String genre) {
        this.id = id;
        this.name = name;
        this.album = album;
        this.genre = genre;
    }

    public Song(String name, String album, String genre, String artist) {
        this.name = name;
        this.album = album;
        this.genre = genre;
        this.artist = artist;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        if (id != song.id) return false;
        if (!Objects.equals(name, song.name)) return false;
        if (!Objects.equals(album, song.album)) return false;
        if (!Objects.equals(genre, song.genre)) return false;
        return Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (album != null ? album.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        return result;
    }



    @Override
    public String toString() {
        return "Song [id=" + id + "]";
        // return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", album=" + album + ", genre=" + genre + "]";
    }
        
}