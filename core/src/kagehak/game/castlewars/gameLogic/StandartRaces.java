package kagehak.game.castlewars.gameLogic;

import java.util.ArrayList;
import java.util.List;

import kagehak.game.castlewars.gameEntities.Building;
import kagehak.game.castlewars.gameEntities.units.Unit;

/**
 * Created by kagehak on 9/12/15.
 */
public class StandartRaces {

    public static List<Building> getDefault(int id){
        List<Building> buildingList = new ArrayList<Building>();
        switch (id){
            default:
                Building b = new Building("Barrack", 2, 100, new Unit(2, "Footman", 250, 4f, 3, 18, 0, 5, 1.0f), 30);
                b.setUpgradeBuilding(new Building("Stronghold", 4, 175, new Unit(4, "Defender", 575, 7f, 3, 38, 0, 5, 1.0f), 30));
                buildingList.add(b);
                buildingList.add(new Building("Sniper Nest", 3, 140, new Unit(3, "Sniper", 270, 0f, 2, 33, 1, 500 , 1.5f), 30));
                buildingList.add(new Building("Weapon Lab", 5, 210, new Unit(5, "Mortar", 280, 0f, 1, 63, 2, 1000 , 3f), 30));
                buildingList.add(new Building("Gryphon Rock", 6, 250, new Unit(6, "Gryphon Rider", 500, 2f, 3, 46, 1, 450 , 2f), 30));
                buildingList.add(new Building("Chapel", 7, 265, new Unit(7, "Crusader", 600, 6f, 3, 63, 3, 5 , 1.5f), 30));
                buildingList.add(new Building("Hjordhejmen", 8, 300, new Unit(8, "Warlock", 320, 1f, 0, 34, 1, 160 , 2f), 30));

        }

        return buildingList;
    }
}
