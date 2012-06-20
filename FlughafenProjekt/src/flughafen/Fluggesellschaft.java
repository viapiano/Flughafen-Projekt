// Datei: Fluggesellschaft.java

package flughafen;

public class Fluggesellschaft
{
   private String name;
   private String ort;
   private String strasse;

   public Fluggesellschaft (String name, String strasse, String ort)
   {
      this.name = name;
      this.strasse = strasse;
      this.ort = ort;
   }
   
   public String getKuerzel()
   {
      String kuerzel;
      // Das Kuerzel besteht aus den ersten beiden Zeichen der Fluggesellschaft.
      if (name.length() < 2)
      {
         kuerzel = name;
      }
      else
      {
         kuerzel = name.substring (0, 2);
      }
      
      return kuerzel.toUpperCase();
   }

   public String getName()
   {
      return name;
   }

   public String getOrt()
   {
      return ort;
   }

   public String getStrasse()
   {
      return strasse;
   }

   public void setName (String name)
   {
      this.name = name;
   }

   public void setOrt (String ort)
   {
      this.ort = ort;
   }

   public void setStrasse (String strasse)
   {
      this.strasse = strasse;
   }

   public String toString()
   {
      return name + " in " + strasse + ", " + ort;
   }
}