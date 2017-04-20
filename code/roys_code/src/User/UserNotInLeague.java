package User;


import Loggers.ActionLogger;

public class UserNotInLeague extends Exception {

    public UserNotInLeague(String username, int league) {

        super();
        ActionLogger.getInstance().writeToFile("username "+username+" is not in league "+ league);
    }
}
