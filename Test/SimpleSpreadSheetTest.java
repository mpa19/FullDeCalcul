import maybeValue.SomeValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static spreadSheet.SpreadSheet.*;
import static org.junit.jupiter.api.Assertions.*;


class SimpleSpreadSheetTest {

    @BeforeEach
    public void setUpSheet() {
        put("a2", 6);
        put("a1", 5);
        put("b1", 1);
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse(get("a3").hasValue());
    }


    /* ------------------------------ Mult Operation ----------------------------- */

    @Test
    public void mult_ref_ref() {
        put("a3", mult("a1", "a2"));
        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void mult_exp_exp() {
        put("a3", mult(get("a1"), get("a2")));
        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void mult_exp_ref() {
        put("a3", mult(get("a1"), "a2"));
        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void mult_val_exp() {
        put("a3", mult(5, get("a2")));
        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void mult_val_val() {
        put("a3", mult(5, 6));
        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void mult_val_ref() {
        put("a3", mult(5, "a2"));
        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void mult_ref_exp() {
        put("a3", mult("a1", get("a2")));
        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void mult_ref_val() {
        put("a3", mult("a1", 6));
        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }



    /* ------------------------------ Plus Operation ----------------------------- */

    @Test
    public void plus_ref_ref() {
        put("a3", plus("a1", "a2"));
        assertEquals(new SomeValue(11).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void plus_exp_exp() {
        put("a3", plus(get("a1"), get("a2")));
        assertEquals(new SomeValue(11).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void plus_exp_ref() {
        put("a3", plus(get("a1"), "a2"));
        assertEquals(new SomeValue(11).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void plus_val_exp() {
        put("a3", plus(5, get("a2")));
        assertEquals(new SomeValue(11).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void plus_val_val() {
        put("a3", plus(5, 6));
        assertEquals(new SomeValue(11).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void plus_val_ref() {
        put("a3", plus(5, "a2"));
        assertEquals(new SomeValue(11).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void plus_ref_exp() {
        put("a3", plus("a1", get("a2")));
        assertEquals(new SomeValue(11).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @Test
    public void plus_ref_val() {
        put("a3", plus("a1", 6));
        assertEquals(new SomeValue(11).getValue(), ((SomeValue) get("a3")).getValue());
    }



    /* --------------------------- Put reference -------------------------- */

    @Test
    public void put_ref() {
        put("a3", "a1");
        assertEquals(new SomeValue(5).getValue(), ((SomeValue) get("a3")).getValue());
    }

    @AfterEach
    public void clearSheet() {
        clear();
    }
}