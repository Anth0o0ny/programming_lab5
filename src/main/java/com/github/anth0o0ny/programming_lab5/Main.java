package com.github.anth0o0ny.programming_lab5;


import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;



public class Main {

    public static void main(String[] args){

        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        CommandsRegistration.commandsRegistration(invoker, receiver);
        MoviesCollection mc = new MoviesCollection();
        Parser.parsingToObj(mc.getCollection());
        String path = System.getenv("path");
        InputTerminal inp = new InputTerminal(invoker,mc);
        inp.inputKeyboard();
        }
    }



