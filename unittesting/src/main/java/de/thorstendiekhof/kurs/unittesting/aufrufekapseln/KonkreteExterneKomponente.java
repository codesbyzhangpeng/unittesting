package de.thorstendiekhof.kurs.unittesting.aufrufekapseln;

public class KonkreteExterneKomponente implements ExterneKomponente {

	@Override
	public void aufrufen(String text) {
		System.out.println(text);
	}

    
}