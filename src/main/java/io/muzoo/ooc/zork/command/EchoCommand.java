package io.muzoo.ooc.zork.command;

public class EchoCommand implements Command {

    @Override
    public void execute(String arg){
        System.out.println("You Type:" + arg);
    }
}
