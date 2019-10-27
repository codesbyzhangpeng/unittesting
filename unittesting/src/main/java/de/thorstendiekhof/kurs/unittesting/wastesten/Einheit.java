package de.thorstendiekhof.kurs.unittesting.wastesten;

public class Einheit {

    public String name;
    public String beschreibung;
    public int angriff;
    public int verteidigung;
    public int maxLeben;
    public int leben;

    public static Einheit buildRitter(){
        Einheit einheit = new Einheit();
        einheit.name = "Ritter";
        einheit.beschreibung = "Ein Krieger in Rüstung auf einem Pferd. Er trägt Lanze, Schild und Schwert.";
        einheit.angriff = 5;
        einheit.verteidigung = 5;
        einheit.maxLeben = 10;
        einheit.leben = 10;
        return einheit;
    }
    
}