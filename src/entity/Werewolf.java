package entity;

import ability.Claw;

public class Werewolf extends Entity {
    static String  wolfName = "Werewolf";
    static int baseHP = 30;
    static int baseAttack = 10;

    public Werewolf() {
        super(wolfName, baseHP, baseAttack);
        addAbility(new Claw());
    }
}
