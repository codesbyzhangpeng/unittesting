package de.thorstendiekhof.kurs.unittesting.nureinaspekt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NurEinAspektTest {

    @Test
    public void zuWenigGeldGibtKeineFahrkarte(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(100);

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertFalse(verhalten.contains("Eine Fahrkarte wird ausgeworfen."));
    }

    @Test
    public void zuWenigGeldZeigtFahrpreis(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(100);

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertTrue(verhalten.contains("Eine Fahrkarte kostet " + Fahrkartenautomat.KOSTEN_FAHRKARTE + " Cent\""));
    }

    @Test
    public void genugGeldGibtFahrkarte(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(300);

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertTrue(verhalten.contains("Eine Fahrkarte wird ausgeworfen."));
    }

    @Test
    public void zuvielGeldGibtRueckgeld(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(300);

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertTrue(verhalten.contains("Es werden 20 Cent ausgeworfen."));
    }

    @Test
    public void nachDemKaufIstKeinGuthabenMehrVorhanden(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(300);

        fahrkartenautomat.kaufeFahrkarte();

        String verhalten = fahrkartenautomat.schaueAufGuthaben();
        assertTrue(verhalten.contains("0 Cent"));
    }
}