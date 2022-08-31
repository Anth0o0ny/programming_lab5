package com.github.anth0o0ny.programming_lab5.patterncommands;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;

import java.util.HashMap;

import java.util.Stack;

public class Invoker {
    private final HashMap<String, Command> commandsMap = new HashMap<>();

    public void registration(String commandName, Command command) {
        commandsMap.put(commandName, command);
    }

    public String execute(Invoker invoker, String commandName, Stack<Movie> collection, String argument) {
        if (!commandsMap.containsKey(commandName)) {
            return "Введена несуществующая команда.";
        }
        Command command = commandsMap.get(commandName);
        return command.execute(invoker, collection, argument);
    }

    public HashMap<String, Command> getCommandMap() {
        return this.commandsMap;
    }
}
