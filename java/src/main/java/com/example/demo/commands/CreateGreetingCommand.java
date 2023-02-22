package com.example.demo.commands;

import java.util.List;

import com.example.demo.entities.Greeting;
import com.example.demo.services.GreetingService;

public class CreateGreetingCommand implements ICommand{

    private final GreetingService greetingService; 

    public CreateGreetingCommand(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override //[ADD_SONG, Song_1, Artist_1, Album_1, Genre_1] [0, 1, 2, 3, 4, 5]

    public void invoke(List<String> tokens) {
        String message = tokens.get(1);
        Greeting createGreet = greetingService.create(message);
        System.out.println(createGreet);
    }
    
}
