import java.util.Set;

public interface Expression {

    Set<Cell> references();

    MaybeValue evaluate();

}
