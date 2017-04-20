package Games;

/**
 * Created by tamir on 16/04/2017.
 */
public class MinBetPolicy extends Policy{

    int minimumBet;

    public MinBetPolicy(IGame policy, int minimumBet) {
        this.policy = policy;
        this.minimumBet = minimumBet;
        setMinimumBet(minimumBet);
    }


}
