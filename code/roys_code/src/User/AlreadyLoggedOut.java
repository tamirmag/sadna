package User;


import Loggers.ActionLogger;

public class AlreadyLoggedOut extends Exception {
    public AlreadyLoggedOut(String s) {
        super();
        ActionLogger.getInstance().writeToFile("user " +s+ " already logged out");
    }
}
