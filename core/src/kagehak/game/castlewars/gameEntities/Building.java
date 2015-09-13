package kagehak.game.castlewars.gameEntities;

import kagehak.game.castlewars.gameEntities.units.Unit;

/**
 * Created by kagehak on 9/11/15.
 */
public class Building {
    private String name;
    private int level;
    private int Cost;

    private Unit spawnUnit;
    private float spawnInterval;

    private Building upgradeBuilding;

    public Building(String name, int level, int cost, Unit spawnUnit, float spawnInterval) {
        this.name = name;
        this.level = level;
        Cost = cost;
        this.spawnUnit = spawnUnit;
        this.spawnInterval = spawnInterval;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public Unit getSpawnUnit() {
        return spawnUnit;
    }

    public void setSpawnUnit(Unit spawnUnit) {
        this.spawnUnit = spawnUnit;
    }

    public float getSpawnInterval() {
        return spawnInterval;
    }

    public void setSpawnInterval(float spawnInterval) {
        this.spawnInterval = spawnInterval;
    }

    public Building getUpgradeBuilding() {
        return upgradeBuilding;
    }

    public void setUpgradeBuilding(Building upgradeBuilding) {
        this.upgradeBuilding = upgradeBuilding;
    }
}
