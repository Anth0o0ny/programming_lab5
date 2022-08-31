package com.github.anth0o0ny.programming_lab5;

import com.github.anth0o0ny.programming_lab5.baseclasses.*;
import com.github.anth0o0ny.programming_lab5.baseclasses.Color;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.Date;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Stack<Movie> collection = new Stack<>();

        // Test input
        Movie movie = new Movie((long) (Math.random() * 1_000_000_000 + 1), "Я - легенда", new Coordinates(4D, 5F), new Date(),
                9L, 888, "Выжить любой ценой", MpaaRating.NC_17, new Person("Ди каприо", 6,
                Color.BLACK, Country.GERMANY));
        Movie movie2 = new Movie((long) (Math.random() * 1_000_000_000 + 1), "Выживший", new Coordinates(6D, 9F), new Date(),
                8L, 888, "Выжить любой ценой", MpaaRating.NC_17, new Person("Bobs", 6,
                Color.BLACK, Country.GERMANY));
        Movie movie3 = new Movie((long) (Math.random() * 1_000_000_000 + 1), "Форрест Гамп", new Coordinates(4D, 5F), new Date(),
                6L, 888, "Ран, Форрест, Ран.", MpaaRating.NC_17, new Person("Bobs", 6,
                Color.BLACK, Country.GERMANY));
        collection.push(movie);
        collection.push(movie2);
        collection.push(movie3);

        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        CommandsRegistration.commandsRegistration(invoker, receiver);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Для вывода справки по командам введите \"help\".");
        String output;
        while (true) {
            String input;
            System.out.println("Введите команду:");
            input = scanner.nextLine();
            String[] cmdline = input.trim().split(" ");
            if (cmdline.length == 1) {
                String commandString = cmdline[0];
                output = invoker.execute(invoker, commandString, collection, "");
            } else if (cmdline.length == 2) {
                String command = input.trim().split(" ")[0];
                String argument = input.trim().split(" ")[1];
                output = invoker.execute(invoker, command, collection, argument);
            } else {
                output = "Недопустимый формат команды. Введите команду без аргументов или же с одним аргументом ";
            }
            if (output == null)
                break;
            System.out.println(output);
        }
    }
}
