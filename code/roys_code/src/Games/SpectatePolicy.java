package Games;

/**
 * Created by tamir on 16/04/2017.
 */
public class SpectatePolicy extends Policy{

    boolean spectate;

    public SpectatePolicy(IGame policy, boolean spectate) {
        this.policy = policy;
        this.spectate = spectate;
        this.policy.setSpectate(spectate);
    }

}
