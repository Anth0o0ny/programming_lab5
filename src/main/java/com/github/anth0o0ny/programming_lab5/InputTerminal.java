package com.github.anth0o0ny.programming_lab5;

import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class InputTerminal {

    Scanner scanner;
    private final Invoker invoker;
    private final MoviesCollection moviesCollection;
    private String output;

    public InputTerminal(Invoker invoker, MoviesCollection moviesCollection) {
        this.invoker = invoker;
        this.moviesCollection = moviesCollection;
    }

    public String startFile(String argument) throws FileNotFoundException {

        String pathToFile = new File(argument).getAbsolutePath();
        File file = new File(pathToFile);
        this.scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String commandLine = scanner.nextLine();
            try {
                output = lineParseToCommand(commandLine);
                if (output == null) {
                    break;
                }
                System.out.println(output);
            } catch (JAXBException e) {
                return "В файле найдена несуществующая команда. Выполнение прекращено.";
            }
        }
        return "Выполнение файла " + file + " окончено.";
    }

    protected void inputKeyboard() {
        this.scanner = new Scanner(System.in);

        System.out.println("Для вывода справки по командам введите help.");
        while (true) {
            System.out.println("Введите команду:");
            String commandLine = scanner.nextLine();
            try {
                output = lineParseToCommand(commandLine);
                if (output == null) {
                    break;
                }
                System.out.println(output);
            } catch (NullPointerException | JAXBException e) {
                System.out.println("Команды не существует");
            }
        }
    }

    protected String lineParseToCommand(String line) throws JAXBException {
        while (line.contains(" ")) {
            line = line.replace("  ", " ");
        }
        String[] cmdline = line.trim().split(" ");
        if (cmdline.length == 1) {
            String command = cmdline[0];
            output = invoker.execute(invoker, command, moviesCollection.getCollection(), "", moviesCollection);
            return output;
        } else if (cmdline.length == 2) {
            String command = line.trim().split(" ")[0];
            String argument = line.trim().split(" ")[1];
            output = invoker.execute(invoker, command, moviesCollection.getCollection(), argument, moviesCollection);
            return output;
        } else {
            throw new NullPointerException();
        }
    }

}

