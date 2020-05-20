package spreadSheet;

import cell.Cell;

import java.util.HashMap;

public class Sheet {
    private String[] column = new String[]{"a", "b", "c", "d", "e", "f"};
    private HashMap<String, Cell> sheet = new HashMap<>();
    public Sheet(int size) {

        for(int i = 0; i < size; i++) {
            for(int a = 0; a < size; a++) {
                sheet.put(column[i]+(a+1), new Cell());
            }
        }
    }

    public HashMap<String, Cell> getSheet() { return sheet; }

    public void clear() {
        sheet.replaceAll( (k,v)->v=new Cell());
    }
}
