package ability;
import entity.Entity;

public interface Effect {
    void onTurnEnd(Entity entity);
    String getName();
    boolean isExpired();
}
