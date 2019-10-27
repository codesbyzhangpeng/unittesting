package de.thorstendiekhof.kurs.unittesting.newauslagern;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.lang.reflect.Field;

import org.junit.Test;

public class NewsAuslagernTest {

    @Test
    public void unwichtigeDatenAusgabeSchreddern() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Datenbank datenbank = mock(Datenbank.class);
        Schredder schredder = mock(Schredder.class);
        Archivar archivar = new Archivar();

        Class<?> a = archivar.getClass();
        Field fieldDB = a.getDeclaredField("datenbank");
        fieldDB.set(archivar, datenbank);

        Field fieldSchredder = a.getDeclaredField("schredder");
        fieldSchredder.set(archivar, schredder);

        String verhalten = archivar.bewerteDaten("Alles wird besser durch Entspannung!");

        assertEquals("Unwichtig: Daten wurden geschreddert.", verhalten);
    }

    @Test
    public void unwichtigeDatenAusgabeSchreddern2(){
        NeuerArchivar archivar = new NeuerArchivar(){
            protected Datenbank newDatenbank(){
                return  mock(Datenbank.class);
            }
            protected Schredder newSchredder(){
                return mock(Schredder.class);
            }
        };

        String verhalten = archivar.bewerteDaten("Alles wird besser durch Entspannung!");

        assertEquals("Unwichtig: Daten wurden geschreddert.", verhalten);
    }
    
}