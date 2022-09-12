package com.github.anth0o0ny.programming_lab5;


import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.NoSuchElementException;


public class Main {

    public static void main(String[] args) {

        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        CommandsRegistration.commandsRegistration(invoker, receiver);
        MoviesCollection mc = new MoviesCollection();
        String pathToFile = System.getenv("pathToFile");

        Parser.parsingToObj(mc.getCollection(), pathToFile);

        Terminal inp = new Terminal(invoker, mc);
        try {
            inp.inputKeyboard();
        } catch (NoSuchElementException ex) {
            System.exit(0);
        }
    }
}



