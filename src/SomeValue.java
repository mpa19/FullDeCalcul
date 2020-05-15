public class SomeValue extends MaybeValue {

    private int value;

    public SomeValue(int value){
        super(true);
        this.value = value;
    }

    int getValue(){
        return value;
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }
}
