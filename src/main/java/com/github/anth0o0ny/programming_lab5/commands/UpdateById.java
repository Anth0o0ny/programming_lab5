package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.patterncommands.Command;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.Stack;

public class UpdateById implements Command {

    private final Receiver receiver;

    public UpdateById(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, Stack<Movie> collection, String argument) {
        if (!argument.isEmpty()) {
            return receiver.update(collection, argument);
        } else {
            return "Введите команду c аргументом.";
        }
    }

    @Override
    public String getHelp() {
        return "Введите \"update id\", чтобы обновить значение элемента коллекции, id которого равен заданному.";
    }
}
