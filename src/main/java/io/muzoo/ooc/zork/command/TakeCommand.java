package io.muzoo.ooc.zork.command;

public class TakeCommand implements Command {
    @Override
    public void execute(String arg) {
        System.out.println("Take " + arg);
    }
}
