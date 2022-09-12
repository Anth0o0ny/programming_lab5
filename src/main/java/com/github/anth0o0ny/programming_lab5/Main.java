package com.github.anth0o0ny.programming_lab5;


import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import javax.xml.bind.JAXBException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws JAXBException {

        Invoker invoker = new Invoker();
        Receiver receiver = new Receiver();
        CommandsRegistration.commandsRegistration(invoker, receiver);
        Scanner scanner = new Scanner(System.in);

        MoviesCollection mc = new MoviesCollection();
        Parser.parsingToObj(mc.getCollection());

        System.out.println("Для вывода справки по командам введите \"help\".");
        String output;
        while (true) {
            String input;
            System.out.println("Введите команду:");
            input = scanner.nextLine();
            String[] cmdline = input.trim().split(" ");

            try {
                if (cmdline.length == 1) {
                    String command = cmdline[0];
                    output = invoker.execute(invoker, command, mc.getCollection(), "", mc);
                } else if (cmdline.length == 2) {
                    String command = input.trim().split(" ")[0];
                    String argument = input.trim().split(" ")[1];
                    output = invoker.execute(invoker, command, mc.getCollection(), argument, mc);
                } else {
                    throw new NullPointerException();
                }
                if (output == null)
                    break;
                System.out.println(output);

            } catch (NullPointerException ex) {
                output = "Недопустимый формат команды. Введите команду без аргументов или же с одним аргументом ";
                System.out.println(output);
            }
        }
    }
}
