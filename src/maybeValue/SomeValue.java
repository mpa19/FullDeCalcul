package maybeValue;

public class SomeValue extends MaybeValue  {

    private int value;

    public SomeValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }


    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || (this.getClass() != obj.getClass())) {
            return false;
        }

        SomeValue objSomeValue = (SomeValue) obj;
        return getValue() == objSomeValue.getValue();
    }
}
