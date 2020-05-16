package operation;

import expression.Expression;
import maybeValue.MaybeValue;
import operation.Operation;

public class Plus extends Operation {
    Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    int operate(int i1, int i2) {
        return i1+i2;
    }

    @Override
    public MaybeValue evaluate() {
        return null;
    }
}
