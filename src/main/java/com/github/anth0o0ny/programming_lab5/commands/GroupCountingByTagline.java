package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.MoviesCollection;
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
        return receiver.groupCountingByTagline(collection);
    }

    @Override
    public String getHelp() {
        return "Введите \"group_counting_by_tagline\", чтобы сгруппировать элементы коллекции по значению поля tagline," +
                " вывести количество элементов в каждой группе.";
    }
}