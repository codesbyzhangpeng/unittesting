package de.thorstendiekhof.kurs.unittesting.uebungen.externeaufrufe.loesung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MietMaxGenerator {

    Datenbestand[] datenbestaende;

    public MietMaxGenerator(Datenbestand... datenbestaende){
        this.datenbestaende = datenbestaende;
    }

	private List<String> generiereAnzeigen(String ort, int zimmer) {
        List<Wohnung> wohnungen = sucheWohnungen(ort, zimmer);
        List<String> anzeigen = new ArrayList<String>();
        System.out.println("Für deine Anfrage liegen " + wohnungen.size() + " Anzeigen vor.");
        for (Wohnung wohnung : wohnungen)
            anzeigen.add(formatAnzeige(wohnung));
		return anzeigen;
	}
    
    private List<Wohnung> sucheWohnungen(String ort, int zimmer) {
        List<Wohnung> wohnungen = new ArrayList<Wohnung>();
        for (Datenbestand datenbestand : datenbestaende) 
            wohnungen.addAll(datenbestand.searchWohnungen(ort,zimmer));
		return wohnungen;
    }
    
    private String formatAnzeige(Wohnung wohnung){
        return " -> '" + wohnung.beschreibung + "'" 
        + " in " + wohnung.stadt 
        + " mit " + wohnung.raeume + " Zimmern, "
        + " für nur " + wohnung.miete / 30 + " EUR pro Tag."; 
    }

	public static void main(String[] args) {
        MietMaxGenerator generator = new MietMaxGenerator(new Wohnungsdatenbank());
        
        System.out.println("Willkommen bei MietMax!");
        System.out.println("Wo wollen sie eine Wohnung suchen?");
        Scanner scanner = new Scanner(System.in);
        String ort = scanner.nextLine();
        System.out.println("Wieviele Zimmer soll die Wohnung mindestens haben?");
        int zimmer = scanner.nextInt();
        
        List<String> anzeigen = generator.generiereAnzeigen(ort,zimmer);
        for (String anzeige : anzeigen) 
            System.out.println(anzeige);
        scanner.close();
    }
}