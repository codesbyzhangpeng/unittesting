package de.thorstendiekhof.kurs.unittesting.dreitestarten;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WertZurueckTest {

    @Test
    public void ersetzeLeerzeichenDurchKomma(){
        TextWerkzeugkasten textWerkzeugkasten = new TextWerkzeugkasten();
        String text = "Ein wahrhaft großer Mann wird weder einen Wurm zertreten noch vor dem Kaiser kriechen.";
        String erwartetesErgebnis = "Ein_wahrhaft_großer_Mann_wird_weder_einen_Wurm_zertreten_noch_vor_dem_Kaiser_kriechen.";

        String ergebnis = textWerkzeugkasten.ersetzeLeerzeichen(text, "_");

        assertEquals(erwartetesErgebnis, ergebnis);
    }
    
}