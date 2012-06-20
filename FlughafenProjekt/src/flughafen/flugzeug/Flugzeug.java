// Datei: Flugzeug.java

package flughafen.flugzeug;

import java.util.Calendar;

import flughafen.Bahn;
import flughafen.Fluggesellschaft;
import flughafen.parkstelle.Parkstelle;

public class Flugzeug
{
   private static int anzahlFlugzeuge;
   private Fluggesellschaft fluggesellschaft;
   private String flugnummer;
   private Flugzeugtyp flugzeugtyp;
   private Calendar istzeitLandung;
   private Calendar istzeitStart;
   private Bahn landebahn;
   private Parkstelle parkstelle;
   private Calendar sollzeitLandung;
   private Calendar sollzeitStart;
   private Bahn startbahn;
   private Status status;

   public Flugzeug (Flugzeugtyp flugzeugtyp, Fluggesellschaft fluggesellschaft, Calendar sollzeitLandung)
   {
      // Anzahl der Flugzeuge um eins erhoehen, diese wird fuer die eindeutige Flugnummer benoetigt
      anzahlFlugzeuge++;
      
      // Flugnummer aus Kuerzel und eindeutiger ID generieren
      flugnummer = fluggesellschaft.getKuerzel() + " " + (anzahlFlugzeuge + 100);

      this.flugzeugtyp = flugzeugtyp;
      this.fluggesellschaft = fluggesellschaft;
      status = Status.Wartend;
      this.sollzeitLandung = sollzeitLandung;
   }

   public void meldeGelandet (Calendar istzeitLandung)
   {
      this.istzeitLandung = istzeitLandung;
      status = Status.Geparkt;
   }

   public void meldeGestartet (Calendar istzeitStart)
   {
      this.istzeitStart = istzeitStart;
      status = Status.Gestartet;
   }

   public void print()
   {
      System.out.print ("Flugzeug " + flugnummer);
      System.out.println (" befindet sich im Status \'" + status + "\'.");
      System.out.print ("Es ist vom Typ " + flugzeugtyp);
      System.out.println (" und gehoert der Fluggesellschaft " + fluggesellschaft + ".");

      // Nur Ausgeben wenn mindestens die Landebahn belegt wurde
      if (landebahn != null)
      {
         System.out.println ("Es wird verwendet/wurde verwendet:");
         System.out.println ("- Landet auf: " + landebahn);
         if (parkstelle != null)
         {
            System.out.println ("- " + parkstelle);
         }
         if (startbahn != null)
         {
            System.out.println ("- Startet von: " + startbahn);
         }
      }
      System.out.println();
   }

   public void vergebeLandebahn (Bahn landebahn)
   {
      this.landebahn = landebahn;
      status = Status.Landeanflug;
   }

   public void vergebeParkstelle (Parkstelle parkstelle)
   {
      this.parkstelle = parkstelle;
      status = Status.Gelandet;
   }

   public void vergebeStartbahn (Bahn startbahn, Calendar sollzeitStart)
   {
      this.startbahn = startbahn;
      this.sollzeitStart = sollzeitStart;
      status = Status.Startvorbereitung;
   }

   public Calendar getIstzeitLandung() 
   {
      return istzeitLandung;
   }

   public Calendar getIstzeitStart() 
   {
      return istzeitStart;
   }

   public Calendar getSollzeitLandung() 
   {
      return sollzeitLandung;
   }

   public Calendar getSollzeitStart() 
   {
      return sollzeitStart;
   }
}