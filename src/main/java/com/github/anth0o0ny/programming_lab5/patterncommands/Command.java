package com.github.anth0o0ny.programming_lab5.patterncommands;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;

import java.util.Stack;

public interface Command {

    String execute(Invoker invoker, Stack<Movie> collection, String argument);

    String getHelp();
}