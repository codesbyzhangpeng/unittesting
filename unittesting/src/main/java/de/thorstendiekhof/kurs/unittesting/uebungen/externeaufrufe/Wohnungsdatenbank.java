package de.thorstendiekhof.kurs.unittesting.uebungen.externeaufrufe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Dies ist ein Client der "Wohnen ohne Reue GmbH"-Wohnungsdatenbank.
 * Der Aufruf des Services wird hier nur simuliert.
 * 
 * Die Klasse soll aber eine enorm starke Abhängigkeit simulieren. Daher
 * der Aufbau - der jedesmal bei Erzeugung eines Objekts unterschiedlich
 * abläuft.
 */
public class Wohnungsdatenbank {

    private List<Wohnung> wohnungen = new ArrayList<Wohnung>();
    private String[] staedte = {"Berlin","München","Hamburg","Bremen","Köln", 
                        "Frankfurt am Main","Stuttgart", "Düsseldorf", 
                        "Dortmund", "Essen", "Leipzig", "Bielefeld"};

    private String[] beschreibungen = {"Super Lage","Altbau aber trotzdem gut.",
                        "WG-geeignet", "Fürs Alter ok", "Verkehrsgünstig gelegen"};

    public Wohnungsdatenbank(){
        Random random = new Random();
        int zufaelligeAnzahl = random.nextInt(200)+100;
        for (int i = 0; i < zufaelligeAnzahl; i++) {
            wohnungen.add(generiereZufallswohnung(random));
        }
    }

	public List<Wohnung> searchWohnungen(String city, int raeume){
        List<Wohnung> gefundeneWohnungen = new ArrayList<>();
        for (Wohnung wohnung : wohnungen) 
            if(wohnung.stadt.contains(city) && wohnung.raeume >= raeume)
                gefundeneWohnungen.add(wohnung);
        return gefundeneWohnungen;
    }

    private Wohnung generiereZufallswohnung(Random random) {
        Wohnung wohnung = new Wohnung();
        wohnung.raeume = random.nextInt(6);
        wohnung.stadt = staedte[random.nextInt(staedte.length)];
        wohnung.beschreibung = beschreibungen[random.nextInt(beschreibungen.length)];
        wohnung.miete = wohnung.raeume * (300 + random.nextInt(100));
		return wohnung;
	}
}