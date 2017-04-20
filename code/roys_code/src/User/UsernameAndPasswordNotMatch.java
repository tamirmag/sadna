package User;


import Loggers.ActionLogger;

public class UsernameAndPasswordNotMatch extends Exception{

    public UsernameAndPasswordNotMatch(String username , String password ) {
        super();
        ActionLogger.getInstance().writeToFile("username " + username+" and passwrod "+password+" does not match");

    }
}
