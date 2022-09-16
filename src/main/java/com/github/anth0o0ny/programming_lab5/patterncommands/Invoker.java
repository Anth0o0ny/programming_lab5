package com.github.anth0o0ny.programming_lab5.patterncommands;

import com.github.anth0o0ny.programming_lab5.CommandsEnum;
import com.github.anth0o0ny.programming_lab5.StringConstants;
import com.github.anth0o0ny.programming_lab5.baseclasses.MoviesCollection;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.commands.*;

import javax.xml.bind.JAXBException;
import java.util.HashMap;

import java.util.Stack;

public class Invoker {
    private final HashMap<String, Command> commandsMap = new HashMap<>();

    public void registration(String commandName, Command command) {
        commandsMap.put(commandName, command);
    }



    public String execute(Invoker invoker, String commandName, Stack<Movie> collection, String argument, MoviesCollection moviesCollection) throws JAXBException {
        if (!commandsMap.containsKey(commandName)) {
            return StringConstants.PatternCommands.INVOKER_WRONG_COMMAND;
        }


        Command command = commandsMap.get(commandName);

        return command.execute(invoker, collection, argument, moviesCollection);
    }
    private Command create(Receiver receiver, CommandsEnum commandsEnum) {
        switch (commandsEnum){
            case HELP:
                return (new Help(receiver));
            case INFO:
                return (new Info(receiver));
            case SHOW:
                return (new Show(receiver));
            case ADD:
                return (new Add(receiver));
            case UPDATE:
                return (new UpdateById(receiver));
            case REMOVE_BY_ID:
                return (new RemoveById(receiver));
            case CLEAR:
                return (new Clear(receiver));
            case SAVE:
                return (new Save(receiver));
            case EXECUTE_SCRIPT:
                return (new ExecuteScript(receiver));
            case EXIT:
                return (new Exit(receiver));
            case INSERT_AT:
                return (new InsertAt(receiver));
            case ADD_IF_MIN:
                return (new AddIfMin(receiver));
            case SHUFFLE:
                return (new Shuffle(receiver));
            case REMOVE_ALL_BY_SCREENWRITER:
                return (new RemoveAllByScreenwriter(receiver));
            case GROUP_COUNTING_BY_TAGLINE:
                return (new GroupCountingByTagline(receiver));
            case PRINT_DESCENDING:
                return (new PrintDescending(receiver));
        }
        return null;
    }

    public HashMap<String, Command> getCommandMap() {
        return this.commandsMap;
    }
}
