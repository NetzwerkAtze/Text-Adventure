package entity;

public class Entity {

    private String name;
    private int hp;
    private int attack;

    public Entity(String name, int hp, int attack) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }
    public boolean isAlive(){
        return hp > 0;
    }
    public void takeDamage(int dmg) {
        hp = hp - dmg < 0 ? 0 : hp - dmg;
    }
    public void attack(Entity target) {
        System.out.println(name +  " greift " + target.name + " an!");
        target.takeDamage(getAttack());
        System.out.println(target.name + " hat noch " + target.getHp() + " HP.");
    }
    public int getHp() {
        return hp;
    }
    public int getAttack() {
        return attack;
    }
}
