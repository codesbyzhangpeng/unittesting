package de.thorstendiekhof.kurs.unittesting.erstertest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RechnerTest {

    @Test
    public void addierenVon5Und12Ist17()
    {
        Rechner rechner = new Rechner();

        int ergebnis = rechner.addiere(5, 12);
        
        assertEquals(17,ergebnis);
    }
    
}