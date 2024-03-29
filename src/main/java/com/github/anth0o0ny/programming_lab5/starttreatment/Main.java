package com.github.anth0o0ny.programming_lab5.starttreatment;


import com.github.anth0o0ny.programming_lab5.baseclasses.MoviesCollection;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.NoSuchElementException;


public class Main {

    public static void main(String[] args){

        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker(receiver);
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



