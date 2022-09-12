package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.MoviesCollection;
import com.github.anth0o0ny.programming_lab5.baseclasses.Movie;
import com.github.anth0o0ny.programming_lab5.patterncommands.Command;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Stack;

public class ExecuteScript implements Command {

    private final Receiver receiver;

    ArrayList<String> files = new ArrayList<>();

    public ExecuteScript(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String execute(Invoker invoker, Stack<Movie> collection, String argument, MoviesCollection moviesCollection) throws JAXBException {
        if (argument.isEmpty()) {
            return "Передайте название файла";
        } else if (new File(argument).isDirectory()) {
            return "Передана директория";
        } else {
            String filePath = new File(argument).getAbsolutePath();
            if (files.contains(filePath)) {
                files.clear();
                return "Обнаружен рекурсия";
            } else {
                files.add(filePath);
                try {
                    return receiver.executeScript(invoker, moviesCollection, argument);
                }catch (FileNotFoundException ex){
                    return "Файл не найден";
                }finally {
                    files.clear();
                }

            }
        }
    }

    @Override
    public String getHelp() {
        return "Введите \"execute_script file_name\" , чтобы считать и исполнить скрипт из указанного файла.";
    }
}
