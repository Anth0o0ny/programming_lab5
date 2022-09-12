package com.github.anth0o0ny.programming_lab5;

import com.github.anth0o0ny.programming_lab5.commands.*;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

public class CommandsRegistration {
    public static void commandsRegistration(Invoker invoker, Receiver receiver) {
        invoker.registration("exit", new Exit(receiver));
        invoker.registration("help", new Help(receiver));
        invoker.registration("clear", new Clear(receiver));
        invoker.registration("show", new Show(receiver));
        invoker.registration("info", new Info(receiver));
        invoker.registration("shuffle", new Shuffle(receiver));
        invoker.registration("print_descending", new PrintDescending(receiver));
        invoker.registration("group_counting_by_tagline", new GroupCountingByTagline(receiver));
        invoker.registration("remove_by_id", new RemoveById(receiver));
        invoker.registration("remove_all_by_screenwriter", new RemoveAllByScreenwriter(receiver));
        invoker.registration("add", new Add(receiver));
        invoker.registration("add_if_min", new AddIfMin(receiver));
        invoker.registration("update", new UpdateById(receiver));
        invoker.registration("insert_at", new InsertAt(receiver));
        invoker.registration("save", new Save(receiver));
        invoker.registration("execute_script", new ExecuteScript(receiver));
    }
}
