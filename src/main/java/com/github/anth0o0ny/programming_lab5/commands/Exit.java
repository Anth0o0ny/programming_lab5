package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.patterncommands.Command;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.Stack;

public class Exit implements Command {
    private final Receiver receiver;

    public Exit(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, Stack<Movie> collection, String argument) {
        if (argument.isEmpty()) {
            return receiver.exit();
        } else {
            return "Введите команду без аргумента.";
        }
    }

    @Override
    public String getHelp() {
        return "Введите \"exit\", чтобы выйти из программы.";
    }
}
