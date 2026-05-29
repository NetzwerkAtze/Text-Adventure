package entity;

public interface CharacterClass {
    void applyTo(Entity entity);
    String getName();
}
