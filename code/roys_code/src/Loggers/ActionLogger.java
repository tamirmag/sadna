package Loggers;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ActionLogger extends MyLogger {
    private static ActionLogger instance = null;

    private ActionLogger(){
        super( "ActionLog.txt");

    }

    public static ActionLogger getInstance()
    {
        if(instance == null) {
            instance = new ActionLogger();
        }
        return instance;
    }
    public ArrayList<String> getLinesByUsername(String username)
    {
        return getSelectedLinesFromFile(getContentOfFile(),userline(username));
    }


    public ArrayList<String> getSelectedLinesFromFile(ArrayList<String> lines ,Predicate<String> predicate)
    {
        return new ArrayList<String>(lines.stream().filter( predicate ).collect(Collectors.<String>toList()));
    }
    public Predicate<String> userline(String username)
    {
        return p-> p.contains(username);
    }


}
