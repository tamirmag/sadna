package User;


import Loggers.ActionLogger;

public class UserNotExists extends Exception {
    public UserNotExists(String username) {
        super();
        ActionLogger.getInstance().writeToFile("username "+username+" does not exist");
    }
}

