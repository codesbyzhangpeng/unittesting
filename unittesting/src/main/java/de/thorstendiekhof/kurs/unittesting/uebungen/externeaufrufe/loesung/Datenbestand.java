package de.thorstendiekhof.kurs.unittesting.uebungen.externeaufrufe.loesung;

import java.util.List;

public interface Datenbestand {

	List<Wohnung> searchWohnungen(String ort, int zimmer);

    
}