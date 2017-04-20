package Games;

public class ChipPolicy extends Policy{

    int chips;

    public ChipPolicy(IGame policy, int chips) {
        this.policy = policy;
        this.chips = chips;
        this.policy.setChipNum(chips);
    }
}

