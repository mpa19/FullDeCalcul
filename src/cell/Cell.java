package cell;

import expression.Expression;
import maybeValue.MaybeValue;
import maybeValue.NoValue;

import java.util.*;

public class Cell extends Observable implements Observer {
    private Expression exp;
    private MaybeValue val;

    public Cell() {
        this.exp = NoValue.INSTANCE;
        this.val = exp.evaluate();
    }


    public void set(Expression exp) {
        this.exp = exp;
        this.val = exp.evaluate();

        for (Cell s : exp.references()) {
            s.addObserver(this);
        }
        setChanged();
        notifyObservers();
    }


    public MaybeValue evaluate() {
        return this.val;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.val = exp.evaluate();
        setChanged();
        notifyObservers();
    }

}
