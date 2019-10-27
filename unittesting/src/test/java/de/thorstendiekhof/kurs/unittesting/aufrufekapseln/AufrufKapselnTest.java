package de.thorstendiekhof.kurs.unittesting.aufrufekapseln;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AufrufKapselnTest {

    @Test
    public void mockKomponente(){
        MockKomponente mockKomponente = new MockKomponente();
        Aufrufer aufrufer = new Aufrufer(mockKomponente);

        aufrufer.aktion("Hallo Welt");

        assertEquals("Hallo Welt", mockKomponente.ergebnis);
    }

    private class MockKomponente implements ExterneKomponente {
        String ergebnis = "";
		@Override
		public void aufrufen(String text) {
			ergebnis = text;
		}

    }

}