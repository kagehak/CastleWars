package kagehak.game.castlewars.gameEntities;

import java.util.List;

/**
 * Created by kagehak on 9/12/15.
 */
public class Race {
    String racename;
    List<Building> buildingsList;

    public Race(String racename, List<Building> buildingsList) {
        this.racename = racename;
        this.buildingsList = buildingsList;
    }

    public String getRacename() {
        return racename;
    }

    public List<Building> getBuildingsList() {
        return buildingsList;
    }
}
