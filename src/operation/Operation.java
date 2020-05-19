package operation;

import cell.Cell;
import expression.Expression;
import maybeValue.MaybeValue;
import maybeValue.SomeValue;

import java.util.HashSet;
import java.util.Observer;
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
        Set<Cell> depens = new HashSet<>();
        depens.addAll(exp1.references());
        depens.addAll(exp2.references());
        return depens;
    }

    @Override
    public MaybeValue evaluate() {
        if(this.exp1.evaluate().hasValue() && this.exp2.evaluate().hasValue()){
            int sol = operate(((SomeValue) this.exp1.evaluate()).getValue(), ((SomeValue) this.exp2.evaluate()).getValue());
            return new SomeValue(sol);
        }
        return null;
    }
}
