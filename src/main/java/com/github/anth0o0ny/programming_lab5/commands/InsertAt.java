package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.CommandsEnum;
import com.github.anth0o0ny.programming_lab5.StringConstants;
import com.github.anth0o0ny.programming_lab5.baseclasses.MoviesCollection;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.patterncommands.Command;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.Stack;

public class InsertAt implements Command {

    private final Receiver receiver;

    public InsertAt(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public String execute(Invoker invoker, Stack<Movie> collection, String argument, MoviesCollection moviesCollection) {
        if (!argument.isEmpty()) {
            return receiver.insertAt(collection, argument);
        } else {
            return StringConstants.Commands.CMD_WITH_ARG;
        }
    }


    @Override
    public String getHelp() {
        return CommandsEnum.INSERT_AT.commandName + " index : " + StringConstants.Commands.INSERT_AT_HELP;
    }
}
