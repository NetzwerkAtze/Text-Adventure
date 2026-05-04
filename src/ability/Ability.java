package ability;

import entity.Entity;

public interface Ability {
    void use(Entity user, Entity target);
    String getName();
}
