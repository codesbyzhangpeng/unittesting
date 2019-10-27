package de.thorstendiekhof.kurs.unittesting.nureinaspekt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MehrereAspekteTest {

    @Test
    public void zuWenigGeldGibtKeineFahrkarteUndZeigtPreisAn(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(100);

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertFalse(verhalten.contains("Eine Fahrkarte wird ausgeworfen."));
        assertTrue(verhalten.contains("Eine Fahrkarte kostet " + Fahrkartenautomat.KOSTEN_FAHRKARTE + " Cent\""));
    }


    @Test
    public void genugGeldGibtFahrkarteUndRueckgeldUndEsIstKeinGuthabenMehrVorhanden(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(300);

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertTrue(verhalten.contains("Eine Fahrkarte wird ausgeworfen."));
        assertTrue(verhalten.contains("Es werden 20 Cent ausgeworfen."));
        String weiteresVerhalten = fahrkartenautomat.schaueAufGuthaben();
        assertTrue(weiteresVerhalten.contains("0 Cent"));
    }

}