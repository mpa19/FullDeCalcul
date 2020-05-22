package maybeValue;


public class NoValue extends MaybeValue {
    public static final NoValue INSTANCE = new NoValue();

    @Override
    public boolean hasValue() {
        return false;
    }
}
