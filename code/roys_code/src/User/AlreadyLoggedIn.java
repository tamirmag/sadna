package User;


import Loggers.ActionLogger;

public class AlreadyLoggedIn extends Exception {
    public AlreadyLoggedIn(String s) {
        super();
        ActionLogger.getInstance().writeToFile("user "+s+" already logged in");
    }
}
