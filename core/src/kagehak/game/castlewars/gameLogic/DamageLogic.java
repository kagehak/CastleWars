package kagehak.game.castlewars.gameLogic;

import java.util.Random;

/**
 * Created by kagehak on 9/10/15.
 */
public class DamageLogic {
    /*
    ---ATTACKTYPES---
    0: Normal
    1: Piercing
    2: Siege
    3: Magic
    ---ARMORTYPES---
    0: Unarmored
    1: Light
    2: Medium
    3: Heavy
    4: Fortified


    ___________________________________________________________
    |        | Unarmored | Light | Medium | Heavy | Fortified |
    |--------+-----------+-------+--------+-------+-----------|
    |Normal  |   105 %   | 70 %  | 175 %  | 100 % |   50 %    |
    |--------+-----------+-------+--------+-------+-----------|
    |Piercing|   105 %   | 175 % | 100 %  | 70 %  |   50 %    |
    |--------+-----------+-------+--------+-------+-----------|
    |Siege   |   100 %   | 70 %  | 70 %   | 70 %  |   175 %   |
    |--------+-----------+-------+--------+-------+-----------|
    |Magic   |   105 %   | 100 %  | 70 %  | 175 % |   40 %    |
    |---------------------------------------------------------|

     */

    public static float GetDamage(int attacktype, float damage, int armortype, float armor) {
        float[][] typeRation = {
                {1.05f, 0.7f, 1.75f, 1.0f, 0.5f},
                {1.05f, 1.75f, 1.0f, 0.7f, 0.5f},
                {1.0f, 0.7f, 0.7f, 0.7f, 1.75f},
                {1.05f, 1.0f, 0.7f, 1.75f, 0.4f}
        };
        double m = Math.log10(armor + 1) / 2;
        float f = (float) ((damage * typeRation[attacktype][armortype]) * (1.0f - m));
        return f;
    }

    public static int Random(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
