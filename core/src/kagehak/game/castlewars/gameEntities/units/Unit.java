package kagehak.game.castlewars.gameEntities.units;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

/**
 * Created by kagehak on 9/11/15.
 */
public class Unit {
    private Rectangle unitbounds;
    private Rectangle attackbounds; // Unit range
    private int level;

    private String name;

    private float health;
    private float armor;
    private int armorType;

    private float damage;
    private int damageType;
    private float range;
    private float attackSpeed;
    private float timeSinceLastAttack;

    private  boolean fromRight; // true if unit is spawned in right side, false if spawned in left side

    public Unit(int level, String name, float health, float armor, int armorType, float damage, int damageType, float range, float attackSpeed) {
        this.level = level;
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.armorType = armorType;
        this.damage = damage;
        this.damageType = damageType;
        this.range = range;
        this.attackSpeed = attackSpeed;
    }

    public void Move(List<Unit> playerUnits, List<Unit> enemyUnits){
        // Code for Unit move
    }

    public void Attack(List<Unit> playerUnits, List<Unit> enemyUnits) {
        // Code for Attack move
    }

    public void Draw(SpriteBatch batch){
        // Code for drawing Unit
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rectangle getUnitbounds() {
        return unitbounds;
    }

    public void setUnitbounds(Rectangle unitbounds) {
        this.unitbounds = unitbounds;
    }

    public Rectangle getAttackbounds() {
        return attackbounds;
    }

    public void setAttackbounds(Rectangle attackbounds) {
        this.attackbounds = attackbounds;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public int getArmorType() {
        return armorType;
    }

    public void setArmorType(int armorType) {
        this.armorType = armorType;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public int getDamageType() {
        return damageType;
    }

    public void setDamageType(int damageType) {
        this.damageType = damageType;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public float getTimeSinceLastAttack() {
        return timeSinceLastAttack;
    }

    public void setTimeSinceLastAttack(float timeSinceLastAttack) {
        this.timeSinceLastAttack = timeSinceLastAttack;
    }

    public boolean isFromRight() {
        return fromRight;
    }

    public void setFromRight(boolean fromRight) {
        this.fromRight = fromRight;
    }
}


