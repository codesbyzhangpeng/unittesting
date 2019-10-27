package de.thorstendiekhof.kurs.unittesting.wastesten;

public class EinheitenFormatter {

    private static final String KOPF = "%s, %s";
    private static final String KAMPFWERTE = "A%s / B%s";

    public static String format(Einheit einheit){
        String ausgabe = String.format(KOPF, einheit.name, einheit.beschreibung);
        ausgabe += "\n";
        ausgabe += String.format(KAMPFWERTE, einheit.angriff, einheit.verteidigung);
        ausgabe += "\n";
        ausgabe += generiereLebensbalken(einheit.leben, einheit.maxLeben);
        return ausgabe;
    }

    private static String generiereLebensbalken(int leben, int maxLeben){
        String lebensBalken = "";
        for (int i = 0; i < leben; i++)
            lebensBalken += "O";
        for (int i = 0; i < maxLeben-leben; i++)
            lebensBalken += "-";
        return lebensBalken;
    }
    
}