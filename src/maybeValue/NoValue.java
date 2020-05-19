package maybeValue;


public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();

    private NoValue() {
        super(false);
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

}
