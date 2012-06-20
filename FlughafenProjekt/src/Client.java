// Datei: Client.java

import java.util.Calendar;

import flughafen.Bahn;
import flughafen.Fluggesellschaft;
import flughafen.flugzeug.Flugzeug;
import flughafen.flugzeug.Flugzeugtyp;
import flughafen.parkstelle.Parkposition;
import flughafen.parkstelle.SeparateParkposition;
import flughafen.parkstelle.Werft;
import hilfsklassen.Abfrage;

public class Client
{
   private Bahn [] bahnen = new Bahn [4];
   private Parkposition [] parkpositionen = new Parkposition [10];

   public Client()
   {
      for (int i = 0; i < 4; i++)
      {
         bahnen[i] = new Bahn();
      }

      for (int i = 0; i < 10; i++)
      {
         parkpositionen[i] = new Parkposition();
      }
   }

   public static void main (String [] args)
   {
      Client client = new Client();
      Flugzeug flugzeug = client.meldeFlugzeugZurLandung();
      client.vergebeLandebahnAnFlugzeug (flugzeug);
      client.vergebeParkstelleAnFlugzeug (flugzeug);
      client.meldeFlugzeugGelandet (flugzeug);
      client.vergebeStartbahnAnFlugzeug (flugzeug);
      client.meldeFlugzeugGestartet (flugzeug);
   }

   public void meldeFlugzeugGelandet (Flugzeug flugzeug)
   {
      Calendar istzeitLandung = Abfrage.abfrageUhrzeit ("Geben Sie die Istzeit der Landung ein");
      flugzeug.meldeGelandet (istzeitLandung);
      flugzeug.print();
   }

   public void meldeFlugzeugGestartet (Flugzeug flugzeug)
   {
      Calendar istzeitStart = Abfrage.abfrageUhrzeit ("Geben Sie die Istzeit des Starts ein");
      flugzeug.meldeGestartet (istzeitStart);
      flugzeug.print();
   }

   public Flugzeug meldeFlugzeugZurLandung()
   {
      String typ = Abfrage.abfrageString ("Geben Sie den Flugzeug Typ ein:");
      Flugzeugtyp flugzeugtyp = new Flugzeugtyp (typ);

      String name = Abfrage.abfrageString ("Geben Sie den Namen der Fluggesellschaft ein:");
      String strasse = Abfrage.abfrageString ("Geben Sie die Strasse von " + name + " ein:");
      String ort = Abfrage.abfrageString ("Geben Sie den Ort von " + name + " ein:");
      Fluggesellschaft fluggesellschaft = new Fluggesellschaft (name, strasse, ort);

      Calendar sollzeitLandung = Abfrage.abfrageUhrzeit ("Geben Sie die Sollzeit der Landung ein");

      Flugzeug flugzeug = new Flugzeug (flugzeugtyp, fluggesellschaft, sollzeitLandung);
      flugzeug.print();
      return flugzeug;
   }

   public void vergebeLandebahnAnFlugzeug (Flugzeug flugzeug)
   {
      int landebahnNummer = Abfrage.abfrageInt ("Geben Sie die Nummer der Landebahn ein", 1, 4) - 1;
      Bahn landebahn = bahnen[landebahnNummer];
      flugzeug.vergebeLandebahn (landebahn);
      flugzeug.print();
   }

   public void vergebeParkstelleAnFlugzeug (Flugzeug flugzeug)
   {
      String inWerft = Abfrage.abfrageString ("Soll das Flugzeug in die Werft verlegt werden? (j/n)");
      if (inWerft.equals ("j"))
      {
         flugzeug.vergebeParkstelle (new Werft());
      }
      else
      {
         String aufSeparatesParkfeld = Abfrage.abfrageString ("Soll das Flugzeug auf ein separates Parkfeld verlegt werden? (j/n)");
         if (aufSeparatesParkfeld.equals ("j"))
         {
            flugzeug.vergebeParkstelle (new SeparateParkposition());
         }
         else
         {
            int parkpositionNummer = Abfrage.abfrageInt ("Geben Sie die Nummer der Parkposition ein", 1, 10) - 1;
            Parkposition parkposition = parkpositionen[parkpositionNummer];
            flugzeug.vergebeParkstelle (parkposition);
         }
      }
      flugzeug.print();
   }

   public void vergebeStartbahnAnFlugzeug (Flugzeug flugzeug)
   {
      int startbahnNummer = Abfrage.abfrageInt ("Geben Sie die Nummer der Startbahn ein", 1, 4) - 1;
      Bahn startbahn = bahnen[startbahnNummer];
      Calendar sollzeitStart = Abfrage.abfrageUhrzeit ("Geben Sie die Sollzeit fuer den Start ein");
      flugzeug.vergebeStartbahn (startbahn, sollzeitStart);
      flugzeug.print();
   }
}