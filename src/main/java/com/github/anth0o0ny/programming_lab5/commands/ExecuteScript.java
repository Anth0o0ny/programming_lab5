package com.github.anth0o0ny.programming_lab5.commands;

import com.github.anth0o0ny.programming_lab5.CommandsEnum;
import com.github.anth0o0ny.programming_lab5.StringConstants;
import com.github.anth0o0ny.programming_lab5.baseclasses.MoviesCollection;
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
            return StringConstants.Commands.EXECUTE_ENTER_FILENAME;
        } else if (new File(argument).isDirectory()) {
            return StringConstants.Commands.EXECUTE_IS_DIRECTORY;
        } else {
            String filePath = new File(argument).getAbsolutePath();
            if (files.contains(filePath)) {
                files.clear();
                return StringConstants.Commands.EXECUTE_RECURSION;
            } else {
                files.add(filePath);
                try {
                    return receiver.executeScript(invoker, moviesCollection, argument);
                } catch (FileNotFoundException ex) {
                    return StringConstants.Commands.EXECUTE_FILE_NOT_EXISTS;
                } finally {
                    files.clear();
                }

            }
        }
    }

    @Override
    public String getHelp() {
        return CommandsEnum.EXECUTE_SCRIPT.commandName + " file_name : " + StringConstants.Commands.EXECUTE_SCRIPT_HELP;
    }
}
