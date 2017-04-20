package Games;

import User.User;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by tamir on 16/04/2017.
 */
public interface IGame {
    void setMinimumBet(int bet);
    int getMinimumBet();

    void setMinimumPlayers(int num);

    void setMaximumPlayers(int num);

    void setChipNum(int num);


    void setBuy(int cost);

    int getId();

    void publishMessage(String msg, Player player);

    boolean isPlayerInGame(String name);

    boolean join(Player player);

    int getPot();

    boolean spectaAble();

    int getChips();

    int getBuyIn();

    int getMaxPlayers();

    int getMinPlayers();

    String getType();

    Hashtable<String ,ArrayList<String>> getAllTurnsByAllPlayers();

    ArrayList<String> getAllTurnsOfPlayer(Player p, ArrayList<String> allTurns);

    void spectateGame(User user);

    void bet(int amount, Player player);

    void call(int amount, Player player);

    boolean isLocked();
}
