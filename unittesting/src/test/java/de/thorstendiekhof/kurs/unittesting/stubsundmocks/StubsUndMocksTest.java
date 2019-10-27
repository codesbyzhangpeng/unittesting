package de.thorstendiekhof.kurs.unittesting.stubsundmocks;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;


public class StubsUndMocksTest {

    @Test
    public void stubUnwichtigeDatenAusgabeSchreddern(){
        Datenbank datenbank = mock(Datenbank.class);
        Schredder schredder = mock(Schredder.class);
        Archivar archivar = new Archivar(datenbank, schredder);

        String verhalten = archivar.bewerteDaten("Alles wird besser durch Entspannung!");

        assertEquals("Unwichtig: Daten wurden geschreddert.", verhalten);
    }

    @Test
    public void stubWichtigeDatenAusgabeArchivMitID(){
        Datenbank datenbank = mock(Datenbank.class);
        when(datenbank.save(anyString())).thenReturn("dummyID");
        Schredder schredder = mock(Schredder.class);
        Archivar archivar = new Archivar(datenbank, schredder);

        String verhalten = archivar.bewerteDaten("Alles wird besser durch harte Euro!");

        assertEquals("Wichtig: Daten unter der ID \"dummyID\" archiviert.", verhalten);
    }
 
    @Test
    public void mockUnwichtigeDatenGelangenZumSchredder(){
        Datenbank datenbank = mock(Datenbank.class);
        Schredder schredder = mock(Schredder.class);
        Archivar archivar = new Archivar(datenbank, schredder);
        String unwichtigeDaten = "Alles wird besser durch Entspannung!";

        archivar.bewerteDaten(unwichtigeDaten);

        verify(schredder).schredder(unwichtigeDaten);
    }

    @Test
    public void mockWichtigeDatenGelangenZurDatenbank(){
        Datenbank datenbank = mock(Datenbank.class);
        Schredder schredder = mock(Schredder.class);
        Archivar archivar = new Archivar(datenbank, schredder);
        String wichtigeDaten = "Alles wird besser durch harte Euro!";

        archivar.bewerteDaten(wichtigeDaten);

        verify(datenbank).save(wichtigeDaten);
    }

}