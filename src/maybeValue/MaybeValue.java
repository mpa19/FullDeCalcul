package maybeValue;

import cell.Cell;
import expression.Expression;

import java.util.Set;

public abstract class MaybeValue implements Expression {

    boolean value;

    public MaybeValue(boolean value){
        this.value = value;
    }
    public boolean hasValue() {
        return value;
    }

    @Override
    public Set<Cell> references() {
        return null;
    }


}
