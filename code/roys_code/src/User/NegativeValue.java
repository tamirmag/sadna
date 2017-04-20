package User;


import Loggers.ActionLogger;

public class NegativeValue extends Exception {
    public NegativeValue(int val) {
        super();
        ActionLogger.getInstance().writeToFile( val+ " is not a positive value");
    }
}
