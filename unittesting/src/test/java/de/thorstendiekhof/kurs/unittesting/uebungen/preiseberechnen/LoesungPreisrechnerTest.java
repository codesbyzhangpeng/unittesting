package de.thorstendiekhof.kurs.unittesting.uebungen.preiseberechnen;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LoesungPreisrechnerTest {

    private static final int VERSANSKOSTENFREI_AB = 200;
    private static final int VERSANDKOSTEN = 100;

	@Test
    public void preisHoeherAlsVersandkostenfreiheit_IstVersandkostenfrei(){
        Preisrechner preisrechner = new Preisrechner(VERSANSKOSTENFREI_AB, VERSANDKOSTEN);
        Ware teureWare = new Ware(1,400);
        int erwarteterPreis = 400;
        
        int aktuellerPreis = preisrechner.berechnePreisInCent(teureWare);

        assertEquals(erwarteterPreis, aktuellerPreis);
    }

    @Test
    public void preisNiedrigerAlsVersandkostenfreiheit_VersandkostenWerdenBerechnet(){
        Preisrechner preisrechner = new Preisrechner(VERSANSKOSTENFREI_AB, VERSANDKOSTEN);
        Ware guenstigeWare = new Ware(1,100);
        int erwarteterPreis = 100 + VERSANDKOSTEN;
        
        int aktuellerPreis = preisrechner.berechnePreisInCent(guenstigeWare);

        assertEquals(erwarteterPreis, aktuellerPreis);
    }

    @Test
    public void preisGleichVersandkostenfreiheit_IstVersandkostenfrei(){
        Preisrechner preisrechner = new Preisrechner(VERSANSKOSTENFREI_AB, VERSANDKOSTEN);
        Ware ware = new Ware(1,VERSANSKOSTENFREI_AB);
        int erwarteterPreis = VERSANSKOSTENFREI_AB;
        
        int aktuellerPreis = preisrechner.berechnePreisInCent(ware);

        assertEquals(erwarteterPreis, aktuellerPreis);
    }

    @Test
    public void wareMehrfach_kostetMehrfach(){
        Preisrechner preisrechner = new Preisrechner(VERSANSKOSTENFREI_AB, VERSANDKOSTEN);
        Ware ware = new Ware(2,1);
        int erwarteterPreis = 2 + VERSANDKOSTEN;
        
        int aktuellerPreis = preisrechner.berechnePreisInCent(ware);

        assertEquals(erwarteterPreis, aktuellerPreis);
    }

    @Test
    public void mehrereWaren_addierenIhreKosten(){
        Preisrechner preisrechner = new Preisrechner(VERSANSKOSTENFREI_AB, VERSANDKOSTEN);
        Ware ware1 = new Ware(1,1);
        Ware ware2 = new Ware(1,1);
        int erwarteterPreis = 2 + VERSANDKOSTEN;
        
        int aktuellerPreis = preisrechner.berechnePreisInCent(ware1,ware2);

        assertEquals(erwarteterPreis, aktuellerPreis);
    }

    @Test
    public void mehrereWarenPreisUeberVersandkostenfrei_sindVersandkostenfrei(){
        Preisrechner preisrechner = new Preisrechner(VERSANSKOSTENFREI_AB, VERSANDKOSTEN);
        Ware ware1 = new Ware(1,50);
        Ware ware2 = new Ware(2,50);
        Ware ware3 = new Ware(2,50);
        int erwarteterPreis = 250;
        
        int aktuellerPreis = preisrechner.berechnePreisInCent(ware1,ware2,ware3);

        assertEquals(erwarteterPreis, aktuellerPreis);
    }

    @Test
    public void keineWaren_erzeugenKeineKosten(){
        Preisrechner preisrechner = new Preisrechner(VERSANSKOSTENFREI_AB, VERSANDKOSTEN);
        int erwarteterPreis = 0;

        int aktuellerPreis = preisrechner.berechnePreisInCent();

        assertEquals(erwarteterPreis, aktuellerPreis);
    }

    @Test
    public void normalerPreis_erzeugtSaubereAusgabe(){
        String ausgabe = Preisrechner.saubereAusgabe(250);

        assertEquals("2,50€", ausgabe);
    }

    @Test
    public void normalerPreisUnterEinemEuro_erzeugtSaubereAusgabe(){
        String ausgabe = Preisrechner.saubereAusgabe(50);

        assertEquals("0,50€", ausgabe);
    }

    @Test
    public void ganzeEuro_erzeugtSaubereAusgabeMitDoppelNullBeimCent(){
        String ausgabe = Preisrechner.saubereAusgabe(100);

        assertEquals("1,00€", ausgabe);
    }

    @Test
    public void hoherPreis_erzeugtSaubereAusgabe(){
        String ausgabe = Preisrechner.saubereAusgabe(55000000);

        assertEquals("550000,00€", ausgabe);
    }

    @Test
    public void preisDerNormalAufgerundetWird_erzeugtSaubereAusgabe(){
        String ausgabe = Preisrechner.saubereAusgabe(99);

        assertEquals("0,99€", ausgabe);
    }

    @Test
    public void preisDerNormalAbgerundetWird_erzeugtSaubereAusgabe(){
        String ausgabe = Preisrechner.saubereAusgabe(101);

        assertEquals("1,01€", ausgabe);
    }

    @Test
    public void negativerEuroPreis_erzeugtSaubereAusgabeMitMinus(){
        String ausgabe = Preisrechner.saubereAusgabe(-100);

        assertEquals("-1,00€", ausgabe);
    }

    @Test
    public void negativerCentPreis_erzeugtSaubereAusgabeMitMinus(){
        String ausgabe = Preisrechner.saubereAusgabe(-10);

        assertEquals("-0,10€", ausgabe);
    }
}