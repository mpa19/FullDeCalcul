package expression;

import cell.Cell;
import maybeValue.MaybeValue;

import java.util.Set;

public interface Expression {

    Set<Cell> references();

    MaybeValue evaluate();

}
