package reference;

import cell.Cell;
import expression.Expression;
import maybeValue.MaybeValue;

import java.util.Set;

public class Reference implements Expression {
    private Set<Cell> cell;
    private Cell cl;

    public Reference(Cell ref){
        this.cl = ref;
    }
    @Override
    public Set<Cell> references() {
        return cell;
    }

    @Override
    public MaybeValue evaluate() {
        return cl.evaluate();
    }
}
