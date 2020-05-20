package operation;

import cell.Cell;
import expression.Expression;
import maybeValue.MaybeValue;
import maybeValue.NoValue;
import maybeValue.SomeValue;

import java.util.HashSet;
import java.util.Set;

public class Mult extends Operation {
    private Set<Cell> cel = new HashSet<>();

    public Mult(Expression e1, Expression e2) {
        super(e1, e2);


    }

    int mult;
    MaybeValue value = NoValue.INSTANCE;

    @Override
    int operate(int i1, int i2) {
        this.mult = i1*i2;
        value = new SomeValue(mult);
        return mult;

    }




}
