package reference;

import cell.Cell;
import expression.Expression;
import maybeValue.MaybeValue;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class Reference extends Observable implements Expression, Observer {
    private Cell cl;
    private Set<Cell> depens = new HashSet<>();

    public Reference(Cell ref){
        this.cl = ref;
        //this.addObserver(this.cl);
        //this.cl.set(this);
        this.depens.add(this.cl);
    }


    @Override
    public Set<Cell> references() {
        return this.depens;
    }

    @Override
    public MaybeValue evaluate() {
        return cl.evaluate();
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
}
