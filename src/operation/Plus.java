package operation;

import expression.Expression;
import maybeValue.MaybeValue;
import maybeValue.NoValue;
import maybeValue.SomeValue;


public class Plus extends Operation {
    public Plus(Expression e1, Expression e2) {
        super(e1, e2);

    }

    int plus;
    MaybeValue value = NoValue.INSTANCE;

    @Override
    int operate(int i1, int i2) {
        this.plus = i1+i2;
        value = new SomeValue(plus);
        return plus;

    }

}
