package de.thorstendiekhof.kurs.unittesting.wastesten;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WasTestenTest {

    /**
    * Typische Wert testen
    */
    @Test
    public void typischeEinheit(){
        Einheit ritter = Einheit.buildRitter();

        String ergebnis = EinheitenFormatter.format(ritter);

        assertEquals("Ritter, Ein Krieger in Rüstung auf einem Pferd. Er trägt Lanze, Schild und Schwert.\nA5 / B5\nOOOOOOOOOO", ergebnis);
    }
    
    @Test
    public void typischeVerletzteEinheit(){
        Einheit ritter = Einheit.buildRitter();
        ritter.leben = 3;

        String ergebnis = EinheitenFormatter.format(ritter);

        assertEquals("Ritter, Ein Krieger in Rüstung auf einem Pferd. Er trägt Lanze, Schild und Schwert.\nA5 / B5\nOOO-------", ergebnis);
    }

    /**
    * Grenzfälle testen
    */
    @Test
    public void einenSchaden(){
        Einheit ritter = Einheit.buildRitter();
        ritter.leben = 9;

        String ergebnis = EinheitenFormatter.format(ritter);

        assertEquals("Ritter, Ein Krieger in Rüstung auf einem Pferd. Er trägt Lanze, Schild und Schwert.\nA5 / B5\nOOOOOOOOO-", ergebnis);
    }

    @Test
    public void nurNochEinLeben(){
        Einheit ritter = Einheit.buildRitter();
        ritter.leben = 1;

        String ergebnis = EinheitenFormatter.format(ritter);

        assertEquals("Ritter, Ein Krieger in Rüstung auf einem Pferd. Er trägt Lanze, Schild und Schwert.\nA5 / B5\nO---------", ergebnis);
    }

    @Test
    public void keinLebenMehr(){
        Einheit ritter = Einheit.buildRitter();
        ritter.leben = 0;

        String ergebnis = EinheitenFormatter.format(ritter);

        assertEquals("Ritter, Ein Krieger in Rüstung auf einem Pferd. Er trägt Lanze, Schild und Schwert.\nA5 / B5\n----------", ergebnis);
    }

    /**
    * Falsche Eingabewerte testen
    */
    @Test
    
    public void negativesLeben(){
        Einheit ritter = Einheit.buildRitter();
        ritter.leben = -1;

        String ergebnis = EinheitenFormatter.format(ritter);

        assertEquals("Ritter, Ein Krieger in Rüstung auf einem Pferd. Er trägt Lanze, Schild und Schwert.\nA5 / B5\n-----------", ergebnis);
    }

    /**
    * Null Werte testen
    */
    @Test
    public void beschreibungIstNull(){
        Einheit ritter = Einheit.buildRitter();
        ritter.beschreibung = null;

        String ergebnis = EinheitenFormatter.format(ritter);

        assertEquals("Ritter, null\nA5 / B5\nOOOOOOOOOO", ergebnis);
    }
}