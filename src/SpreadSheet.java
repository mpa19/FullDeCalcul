import java.util.Set;

public class SpreadSheet {

    private static int SIZE = 5;
 private static final Sheet SHEET = new Sheet(SIZE);

         /*public static Expression plus(Expression expr1, Expression expr2) {
            // Crea i retorna una expressió corresponent a la
            // suma de les dues subexpressions

         }*/

         /*public static Expression plus(Expression expr1, int value2) {
            // Crea i retorna una expressió corresponent a la
            // suma de expr1 i de l’expressió que representa
            // la constant value2
        }*/

        public static MaybeValue get(String name) {
            // Retorna el valor que potser hi ha a la cel·la
            // amb nom name.
             // Si hi ha un valor, es retorna una instància de
             // SomeValue; si no hi ha, NoValue

            return SHEET.getSheet().get(name).evaluate();
        }

        public static void put(String name, Expression expr) {
            // Assigna a la cel·la amb nom name l’expressió
            // expr.
             // Això provocarà l’avaluació de la cel·la (la
            // qual cosa pot propagar la avaluació a d’altres
             // cel·les)

        }

         public static void put(String name, int value) {
         // Assigna a la cel·la amb nom name l’expressió
         // el valor value (Òbviament caldrà construir la
         // representació d’aquest int com Expression).
         // Això pot provocar avaluacions d’aquesta o
         // d’altres cel·les

             SHEET.getSheet().get(name).set(new SomeValue(42).evaluate());

         }
}
