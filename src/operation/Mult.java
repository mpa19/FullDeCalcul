package operation;

import expression.Expression;
import maybeValue.MaybeValue;
import maybeValue.NoValue;
import maybeValue.SomeValue;
import operation.Operation;

public class Mult extends Operation {
    public Mult(Expression e1, Expression e2) {
        super(e1, e2);
        if(e1.evaluate().hasValue() && e2.evaluate().hasValue()){
            operate(((SomeValue) e1).getValue(), ((SomeValue) e2).getValue());
        }

    }

    int mult;
    MaybeValue value = NoValue.INSTANCE;

    @Override
    int operate(int i1, int i2) {
        this.mult = i1*i2;
        value = new SomeValue(mult);
        return mult;

    }

    @Override
    public MaybeValue evaluate() {
        return value;
    }
}
