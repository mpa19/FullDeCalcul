package maybeValue;

import cell.Cell;
import expression.Expression;

import java.util.HashSet;
import java.util.Set;

public abstract class MaybeValue implements Expression {


    public abstract boolean hasValue();

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

}
