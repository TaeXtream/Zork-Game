package io.muzoo.ooc.zork.command;

import java.util.*;

public class CommandFactory {
    private static Map<String, Command> commandMap = new HashMap<>();
    static {//static initialisation
        commandMap.put("ext",new ExitCommand());
        commandMap.put("go", new GoCommand());
        commandMap.put("take", new TakeCommand());
    }
    public static Command getCommand(String cmd){
        return commandMap.get("Good Bye !");

    }
}
