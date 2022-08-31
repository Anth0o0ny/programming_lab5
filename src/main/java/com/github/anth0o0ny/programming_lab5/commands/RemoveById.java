package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.patterncommands.Command;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.Stack;

public class RemoveById implements Command {

    private final Receiver receiver;

    public RemoveById(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, Stack<Movie> collection, String argument) {
        if (!argument.isEmpty()) {
            return receiver.removeById(collection, argument);
        } else {
            return "Введите команду c аргументом.";
        }
    }

    @Override
    public String getHelp() {
        return "Введите \"remove_by_id id\", чтобы удалить элемент из коллекции по его id.";
    }
}
