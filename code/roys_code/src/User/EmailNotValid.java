package User;


import Loggers.ActionLogger;

public class EmailNotValid extends Exception {
    public EmailNotValid(String s)
    {
        super();
        ActionLogger.getInstance().writeToFile("email " +s+ "is not valid");
    }
}
