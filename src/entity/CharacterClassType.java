package entity;

public enum CharacterClassType {
    WARRIOR(1),
    MAGE(2),
    RANGER(3);

    private final int id;

    CharacterClassType(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
