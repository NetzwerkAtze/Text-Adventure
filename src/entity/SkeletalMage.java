package entity;

import ability.Fireball;

public class SkeletalMage extends Entity {
    static String  name = "Skeletal Mage";
    static int baseHP = 35;
    static int baseAttack = 10;

    public SkeletalMage() {
        super(name, baseHP, baseAttack);
        addAbility(new Fireball());
    }
}
