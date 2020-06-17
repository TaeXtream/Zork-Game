package io.muzoo.ooc.zork.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoParser extends Parser {


    public AutoParser(CommandFactory commandFactory, File script) {
        super(commandFactory);
        try {
            reader = new Scanner(script);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CommandLine getCommandLine() {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();
        System.out.println(inputLine);

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        if (commands.isCommand(word1)) {
            return new CommandLine(word1, word2);
        } else {
            return new CommandLine(null, word2);
        }
    }
}
