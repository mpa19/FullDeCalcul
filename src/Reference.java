import java.util.Set;

public class Reference implements Expression {
    private Set<Cell> cell;

    public Reference(Cell ref){
        this.cell.add(ref);
    }
    @Override
    public Set<Cell> references() {
        return cell;
    }

    @Override
    public MaybeValue evaluate() {
        return null;
    }
}
