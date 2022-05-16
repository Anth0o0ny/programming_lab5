package com.github.anth0o0ny.programming_lab5.patterncommands;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;

import java.util.Stack;

public class Receiver {


    public String exit(){
        System.out.println("Спасибо за работу, до свидания!");
        return null;
    }

    public String help(Invoker invoker) {
        String ret = "";
        for (Command command : invoker.getCommandMap().values()) {
            ret += command.getHelp() + '\n' ;
        }
        return ret;
    }
    public String clear(Stack<Movie> collection){
        collection.clear();
        return "Коллекция очищена.";
    }
    public String show(Stack<Movie> collection) {
        if (collection.isEmpty()) {
            return "Коллекция пуста.";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Movie movie : collection) {
                stringBuilder.append(movie).append("; ");
            }
            return stringBuilder.toString();
        }
    }
}
