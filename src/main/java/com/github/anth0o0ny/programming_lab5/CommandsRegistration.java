package com.github.anth0o0ny.programming_lab5;

import com.github.anth0o0ny.programming_lab5.commands.*;
import com.github.anth0o0ny.programming_lab5.patterncommands.Invoker;
import com.github.anth0o0ny.programming_lab5.patterncommands.Receiver;

public class CommandsRegistration {
    public static void commandsRegistration(Invoker invoker, Receiver receiver){
       invoker.registration("exit", new Exit(receiver));
       invoker.registration("help", new Help(receiver));
       invoker.registration("clear", new Clear(receiver));
       invoker.registration("show", new Show(receiver));
       invoker.registration("info", new Info(receiver));
       invoker.registration("shuffle", new Shuffle(receiver));
       invoker.registration("print_descending", new PrintDescending(receiver));
       invoker.registration("group_counting_by_tagline", new GroupCountingByTagline(receiver));
    }
}
