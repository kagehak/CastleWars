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
    |Normal  |   120 %   | 100 % | 120 %  | 100 % |   100 %   |
    |--------+-----------+-------+--------+-------+-----------|
    |Piercing|   150 %   | 150 % | 80 %   | 50 %  |   50 %   |
    |--------+-----------+-------+--------+-------+-----------|
    |Siege   |   100 %   | 100 % | 100 %  | 100 % |   200 %   |
    |--------+-----------+-------+--------+-------+-----------|
    |Magic   |   100 %   | 80 %  | 120 %  | 200 % |   100 %   |
    |---------------------------------------------------------|

     */

    public static float GetDamage(int attacktype, float damage, int armortype, float armor) {
        float[][] typeRation = {
                {1.2f, 1.0f, 1.2f, 1.0f, 1.0f},
                {1.5f, 1.5f, 0.8f, 0.5f, 0.5f},
                {1.0f, 1.0f, 1.0f, 1.0f, 2.0f},
                {1.0f, 0.8f, 1.2f, 2.0f, 1.0f}
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
