package com.github.anth0o0ny.programming_lab5.patterncommands;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;

import java.util.HashMap;

import java.util.Stack;

public class Invoker {
    private final HashMap<String, com.github.anth0o0ny.programming_lab5.patterncommands.Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command){
        commandMap.put(commandName, command);
    }
    public String execute(Invoker invoker, String commandName, Stack<Movie> collection, String argument){
        Command command = commandMap.get(commandName);
        return command.execute(invoker, collection, argument);
    }

    public HashMap<String, Command> getCommandMap() {
        return this.commandMap;
    }
}
