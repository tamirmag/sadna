package Games;


public class BuyInPolicy extends Policy{

    int cost;

    public BuyInPolicy(IGame policy, int cost) {
        this.policy = policy;
        this.cost = cost;
    }


    public boolean join(Player player)
    {
        if(this.policy.isLocked())
            return false;
        return this.policy.join(player);
    }
}
