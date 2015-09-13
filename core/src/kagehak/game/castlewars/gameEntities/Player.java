package kagehak.game.castlewars.gameEntities;

/**
 * Created by kagehak on 9/12/15.
 */
public class Player {
    private String playerName;
    private int level;
    private int startIncome;
    private int startGold;

    private Race race;

    public Player(String playerName, int level, int startIncome, int startGold, Race race) {
        this.playerName = playerName;
        this.level = level;
        this.startIncome = startIncome;
        this.startGold = startGold;
        this.race = race;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getLevel() {
        return level;
    }

    public int getStartIncome() {
        return startIncome;
    }

    public int getStartGold() {
        return startGold;
    }

    public Race getRace() {
        return race;
    }


}
