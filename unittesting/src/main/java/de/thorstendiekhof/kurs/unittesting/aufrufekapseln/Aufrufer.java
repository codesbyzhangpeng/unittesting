package de.thorstendiekhof.kurs.unittesting.aufrufekapseln;

public class Aufrufer {

    private ExterneKomponente externeKomponente;

	public Aufrufer(ExterneKomponente externeKomponente){
        this.externeKomponente = externeKomponente;
    }

    public void aktion(String text){
        this.externeKomponente.aufrufen(text);
    }
    
}