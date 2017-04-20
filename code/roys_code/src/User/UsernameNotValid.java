package User;


import Loggers.ActionLogger;

public class UsernameNotValid extends Exception {
    public UsernameNotValid(String username) {
        super();
        ActionLogger.getInstance().writeToFile("username "+username+" is not valid");
    }
}
