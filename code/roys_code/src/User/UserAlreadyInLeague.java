package User;


import Loggers.ActionLogger;

public class UserAlreadyInLeague extends Exception {

    public UserAlreadyInLeague(String username , int league) {
        super();
        ActionLogger.getInstance().writeToFile("user "+username+" is already in league "+league);
    }
}
