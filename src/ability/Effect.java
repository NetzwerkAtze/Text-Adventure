package ability;
import entity.Entity;

public interface Effect {
    void onApply(Entity entity);
    void onTurnStart(Entity entity);
    void onTurnEnd(Entity entity);
    boolean isExpired();
}
