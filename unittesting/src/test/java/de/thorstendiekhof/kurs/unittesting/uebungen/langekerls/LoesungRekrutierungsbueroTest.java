package de.thorstendiekhof.kurs.unittesting.uebungen.langekerls;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class LoesungRekrutierungsbueroTest {


    @Test
    public void adelig_wirdOffizier(){
        Rekrut rekrut = new Rekrut(178, 80).istAdelig();
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.OFFIZIER, truppe);
    }

    @Test
    public void dickerAdeliger_wirdOffizier(){
        Rekrut rekrut = new Rekrut(178, 180).istAdelig();
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.OFFIZIER, truppe);
    }

    @Test
    public void sehrGroess_wirdLangerKerl(){
        Rekrut rekrut = new Rekrut(198, 80);
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.LANGE_KERLS, truppe);
    }

    @Test
    public void klugerKleinerKerl_kommtZurArtillerie(){
        Rekrut rekrut = new Rekrut(140, 83).mitSchulabschluss();
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.ARTILLERIE, truppe);
    }

    @Test
    public void klugerNormalgrosserKerlOhneSeekrankheit_kommtZurMarine(){
        Rekrut rekrut = new Rekrut(175, 78).mitSchulabschluss();
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.MARINE, truppe);
    }

    
    @Test
    public void klugerNormalgrosserKerlMitSeekrankheit_kommtNichtZurMarine(){
        Rekrut rekrut = new Rekrut(175, 79).mitSchulabschluss().wirdSeekrank();
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertNotEquals(TruppenGattung.MARINE, truppe);
    }

    @Test
    public void dickerOhneMerkmale_kommtZurVersorgung(){
        Rekrut rekrut = new Rekrut(174, 92);
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.VERSORGUNG, truppe);
    }
    
    @Test
    public void grosserNormaler_kommtZurGarde(){
        Rekrut rekrut = new Rekrut(185, 81);
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.GARDE, truppe);
    }

    @Test
    public void normaler_kommtZurInfanterie(){
        Rekrut rekrut = new Rekrut(173, 72);
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.INFANTERIE, truppe);
    }

    @Test
    public void normalerAusStadt_kommtZurReitertruppe(){
        Rekrut rekrut = new Rekrut(173, 70).istStadtbewohner();
        Rekrutierungsbuero buero = new Rekrutierungsbuero();

        TruppenGattung truppe = buero.muster(rekrut);

        assertEquals(TruppenGattung.REITERTRUPPE, truppe);
    }
    
}