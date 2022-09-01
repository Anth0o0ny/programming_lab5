package com.github.anth0o0ny.programming_lab5.commands;

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
    public String execute(Invoker invoker, Stack<Movie> collection, String argument) {
        if (!argument.isEmpty()) {
            return receiver.insertAt(collection, argument);
        } else {
            return "Введите команду c аргументом.";
        }
    }


    @Override
    public String getHelp() {
        return "Введите \"insert_at index\", чтобы добавить новый элемент в заданную позицию.";
    }
}
