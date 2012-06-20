// Datei: Abfrage.java

package hilfsklassen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Abfrage
{
   public static int abfrageInt (String frage)
   {
      try
      {
         int zahl = Integer.parseInt (abfrageString (frage));
         if (zahl < 0)
         	throw new NumberFormatException ("");
         return zahl;
      }
      catch (NumberFormatException e)
      {
         System.out.println ("Bitte eine gueltige Zahl eingeben!");
         return abfrageInt (frage);
      }
   }

   public static int abfrageInt (String frage, int min, int max)
   {
      int zahl = abfrageInt (frage + " (" + min + "-" + max + "):");
      if (zahl < min || zahl > max)
      {
         System.out.println ("Bitte eine Zahl im Bereich von " + min + " und " + max + " eingeben.");
         zahl = abfrageInt (frage, min, max);
      }

      return zahl;
   }

   public static String abfrageString (String frage)
   {
      try
      {
         System.out.print (frage + " ");
         return (new java.util.Scanner (System.in)).nextLine();
      }
      catch (Exception e)
      {
         return "";
      }
   }

   public static Calendar abfrageUhrzeit (String frage)
   {
      SimpleDateFormat formatter = new SimpleDateFormat ("HH:mm");
      try
      {
         Date date = formatter.parse (abfrageString (frage + " (HH:mm):"));
         Calendar calendar = new GregorianCalendar();
         calendar.setTime (date);
         return calendar;
      }
      catch (ParseException e)
      {
         System.out.println ("Bitte eine gueltige Uhrzeit eingeben!");
         return abfrageUhrzeit (frage);
      }
   }
}
