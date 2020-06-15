package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

import java.util.*;

public class CommandFactory {
    Game game;
    private final Map<String, Command> commandMap = new HashMap<>();

    public CommandFactory(Game game) {
        this.game = game;
        commandMap.put("quit", new QuitCommand(game));
        commandMap.put("go", new GoCommand(game));
        commandMap.put("take", new TakeCommand(game));
        commandMap.put("drop", new DropCommand(game));
        commandMap.put("attack", new AttackCommand(game));
        commandMap.put("use", new UseCommand(game));
        commandMap.put("status", new StatusCommand(game));
        commandMap.put("look", new LookCommand(game));
        commandMap.put("help", new HelpCommand(game));
        commandMap.put("study", new StudyCommand(game));
        commandMap.put("cheat", new CheatCommand(game));
    }

    public Command getCommand(String cmd) {
        return commandMap.get(cmd);
    }

    public boolean isCommand(String cmd) {
        return commandMap.containsKey(cmd);
    }

    public Map<String, Command> getCommandMap() {
        return commandMap;
    }
}
