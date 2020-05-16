import maybeValue.SomeValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spreadSheet.SpreadSheet;

import static spreadSheet.SpreadSheet.*;
import static org.junit.jupiter.api.Assertions.*;


class SpreadSheetTest {

    @BeforeEach
    public void setUpSheet() {
        //spreadSheet.SpreadSheet.put("a3", 42);

        put("a3", SpreadSheet.mult(get("a1"), get("a2")));
        put("a1", 5);
        put("a2", 6);
    }




    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse(get("a3").hasValue());
    }

    @Test
    public void cell_has_value() {

        assertEquals(new SomeValue(30).getValue(), ((SomeValue) get("a3")).getValue());
    }
}