package User;


import Loggers.ActionLogger;

public class PasswordNotValid extends Exception {
    public PasswordNotValid(String s) {
        super();
        ActionLogger.getInstance().writeToFile("password "+s+" is not valid");
    }
}
