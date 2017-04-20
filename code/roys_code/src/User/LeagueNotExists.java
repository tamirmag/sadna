package User;


import Loggers.ActionLogger;

public class LeagueNotExists extends Exception {

    public LeagueNotExists(int league) {
        super();
        ActionLogger.getInstance().writeToFile("league " +league+ " does not exist");
    }
}
