package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.MoviesCollection;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.patterncommands.Command;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.Stack;

public class RemoveAllByScreenwriter implements Command {
    private final Receiver receiver;

    public RemoveAllByScreenwriter(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, Stack<Movie> collection, String argument, MoviesCollection moviesCollection) {
        if (!argument.isEmpty()) {
            return receiver.removeAllByScreenwriter(collection, argument);
        } else {
            return "Введите команду c аргументом.";
        }
    }

    @Override
    public String getHelp() {
        return "Введите \"remove_all_by_screenwriter screenwriter\", чтобы удалить из коллекции все элементы" +
                "по значению поля screenwriter.";
    }
}
