package entity;

import ability.HeavyStrike;

public class Bandit extends Entity {
    static String  banditName = "The Bandit Leader";
    static int baseHP = 40;
    static int baseAttack = 10;

    public Bandit() {
        super(banditName, baseHP, baseAttack);
        addAbility(new HeavyStrike());
    }
}
