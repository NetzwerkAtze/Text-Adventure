package day;

import entity.Entity;
import entity.Player;

public class day {
    public static int day = 0;

    public day(){
        day = day + 1;
    }
    public static int getDay(){
        return day;
    }
    public void starving(Player player) {
        if (player.isHungry())
            player.takeDamage(player.getHp()/5);
    }
}
