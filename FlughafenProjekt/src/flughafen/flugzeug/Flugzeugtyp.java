// Datei: Flugzeugtyp.java

package flughafen.flugzeug;

public class Flugzeugtyp
{
   private String bezeichnung;

   public Flugzeugtyp (String bezeichnung)
   {
      this.bezeichnung = bezeichnung;
   }

   public String toString()
   {
      return bezeichnung;
   }
}