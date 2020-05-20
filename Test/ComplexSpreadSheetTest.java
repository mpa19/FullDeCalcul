import maybeValue.SomeValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static spreadSheet.SpreadSheet.*;


class ComplexSpreadSheetTest {

    @BeforeEach
    public void setUpSheet() {
        put("c1", mult("a1", "b1"));
        put("c2", mult("a2", "b2"));
        put("c3", plus("c1", "c2"));

        put("a1", 10);put("b1", 20);
        put("a2", 30);put("b2", 40);
        put("a3", mult(plus("a1", "b3"), "a4"));
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void complex1() {
        put("a4", 5);
        put("b3", plus("a1", "b1"));
        assertEquals(new SomeValue(200).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void complex2() {
        assertEquals(new SomeValue(1400).getValue(), ((SomeValue) get("c3")).getValue());
    }

    @Test
    public void complex3() {
        put("a1", "b1");
        assertEquals(new SomeValue(1600).getValue(), ((SomeValue) get("c3")).getValue());
    }


    @AfterEach
    public void clearSheet() {
        clear();
    }
}