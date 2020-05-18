import maybeValue.SomeValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadSheet.SpreadSheet;

import static spreadSheet.SpreadSheet.*;
import static org.junit.jupiter.api.Assertions.*;


class SpreadSheetTest {

    @BeforeEach
    public void setUpSheet() {
        put("a1", 5);
        put("a2", 6);
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse(get("a3").hasValue());
    }

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
}