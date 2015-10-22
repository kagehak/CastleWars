package kagehak.game.castlewars.gameEntities.units;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * Created by kagehak on 9/11/15.
 */
public class Unit {
    private Rectangle unitbounds;
    private Rectangle attackbounds; // Unit range
    Vector2 position;
    private int level;

    BitmapFont font;

    Texture texture;
    Animation animation;
    TextureRegion[] frames;
    TextureRegion currentFrame;
    float stateTime;

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

        /* TEXTURE */
        this.texture = new Texture(Gdx.files.internal("sprites.png"));
        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth() / 4 ,texture.getHeight() / 4);
        frames = new TextureRegion[4 * 4];
        int index = 0;
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                frames[index++] = tmp[i][j];
            }
        }
        animation = new Animation(1f, frames);
        stateTime = 0f;
        currentFrame = animation.getKeyFrame(0);

        /* FONT */
        font = new BitmapFont();
        font.setColor(Color.RED);
        font.getData().setScale(0.1f);
    }

    public void Move(List<Unit> playerUnits, List<Unit> enemyUnits){
        unitbounds.set(position.x, position.y, currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
        attackbounds.set(position.x, position.y, attackbounds.getWidth(), 128);
        if(stateTime < 4)
            stateTime += Gdx.graphics.getDeltaTime()*4;
        else
            stateTime = 0;

        currentFrame = animation.getKeyFrame(0 + stateTime);

        if(enemyUnits.contains(this)) {
            position.x -= 1f;
            attackbounds.set(position.x - attackbounds.getWidth() + currentFrame.getRegionWidth(), position.y, attackbounds.getWidth(), 128);
            currentFrame.flip(true, false);
        }
        else
            position.x += 1f;

    }

    public void Attack(List<Unit> playerUnits, List<Unit> enemyUnits) {
        unitbounds.set(position.x, position.y, currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
        if(stateTime < 4)
            stateTime += Gdx.graphics.getDeltaTime()*4;
        else
            stateTime = 0;
        currentFrame = animation .getKeyFrame(4 + stateTime);
        if(enemyUnits.contains(this)) {
            currentFrame.flip(true, false);
        }

    }

    public void Draw(SpriteBatch batch){
        batch.draw(currentFrame, position.x, position.y);
        font.draw(batch, (double)Math.round(health * 10) / 10 + " HP", position.x, position.y + currentFrame.getRegionHeight()+ 20);
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


