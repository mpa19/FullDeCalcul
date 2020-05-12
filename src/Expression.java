import java.util.Observable;

import java.util.Observer;
import java.util.Set;

public interface Expression {

    Set<Cell> references();

    MaybeValue evaluate();

}
