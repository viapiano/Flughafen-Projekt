// Datei: Bahn.java

package flughafen;

public class Bahn
{
   private static int anzahlBahnen;
   private int nummer;

   public Bahn()
   {
      anzahlBahnen++;
      nummer = anzahlBahnen;
   }

   public String toString()
   {
      return "Bahn Nummer " + nummer;
   }
}