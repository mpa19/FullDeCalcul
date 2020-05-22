package reference;

import cell.Cell;
import expression.Expression;
import maybeValue.MaybeValue;

import java.util.HashSet;
import java.util.Set;

public class Reference implements Expression {
    private Cell cl;
    private Set<Cell> depens = new HashSet<>();

    public Reference(Cell ref){
        this.cl = ref;
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

}
