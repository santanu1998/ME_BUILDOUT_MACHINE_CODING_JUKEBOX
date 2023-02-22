package com.example.demo;

import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.AddSongToPlaylistCommand;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylistCommand;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.JukeboxCommandKeyword;
import com.example.demo.commands.JukeboxCommandRegistry;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListSongsCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.repositories.ArtistRepository;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IArtistRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepository;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepository;
import com.example.demo.services.GreetingService;
import com.example.demo.services.PlaylistService;
import com.example.demo.services.SongService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            // private final IGreetingRepository greetingRepository = new GreetingRepository();
            
            private final IPlaylistRepository playlistRepository = new PlaylistRepository();

            private final ISongRepository songRepository = new SongRepository();

            private final IArtistRepository artistRepository = new ArtistRepository();

            //private final Player player = new Player();
            //private final PlaylistService playlistService = new PlaylistService();

            // private final PlayerState playerState = new Player();

            

            // Initialize services
            // private final GreetingService greetingService = new GreetingService(greetingRepository);

            private final PlaylistService playlistService = new PlaylistService(playlistRepository, songRepository);

            private final SongService songService = new SongService(songRepository);


            private final AddSongCommand addSongCommand = new AddSongCommand(songService);
            private final AddSongToPlaylistCommand addSongToPlaylistCommand = new AddSongToPlaylistCommand(playlistService);
            private final CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);
            private final DeletePlaylistCommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
            private final DeleteSongFromPlaylistCommand deleteSongFromPlaylistCommand = new DeleteSongFromPlaylistCommand(playlistService);
            private final ListSongsCommand listSongsCommand = new ListSongsCommand(songService);
            private final LoadPlaylistCommand LoadPlaylistCommand = new LoadPlaylistCommand(playlistService);
            private final NextSongCommand nextSongCommand = new NextSongCommand(playlistService);
            private final PlaySongCommand playSongCommand = new PlaySongCommand(playlistService);
            private final PreviousSongCommand previousSongCommand = new PreviousSongCommand(playlistService);
            private final StopSongCommand stopSongCommand = new StopSongCommand(playlistService);

            // Initialize commands
            // private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            // private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            // private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);

            // Initialize commandRegistery
            // private final CommandRegistry commandRegistry = new CommandRegistry();

            private final JukeboxCommandRegistry jukeboxCommandRegistry = new JukeboxCommandRegistry();

            // Register commands 
            private void registerCommands(){
                // commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                // commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                // commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);

                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.ADD_SONG_COMMAND.getName(),addSongCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(),addSongToPlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.CREATE_PLAYLIST_COMMAND.getName(),createPlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.DELETE_PLAYLIST_COMMAND.getName(),deletePlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(),deleteSongFromPlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.LIST_SONGS_COMMAND.getName(),listSongsCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.LOAD_PLAYLIST_COMMAND.getName(),LoadPlaylistCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.PLAY_SONG_COMMAND.getName(),playSongCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.PREVIOUS_SONG_COMMAND.getName(),previousSongCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.NEXT_SONG_COMMAND.getName(),nextSongCommand);
                jukeboxCommandRegistry.registerCommand(JukeboxCommandKeyword.STOP_SONG_COMMAND.getName(),stopSongCommand);
            }
            
            // public CommandRegistry getCommandRegistry(){
            //     registerCommands();
            //     return commandRegistry;
            // }

            public JukeboxCommandRegistry getJukeboxCommandRegistry(){
                registerCommands();
                return jukeboxCommandRegistry;
            }
}
