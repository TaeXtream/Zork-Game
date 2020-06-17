package io.muzoo.ooc.zork.command;

import io.muzoo.ooc.zork.Game;

import javax.naming.NameNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoCommand extends Command {
    Map<String, List<String>> scriptMap = new HashMap<>();

    {
        scriptMap.put("Ruined Pinnacle", new ArrayList<>());
        scriptMap.get("Ruined Pinnacle").add("autoScript\\Ruin1.txt");
        scriptMap.put("Frozen Seaway", new ArrayList<>());
        scriptMap.get("Frozen Seaway").add("autoScript\\Frozen1.txt");
    }

    public AutoCommand(Game game) {
        super(game);
    }

    @Override
    public void execute(String arg) {
        try {
            Parser autoParser = new AutoParser(game.getCommandFactory(), getScript(arg));
            game.setParser(autoParser);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    File getScript(String name) throws NameNotFoundException {
        for (String string : scriptMap.get(game.getGameMap().getName())) {
            if (string.contains(name))
                return new File(string);
        }
        throw new NameNotFoundException("Cannot find script");
    }


    @Override
    void printDescription() {

    }
}
