package entity;

import ability.Bite;

public class WolfPack extends Entity{
    static String  wolfName = "Wolf Pack";
    static int baseHP = 25;
    static int baseAttack = 7;

    public WolfPack() {
        super(wolfName, baseHP, baseAttack);
        addAbility(new Bite());
    }

}
