package User;




import Loggers.ActionLogger;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class LoginManagerTests {

    static User roy = new User("roy","1235",1,"rzarviv@gmail.com",new Wallet(100));
    @Test
    public void checkSuccessLogin() throws UsernameNotValid, UsernameAndPasswordNotMatch, PasswordNotValid, UserAlreadyExists, AlreadyLoggedIn {
        AccountManager.getInstance().addUser(roy);
        UserManager u = AccountManager.getInstance().login("roy" ,"1235");
        assertEquals(u.getUser() , roy);
    }


    @Test(expected = AlreadyLoggedIn.class)
    public void checkAlreadyLoggedInLogin() throws UsernameNotValid, UsernameAndPasswordNotMatch, PasswordNotValid, UserAlreadyExists, AlreadyLoggedIn {
        AccountManager.getInstance().addUser(roy);
        AccountManager.getInstance().addLoggedInUser(roy);
        UserManager u = AccountManager.getInstance().login("roy" ,"1235");

    }

    @Test(expected = UsernameNotValid.class)
    public void checkUsernameNotValidLogin() throws UsernameNotValid, UsernameAndPasswordNotMatch, PasswordNotValid, UserAlreadyExists, AlreadyLoggedIn {
        final String EMPTY_USERNAME = "" ;
        AccountManager.getInstance().addUser(roy);
        AccountManager.getInstance().addLoggedInUser(roy);
        UserManager u = AccountManager.getInstance().login(EMPTY_USERNAME ,"1235");

    }

    @Test(expected = PasswordNotValid.class)
    public void checkPasswordNotValidLogin() throws UsernameNotValid, UsernameAndPasswordNotMatch, PasswordNotValid, UserAlreadyExists, AlreadyLoggedIn {
        final String EMPTY_PASSWORD = "" ;
        AccountManager.getInstance().addUser(roy);
        AccountManager.getInstance().addLoggedInUser(roy);
        UserManager u = AccountManager.getInstance().login("roy" ,EMPTY_PASSWORD);

    }

    @Test(expected = UsernameAndPasswordNotMatch.class)
    public void checkUsernamePasswordNotValidLogin() throws UsernameNotValid, UsernameAndPasswordNotMatch, PasswordNotValid, UserAlreadyExists, AlreadyLoggedIn {
        AccountManager.getInstance().addUser(roy);
        AccountManager.getInstance().addLoggedInUser(roy);
        UserManager u = AccountManager.getInstance().login("roy" ,"1234");

    }

    @Test(expected = UserAlreadyExists.class)
    public void checkUserAlreadyExistsLogin() throws UserAlreadyExists, UsernameNotValid {
        AccountManager.getInstance().addUser(roy);
        AccountManager.getInstance().addUser(roy);
    }

    @Test
    public void checkSuccessLogout() throws AlreadyLoggedIn, UserAlreadyExists, UserNotExists, AlreadyLoggedOut, UsernameNotValid {
        AccountManager.getInstance().addUser(roy);
        AccountManager.getInstance().addLoggedInUser(roy);
        AccountManager.getInstance().logout(roy);
    }

    @Test(expected = AlreadyLoggedOut.class)
    public void checkAlreadyLoggedOutLogout() throws UserAlreadyExists, UserNotExists, AlreadyLoggedOut, AlreadyLoggedIn, UsernameNotValid {
        AccountManager.getInstance().addUser(roy);
        AccountManager.getInstance().addLoggedInUser(roy);
        AccountManager.getInstance().logout(roy);
        AccountManager.getInstance().logout(roy);
    }

    @Test(expected = UserNotExists.class)
    public void checkUserNotExistsLogout() throws UserNotExists, AlreadyLoggedOut {
        AccountManager.getInstance().logout(roy);
    }

    @Test
    public void checkSuccessRegistration() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid {
        UserManager u = AccountManager.getInstance().register(roy.getUsername(),roy.getPassword(),roy.getEmail(),roy.getWallet().getAmountOfMoney());
        assertEquals(u.getUser(),roy);
    }

    @Test(expected = EmailNotValid.class)
    public void checkEmailNotValidRegistration() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid {
        final String STAM_EMAIL = "@@@@@dkjng";
        UserManager u = AccountManager.getInstance().register(roy.getUsername(),roy.getPassword(),STAM_EMAIL,roy.getWallet().getAmountOfMoney());

    }

    @Test(expected = NegativeValue.class)
    public void checkNegativeValueRegistration() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid {
        final int NEGATIVE_WALLET = -1;
        UserManager u = AccountManager.getInstance().register(roy.getUsername(),roy.getPassword(),roy.getEmail(),NEGATIVE_WALLET);
    }

    @Test(expected = UsernameNotValid.class)
    public void checkUsernameNotValidRegistration() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid {
        final String EMPTY_STRING = "";
        UserManager u = AccountManager.getInstance().register(EMPTY_STRING,roy.getPassword(),roy.getEmail(),roy.getWallet().getAmountOfMoney());
    }

    @Test(expected = PasswordNotValid.class)
    public void checkPasswordNotValidRegistration() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid {
        final String EMPTY_STRING = "";
        UserManager u = AccountManager.getInstance().register(roy.getUsername(),EMPTY_STRING,roy.getEmail(),roy.getWallet().getAmountOfMoney());
    }

    //@Test(expected = UserAlreadyExists.class)
    public void checkUserAlreadyExistsRegistration() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid {
        UserManager u = AccountManager.getInstance().register(roy.getUsername(),roy.getPassword(),roy.getEmail(),roy.getWallet().getAmountOfMoney());
        UserManager u1 = AccountManager.getInstance().register(roy.getUsername(),roy.getPassword(),roy.getEmail(),roy.getWallet().getAmountOfMoney());
    }

    @Test
    public void checkHighestRankUser() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid, UserAlreadyInLeague, AlreadyLoggedOut, UserNotExists, UsernameAndPasswordNotMatch, AlreadyLoggedIn, UserNotInLeague, LeagueNotExists {
        UserManager u = AccountManager.getInstance().register(roy.getUsername(), roy.getPassword(), roy.getEmail(), roy.getWallet().getAmountOfMoney());
        HighestRankingUser user = new HighestRankingUser(roy);
        user.moveUserToLeague("roy", 100);
        u.logout();
        u = AccountManager.getInstance().login("roy", "1235");
        assertTrue(u.getUser().getClass() == HighestRankingUser.class);
    }

   @Test
    public void logInLogOut() throws EmailNotValid, NegativeValue, UsernameNotValid, UserAlreadyExists, PasswordNotValid, AlreadyLoggedOut, UserNotExists, UsernameAndPasswordNotMatch, AlreadyLoggedIn {
        UserManager u = AccountManager.getInstance().register(roy.getUsername(), roy.getPassword(), roy.getEmail(), roy.getWallet().getAmountOfMoney());
        u.logout();
        u= AccountManager.getInstance().login(roy.getUsername(),roy.getPassword());
        u.logout();
        u= AccountManager.getInstance().login(roy.getUsername(),roy.getPassword());
        u.logout();
    }




























    @After
    public void inTheEndOfEveryTest()
    {
        AccountManager.getInstance().clearLoggedInUsers();
        AccountManager.getInstance().clearUsers();
        AccountManager.getInstance().clearLeagues();
        ActionLogger.getInstance().clearLog();
    }



}
