import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.jupiter.api.Assertions.*;


class SpreadSheetTest {

    @BeforeEach
    public void setUpSheet() {
        //SpreadSheet.put("a3", 42);
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse(SpreadSheet.get("a3").hasValue());
    }

    @Test
    public void cell_has_value() {
        assertEquals(new SomeValue(42), SpreadSheet.get("a3"));
    }
}