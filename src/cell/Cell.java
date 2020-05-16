package cell;

import expression.Expression;
import maybeValue.MaybeValue;
import maybeValue.NoValue;

public class Cell {
    private Expression exp;
    private MaybeValue val;

    public Cell() {
        this.exp = NoValue.INSTANCE;
        this.val = exp.evaluate();
    }

    public void set(Expression exp) {
        this.exp = exp;
        this.val = exp.evaluate();
    }


    public MaybeValue evaluate() {
        return this.val;
    }
}
