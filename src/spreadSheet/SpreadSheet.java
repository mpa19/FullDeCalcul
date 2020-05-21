package spreadSheet;

import cell.Cell;
import expression.Expression;
import maybeValue.MaybeValue;
import maybeValue.SomeValue;
import operation.Mult;
import operation.Plus;
import reference.Reference;

public class SpreadSheet {

    private static int SIZE = 5;
    private static final Sheet SHEET = new Sheet(SIZE);


        public static Expression mult(String ref1, String ref2) {
            Reference a = new Reference(SHEET.getSheet().get(ref1));
            Reference b = new Reference(SHEET.getSheet().get(ref2));
            return  new Mult(a,b);
        }

        public static Expression mult(Expression exp1, Expression exp2) {
            return  new Mult(exp1,exp2);
        }

        public static Expression mult(Expression expr1, String ref2) {
            Reference b = new Reference(SHEET.getSheet().get(ref2));
            return new Mult(expr1,b);
        }

        public static Expression mult(int value1, Expression expr2) {
            return new Mult(new SomeValue(value1), expr2);
        }

        public static Expression mult(int value1, int value2) {
            return new Mult(new SomeValue(value1), new SomeValue(value2));
        }

        public static Expression mult(int value1, String ref2) {
            Reference b = new Reference(SHEET.getSheet().get(ref2));
            return new Mult(new SomeValue(value1), b);
        }

        public static Expression mult(String ref1, Expression expr2) {
            Reference b = new Reference(SHEET.getSheet().get(ref1));
            return new Mult(b, expr2);
        }

        public static Expression mult(String ref1, int value2) {
            Reference b = new Reference(SHEET.getSheet().get(ref1));
            return new Mult(b, new SomeValue(value2));
        }


        public static Expression plus(String ref1, String ref2) {
            Reference a = new Reference(SHEET.getSheet().get(ref1));
            Reference b = new Reference(SHEET.getSheet().get(ref2));
            return  new Plus(a,b);
        }

        public static Expression plus(Expression exp1, Expression exp2) {
            return  new Plus(exp1,exp2);
        }

        public static Expression plus(Expression expr1, String ref2) {
            Reference b = new Reference(SHEET.getSheet().get(ref2));
            return new Plus(expr1,b);
        }

        public static Expression plus(int value1, Expression expr2) {
            return new Plus(new SomeValue(value1), expr2);
        }

        public static Expression plus(int value1, int value2) {
            return new Plus(new SomeValue(value1), new SomeValue(value2));
        }

        public static Expression plus(int value1, String ref2) {
            Reference b = new Reference(SHEET.getSheet().get(ref2));
            return new Plus(new SomeValue(value1), b);
        }

        public static Expression plus(String ref1, Expression expr2) {
            Reference b = new Reference(SHEET.getSheet().get(ref1));
            return new Plus(b, expr2);
        }

        public static Expression plus(String ref1, int value2) {
            Reference b = new Reference(SHEET.getSheet().get(ref1));
            return new Plus(b, new SomeValue(value2));
        }

         public static void put(String name, int value) {
             SHEET.getSheet().get(name).set(new SomeValue(value));
         }

        public static void put(String name, Expression exp) {
            SHEET.getSheet().get(name).set(exp);
        }

        public static void put(String name, String refName) {
            SHEET.getSheet().get(name).set(new Reference(SHEET.getSheet().get(refName)));
        }

        public static MaybeValue get(String name) {
            return SHEET.getSheet().get(name).evaluate();
        }

        public static void clear() {
            SHEET.clear();
        }
}
