package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.CommandsEnum;
import com.github.anth0o0ny.programming_lab5.StringConstants;
import com.github.anth0o0ny.programming_lab5.baseclasses.MoviesCollection;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.patterncommands.Command;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.Stack;

public class GroupCountingByTagline implements Command {

    private final Receiver receiver;
    public GroupCountingByTagline(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, Stack<Movie> collection, String argument, MoviesCollection moviesCollection) {
        if (argument.isEmpty()) {
            return receiver.groupCountingByTagline(collection);
        } else {
            return StringConstants.Commands.CMD_WITHOUT_ARG;
        }
    }

    @Override
    public String getHelp() {
        return CommandsEnum.GROUP_COUNTING_BY_TAGLINE.commandName + " : " + StringConstants.Commands.GROUP_COUNTING_BY_TAGLINE_HELP;
    }
}