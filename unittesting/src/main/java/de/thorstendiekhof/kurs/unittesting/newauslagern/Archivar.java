package de.thorstendiekhof.kurs.unittesting.newauslagern;

public class Archivar {

    Datenbank datenbank;
    Schredder schredder;

    public Archivar(){
        this.datenbank = new Datenbank();
        this.schredder = new Schredder();
    }

    public String bewerteDaten(String daten){
        if(sindWichtig(daten))
            return "Wichtig: " + archiviereDaten(daten);
        else
            return "Unwichtig: " + schredderDaten(daten);
    }

	private String schredderDaten(String daten) {
        schredder.schredder(daten);
        return "Daten wurden geschreddert.";
	}

	private String archiviereDaten(String daten) {
        String id = datenbank.save(daten);
        return "Daten unter der ID \"" + id + "\" archiviert.";
	}

	private boolean sindWichtig(String daten) {
		return daten.contains("$") || daten.contains("€") || daten.contains("Doller") || daten.contains("Euro");
	}
    
}