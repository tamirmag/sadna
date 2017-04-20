package Games;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by tamir on 16/04/2017.
 */
public abstract class Policy implements IGame{

    IGame policy;

    @Override
    public void setMinimumBet(int bet) {
        policy.setMinimumBet(bet);
    }

    @Override
    public void setMinimumPlayers(int min) {
        policy.setMinimumPlayers(min);
    }

    @Override
    public void setMaximumPlayers(int max) {
        policy.setMaximumPlayers(max);
    }

    @Override
    public void setChipNum(int num) {
        policy.setChipNum(num);
    }

    @Override
    public void setSpectate(Boolean spectate) {
        policy.setSpectate(spectate);
    }

    @Override
    public void setBuy(int cost) {
        policy.setBuy(cost);
    }

    @Override
    public int getId() {
        return policy.getId();
    }

    @Override
    public void publishMessage(String msg, Player player) {
        policy.publishMessage(msg,player);

    }

    @Override
    public boolean isPlayerInGame(Player player) {
        return policy.isPlayerInGame(player);
    }

    @Override
    public boolean join(Player player) {
        return policy.join(player);
    }

    @Override
    public int getPot(){
        return policy.getPot();
    }

    @Override
    public boolean spectaAble(){
        return policy.spectaAble();
    }


    @Override
    public int getMinimumBet() {
        return this.policy.getMinimumBet();
    }

    @Override
    public int getChips() {
        return this.policy.getChips();
    }

    @Override
    public int getBuyIn() {
        return this.policy.getBuyIn();
    }

    @Override
    public int getMaxPlayers() {
        return this.policy.getMaxPlayers();
    }

    @Override
    public int getMinPlayers() {
        return this.policy.getMinPlayers();
    }

    @Override
    public String getType() {
        return this.policy.getType();
    }

    @Override
    public ArrayList<String> getAllTurnsOfPlayer(Player p, ArrayList<String> allTurns)
    {
        return this.policy.getAllTurnsOfPlayer(p,allTurns);
    }

    @Override
    public Hashtable<String ,ArrayList<String>> getAllTurnsByAllPlayers(){
        return this.policy.getAllTurnsByAllPlayers();
    }

}
