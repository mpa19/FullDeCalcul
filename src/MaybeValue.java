import java.util.Set;

public abstract class MaybeValue implements Expression {
    @Override
    public Set<Cell> references() {
        return null;
    }

    @Override
    public MaybeValue evaluate() {
        return null;
    }
}
