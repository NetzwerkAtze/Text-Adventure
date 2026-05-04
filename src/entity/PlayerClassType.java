package entity;

public enum PlayerClassType {
    WARRIOR(1),
    MAGE(2),
    RANGER(3);

    private final int id;

    PlayerClassType(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
