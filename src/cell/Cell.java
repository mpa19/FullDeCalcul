package cell;

import expression.Expression;
import maybeValue.MaybeValue;
import maybeValue.NoValue;
import maybeValue.SomeValue;
import reference.Reference;

import java.util.*;

public class Cell extends Observable implements Observer {
    private Expression exp;
    private MaybeValue val;
    private List<Cell> subjects = new ArrayList<>();

    public Cell() {
        this.exp = NoValue.INSTANCE;
        this.val = exp.evaluate();
    }


    /*public void set(Expression exp) {
        this.exp = exp;
        this.val = exp.evaluate();
        if(exp instanceof Reference) {
            this.addObserver((Reference) exp);
            ((Reference) exp).setRef(this);
        }
        else {
            setChanged();
            notifyObservers();
        }
    }*/

    public void set(Expression exp) {
        this.exp = exp;
        this.val = exp.evaluate();

        if(exp instanceof SomeValue) {
            setChanged();
            notifyObservers();
        } else {
            for (Cell s : exp.references()) {
                s.addObserver(this);
            }
        }

    }



    public MaybeValue evaluate() {
        return this.val;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.val = exp.evaluate();
    }
}
