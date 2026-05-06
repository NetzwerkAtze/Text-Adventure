package day;

import entity.Entity;

public class day {
    public static int day = 0;

    public day(){
        day = day + 1;
    }
    public static int getDay(){
        return day;
    }
    public void starving(Entity player) {
        if (player.isHungry())
            player.takeDamage(player.getHp()/5);
    }
}
