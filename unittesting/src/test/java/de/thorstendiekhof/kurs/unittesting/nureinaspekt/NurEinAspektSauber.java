package de.thorstendiekhof.kurs.unittesting.nureinaspekt;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NurEinAspektSauber {

    @Test
    public void zuWenigGeldGibtKeineFahrkarte(){
        Fahrkartenautomat fahrkartenautomat = buildAutomatMitZuWenigGeld();

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertFalse(verhalten.contains("Eine Fahrkarte wird ausgeworfen."));
    }

    @Test
    public void zuWenigGeldGibtZeigtFahrpreis(){
        Fahrkartenautomat fahrkartenautomat = buildAutomatMitZuWenigGeld();

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertTrue(verhalten.contains("Eine Fahrkarte kostet " + Fahrkartenautomat.KOSTEN_FAHRKARTE + " Cent\""));
    }

    @Test
    public void genugGeldGibtFahrkarte(){
        Fahrkartenautomat fahrkartenautomat = buildAutomatMitPassendemGeld();

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertTrue(verhalten.contains("Eine Fahrkarte wird ausgeworfen."));
    }

    @Test
    public void zuvielGeldGibtRueckgeld(){
        Fahrkartenautomat fahrkartenautomat = buildAutomatMitZuvielGeld(20);

        String verhalten = fahrkartenautomat.kaufeFahrkarte();

        assertTrue(verhalten.contains("Es werden 20 Cent ausgeworfen."));
    }

    @Test
    public void nachDemKaufIstKeinGuthabenMehrVorhanden(){
        Fahrkartenautomat fahrkartenautomat = buildAutomatMitZuvielGeld(20);

        fahrkartenautomat.kaufeFahrkarte();

        String verhalten = fahrkartenautomat.schaueAufGuthaben();
        assertTrue(verhalten.contains("0 Cent"));
    }


    private Fahrkartenautomat buildAutomatMitZuWenigGeld(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(Fahrkartenautomat.KOSTEN_FAHRKARTE / 2);
        return fahrkartenautomat;
    }

    private Fahrkartenautomat buildAutomatMitPassendemGeld(){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(Fahrkartenautomat.KOSTEN_FAHRKARTE);
        return fahrkartenautomat;
    }

    
    private Fahrkartenautomat buildAutomatMitZuvielGeld(int zuviel){
        Fahrkartenautomat fahrkartenautomat = new Fahrkartenautomat();
        fahrkartenautomat.geldEinwerfen(Fahrkartenautomat.KOSTEN_FAHRKARTE + zuviel);
        return fahrkartenautomat;
    }
}