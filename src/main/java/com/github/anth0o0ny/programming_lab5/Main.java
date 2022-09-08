package com.github.anth0o0ny.programming_lab5;


import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        CommandsRegistration.commandsRegistration(invoker, receiver);
        Scanner scanner = new Scanner(System.in);

        MoviesCollection mc = new MoviesCollection();
        Parser pr = new Parser();
        pr.parsing(mc.getCollection());

        System.out.println("Для вывода справки по командам введите \"help\".");
        String output;
        while (true) {
            String input;
            System.out.println("Введите команду:");
            input = scanner.nextLine();
            String[] cmdline = input.trim().split(" ");
            if (cmdline.length == 1) {
                String commandString = cmdline[0];
                output = invoker.execute(invoker, commandString, mc.getCollection(), "");
            } else if (cmdline.length == 2) {
                String command = input.trim().split(" ")[0];
                String argument = input.trim().split(" ")[1];
                output = invoker.execute(invoker, command, mc.getCollection(), argument);
            } else {
                output = "Недопустимый формат команды. Введите команду без аргументов или же с одним аргументом ";
            }
            if (output == null)
                break;
            System.out.println(output);
        }
    }
}
