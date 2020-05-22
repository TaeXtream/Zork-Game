package io.muzoo.ooc.zork.command;

public class DropCommand implements Command {

    @Override
    public void execute(String arg) {
        System.out.println("Drop "+arg);
    }
}
