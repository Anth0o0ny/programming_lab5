package com.github.anth0o0ny.programming_lab5.patterncommands;

//import com.github.anth0o0ny.programming_lab5.ObjectsAdder;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.movieMaking.AddMovie;

import java.util.*;

public class Receiver {

    private final java.util.Date creationDate;


    public Receiver() {
        creationDate = new Date();
    }


    private String argument;

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
                "\nДата инициализации: " + creationDate;
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

    public String groupCountingByTagline(Stack<Movie> collection) {
        if (collection.isEmpty()) {
            return "Коллекция пуста.";
        } else {
            ArrayList<String> list = new ArrayList<>();
            for (Movie movie : collection) {
                list.add(movie.getTagline());
            }

            Set<String> st = new HashSet<>(list);
            for (String s : st)
                System.out.println("\"" + s + "\"" + ": " + Collections.frequency(list, s));
        }
        return "";
    }

    public String removeById(Stack<Movie> collection, String argument) {

        this.argument = argument;
        String str = "";
        if (collection.isEmpty()) {
            return "Коллекция пуста.";
        } else {
            for (Movie movie : collection) {
                if (String.valueOf(movie.getId()).equals(argument)) {
                    collection.remove(movie);
                    str = "Удален объект с id = " + argument + ".";
                    break;

                } else {
                    str = "Введите существующее значение id";
                }
            }
            return str;
        }
    }

    public String removeAllByScreenwriter(Stack<Movie> collection, String argument) {
        boolean flag = false;
        if (collection.isEmpty()) {
            return "Коллекция пуста.";
        } else {
            List<Movie> found = new ArrayList<>();
            for (Movie movie : collection) {
                if (String.valueOf(movie.getScreenwriter()).equals(argument)) {
                    found.add(movie);
                    flag = true;
                }
            }
            if (flag) {
                collection.removeAll(found);
                return "Все элементы со значением поля screenwriter = " + argument + " удалены.";
            } else {
                return "Элементов со значением поля screenwriter = " + argument + " не найдено.";
            }
        }
    }

    public String add(Stack<Movie> collection) {
        return AddMovie.addMovie(collection);
    }
    public  String addIfMin(Stack<Movie> collection){
        return AddMovie.AddMovieIfMin(collection);
    }
}





