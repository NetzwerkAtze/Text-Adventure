package items;

import entity.Player;

public abstract class Item {
    private String name;

    public String getName(){
        return name;
    }
    public abstract boolean use(Player player);
}
