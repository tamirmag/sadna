package Games;

/**
 * Created by tamir on 16/04/2017.
 */
public class MinAmountPolicy extends Policy{

    int min;

    public MinAmountPolicy(int min) {
        this.min = min;
        setMinimumPlayers(min);
    }
}
