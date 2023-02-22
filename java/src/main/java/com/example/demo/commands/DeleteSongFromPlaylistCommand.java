package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlaylistService;

public class DeleteSongFromPlaylistCommand implements ICommand {

    private final PlaylistService playlistService;

    public DeleteSongFromPlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Long songId = Long.parseLong(tokens.get(2));
        String deleteSongFromPlaylist = playlistService.deleteSongFromPlaylist(playlistName, songId);
        System.out.println(deleteSongFromPlaylist);
    }
    
}
