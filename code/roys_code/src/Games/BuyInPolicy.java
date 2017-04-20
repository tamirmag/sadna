package Games;


public class BuyInPolicy extends Policy{

    int cost;

    public BuyInPolicy(IGame policy, int cost) {
        this.policy = policy;
        this.cost = cost;
        this.policy.setBuy(cost);
    }

}
