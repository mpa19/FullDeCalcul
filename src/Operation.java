import java.util.Set;

public abstract class Operation implements Expression {

    abstract int operate(int i1, int i2);

    @Override
    public Set<Cell> references() {
        return null;
    }

    @Override
    public MaybeValue evaluate() {
        return null;
    }
}
