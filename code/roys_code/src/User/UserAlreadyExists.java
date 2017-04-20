package User;


import Loggers.ActionLogger;

public class UserAlreadyExists extends Exception{

    public UserAlreadyExists(String s) {
        super();
        ActionLogger.getInstance().writeToFile("user "+s+" already exists");
    }
}
