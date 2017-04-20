package Games;

import java.util.ArrayList;
import java.util.List;
import User.User;

public class ActiveGamesManager
    {
        private static ActiveGamesManager instance = null;
        ArrayList<IGame> games = new ArrayList<IGame>();
        int index = 0;

        private ActiveGamesManager()
        {

        }

        public static ActiveGamesManager getInstance()
        {
            if(instance == null) {
                instance = new ActiveGamesManager();
            }
            return instance;
        }
        public void publishMessage(String msg, int gameNumber, Player player) {
            for (IGame game : games) {
                if (game.getId() == gameNumber) {
                    game.publishMessage(msg, player);
                }
            }
        }

        public void createGame(User user, String type) {
            ArrayList<Player> players = new ArrayList<Player>();
            Player p = new Player(user.getUsername(), user.getWallet());
            p.wallet = user.getWallet();
            p.name = user.getUsername();
            players.add(p);
            games.add(new Game(players, ++index, type));
        }

        public void JoinGame(int id, User user) {
            IGame myGame=null;
            for (IGame game:games ) {
                if(game.getId() == id)
                    myGame = game;
            }
            Player p = new Player(user.getUsername(), user.getWallet());
            myGame.join(p);
            //TODO change the player
        }

        public void spectateGame(IGame game, User user) {
        }

        public List<IGame> findActiveGamesByPlayer(Player player, User user) {
            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.isPlayerInGame(player))
                    ourGames.add(game);
            }
            return ourGames;
        }

        public List<IGame> findActiveGamesByPotSize(int potSize, User user) {

            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.getPot() == potSize)
                    ourGames.add(game);
            }
            return ourGames;
        }


        public List<IGame> findSpectatableGames(User user) {

            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.spectaAble())
                    ourGames.add(game);
            }
            return ourGames;
        }

////////////////////////////////////////////////////////////////////////////////////////////////////

        public ArrayList<IGame> findActiveGamesByPlayersMinimumPolicy(int minimal) {
            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.getMinPlayers() == minimal)
                    ourGames.add(game);
            }
            return ourGames;
        }

        public ArrayList<IGame> findActiveGamesByPlayersMaximumPolicy(int maximal) {
            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.getMaxPlayers() == maximal)
                    ourGames.add(game);
            }
            return ourGames;
        }

        public ArrayList<IGame> findActiveGamesByMinimumBetPolicy(int minimumBet) {
            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.getMinimumBet() == minimumBet)
                    ourGames.add(game);
            }
            return ourGames;
        }

        public ArrayList<IGame> findActiveGamesByChipPolicy(int numOfChips) {
            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.getChips() == numOfChips)
                    ourGames.add(game);
            }
            return ourGames;
        }

        public ArrayList<IGame> findActiveGamesByBuyInPolicy(int costOfJoin) {
            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.getBuyIn() == costOfJoin)
                    ourGames.add(game);
            }
            return ourGames;
        }

        public ArrayList<IGame> findActiveGamesByGameTypePolicy(String gameTypePolicy) {
            ArrayList<IGame> ourGames = new ArrayList<IGame>();
            for (IGame game : games) {
                if (game.getType() == gameTypePolicy)
                    ourGames.add(game);
            }
            return ourGames;
        }

    }

