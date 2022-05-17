package com.github.anth0o0ny.programming_lab5;

import com.github.anth0o0ny.programming_lab5.baseclasses.*;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {

        Stack<Movie> collection = new Stack<>();
        Movie movie = new Movie(1, "Выживший", new Coordinates(4D, 5F), LocalDateTime.now(),
                8L, 888, "Выжить любой ценой", MpaaRating.NC_17, new Person("Ди каприо", 6,
               Color.BLACK, Country.GERMANY));
        Movie movie2 = new Movie(2, "Я - легенда", new Coordinates(6D, 9F), LocalDateTime.now(),
                8L, 888, "Выжить любой ценой", MpaaRating.NC_17, new Person("Вил Смит", 6,
                Color.BLACK, Country.GERMANY));
        Movie movie3 = new Movie(3, "Форрест Гамп", new Coordinates(4D, 5F), LocalDateTime.now(),
                8L, 888, "Ран, Форрест, Ран.", MpaaRating.NC_17, new Person("Том Хэнкс", 6,
                Color.BLACK, Country.GERMANY));
        collection.add(movie);
        collection.add(movie2);
        collection.add(movie3);


        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        CommandsRegistration.commandsRegistration(invoker, receiver);

        Scanner scanner = new Scanner(System.in);
        //        System.out.println(collection.getClass() + " |" + collection.size());
//        System.exit(0);


        System.out.println("Для вывода справки по командам введите \"help\".");
        String output = "";
        while (true) {
            String input;
            System.out.println("Введите команду:");
            input = scanner.nextLine();
            String[] cmdline = input.trim().split(" ");
            if (cmdline.length == 1) {
                String commandString = cmdline[0];
                output = invoker.execute(invoker, commandString, collection, "");
            } else if(cmdline.length == 2){
                String command = input.trim().split(" ")[0];
                String argument = input.trim().split(" ")[1];
                output = invoker.execute(invoker, command, collection, argument);
            } else {
                output = "Недопустимый формат команды. Введите команду без аргументов или же с одним аргументом";
            }
            if (output == null)
                break;
            System.out.println(output);
        }


    }
}
