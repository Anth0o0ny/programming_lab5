package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.MoviesCollection;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.patterncommands.Command;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import javax.xml.bind.JAXBException;
import java.util.Stack;

public class Save implements Command {
    private final Receiver receiver;

    public Save(Receiver receiver) {
        this.receiver = receiver;
    }
    @Override
    public String execute(Invoker invoker, Stack<Movie> collection, String argument, MoviesCollection moviesCollection) throws JAXBException {
        if (argument.isEmpty()) {
            return receiver.save(moviesCollection);
        } else {
            return "Введите команду без аргумента.";
        }
    }

    @Override
    public String getHelp() {
        return "Введите save, чтобы сохранить коллекцию в файл";
    }
}