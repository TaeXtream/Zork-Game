package io.muzoo.ooc.zork.command;

public class AttackCommand implements Command {
    @Override
    public void execute(String arg) {
        System.out.println("Attack " + arg);
    }
}
