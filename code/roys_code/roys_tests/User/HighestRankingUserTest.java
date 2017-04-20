package User;


import Loggers.ActionLogger;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;


public class HighestRankingUserTest {

    static User roy = new User("roy", "1235", 1, "rzarviv@gmail.com", new Wallet(100));

   @Test
    public void moveUserToLeague() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid, UserAlreadyInLeague, AlreadyLoggedOut, UserNotExists, UsernameAndPasswordNotMatch, AlreadyLoggedIn, UserNotInLeague, LeagueNotExists {
        UserManager u = AccountManager.getInstance().register(roy.getUsername(), roy.getPassword(), roy.getEmail(), roy.getWallet().getAmountOfMoney());
        HighestRankingUser user = new HighestRankingUser(roy);
        user.moveUserToLeague("roy", 100);
        u.logout();
        u = AccountManager.getInstance().login("roy", "1235");
        assertEquals(u.getUser().getLeague(), 100);
    }
    @Test(expected = NegativeValue.class)
    public void FailMoveUserToLeague() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid, UserAlreadyInLeague, AlreadyLoggedOut, UserNotExists, UsernameAndPasswordNotMatch, AlreadyLoggedIn, UserNotInLeague, LeagueNotExists {
        final int NEGATIVE_LEAGUE =-4;
        UserManager u = AccountManager.getInstance().register(roy.getUsername(), roy.getPassword(), roy.getEmail(), roy.getWallet().getAmountOfMoney());
        HighestRankingUser user = new HighestRankingUser(roy);
        user.moveUserToLeague("roy", NEGATIVE_LEAGUE);
    }
    @Test(expected = UserAlreadyInLeague.class)
    public void UserAlreadyInLeagueMoveUserToLeague() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid, UserAlreadyInLeague, AlreadyLoggedOut, UserNotExists, UsernameAndPasswordNotMatch, AlreadyLoggedIn, UserNotInLeague, LeagueNotExists {
        UserManager u = AccountManager.getInstance().register(roy.getUsername(), roy.getPassword(), roy.getEmail(), roy.getWallet().getAmountOfMoney());
        HighestRankingUser user = new HighestRankingUser(roy);
        user.moveUserToLeague("roy", 100);
        user.moveUserToLeague("roy", 100);
    }

    @Test(expected = UserNotInLeague.class)
    public void UserNotInLeagueMoveUserToLeague() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid, UserAlreadyInLeague, AlreadyLoggedOut, UserNotExists, UsernameAndPasswordNotMatch, AlreadyLoggedIn, UserNotInLeague, LeagueNotExists {
        UserManager u = AccountManager.getInstance().register(roy.getUsername(), roy.getPassword(), roy.getEmail(), roy.getWallet().getAmountOfMoney());
        HighestRankingUser user = new HighestRankingUser(roy);
        user.moveUserToLeague(roy.getUsername(), 100);
        u.logout();
        u= AccountManager.getInstance().login(roy.getUsername(),roy.getPassword());
        user.moveUserToLeague(roy.getUsername() ,200);
        u.logout();
        u= AccountManager.getInstance().login(roy.getUsername(),roy.getPassword());
        u.getUser().setLeague(100);
        AccountManager.getInstance().removeUserFromLeague(u.getUser());
    }


    @Test
    public void setDefaultLeague() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid, UserAlreadyInLeague,  AlreadyLoggedOut, UserNotExists, UsernameAndPasswordNotMatch, AlreadyLoggedIn {
        UserManager u = AccountManager.getInstance().register(roy.getUsername(), roy.getPassword(), roy.getEmail(), roy.getWallet().getAmountOfMoney());
        HighestRankingUser user = new HighestRankingUser(roy);
        user.setDefaultLeague(200);
        assertEquals(AccountManager.getInstance().getDefaultLeague(), 200);
    }

    @Test(expected = NegativeValue.class)
    public void checkFailedSetDefaultLeague() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid {
        final int NEGATIVE_LEAGUE =-4;
        UserManager u = AccountManager.getInstance().register(roy.getUsername(), roy.getPassword(), roy.getEmail(), roy.getWallet().getAmountOfMoney());
        HighestRankingUser user = new HighestRankingUser(roy);
        user.setDefaultLeague(NEGATIVE_LEAGUE);

    }

    @After
    public void inTheEndOfEveryTest() throws NegativeValue {
        AccountManager.getInstance().clearLoggedInUsers();
        AccountManager.getInstance().clearUsers();
        AccountManager.getInstance().clearLeagues();
        AccountManager.getInstance().setDefaultLeague(0);
        ActionLogger.getInstance().clearLog();
    }


}
