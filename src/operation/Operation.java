package operation;

import cell.Cell;
import expression.Expression;

import java.util.Set;

public abstract class Operation implements Expression {
    private Expression exp1;
    private Expression exp2;

    abstract int operate(int i1, int i2);

    Operation(Expression e1, Expression e2) {
        this.exp1 = e1;
        this.exp2 = e2;
    }

    @Override
    public Set<Cell> references() {
        return null;
    }


}
