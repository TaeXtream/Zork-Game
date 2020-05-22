package io.muzoo.ooc.zork.command;

public class GoCommand implements Command {
    @Override
    public void execute(String arg) {
        System.out.println("Go " + arg);
    }
}
