package com.github.anth0o0ny.programming_lab5.patterncommands;

import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;

import java.util.Collections;
import java.util.Stack;

public class Receiver {


    public String exit() {
        System.out.println("Спасибо за работу, до свидания!");
        return null;
    }

    public String help(Invoker invoker) {
        StringBuilder ret = new StringBuilder();
        for (Command command : invoker.getCommandMap().values()) {
            ret.append(command.getHelp()).append('\n');
        }
        return ret.toString();
    }

    public String clear(Stack<Movie> collection) {
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

    public String info(Stack<Movie> collection) {
        return "Тип коллекции: " + collection.getClass() +
                "\nКоличество элементов: " + collection.size() +
                "\nДата инициализации: " + "пока нет";
    }

    public String shuffle(Stack<Movie> collection) {
        if (collection.isEmpty()) {
            return "Коллекция пуста.";
        } else {
            Collections.shuffle(collection);
            StringBuilder stringBuilder = new StringBuilder();
            for (Movie movie : collection) {
                stringBuilder.append(movie).append("; ");
            }
            return stringBuilder.toString();
        }
    }

    public String printDescending(Stack<Movie> collection) {
        if (collection.isEmpty()) {
            return "Коллекция пуста.";
        } else {
            Stack<Movie> cl = new Stack<>();
            cl.addAll(collection);
            Collections.reverse(cl);
            StringBuilder stringBuilder = new StringBuilder();
            for (Movie movie : cl) {
                stringBuilder.append(movie).append("; ");
            }
            return stringBuilder.toString();
        }
    }
}

