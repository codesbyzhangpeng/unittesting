package de.thorstendiekhof.kurs.unittesting.uebungen.langekerls;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LoesungRekrutTest {

    @Test
    public void ueber175_istGross(){
        Rekrut rekrut = new Rekrut(180, 80);
        
        assertTrue(rekrut.isGross());
    }

    @Test
    public void genau175_istNichtGross(){
        Rekrut rekrut = new Rekrut(175, 80);
        
        assertFalse(rekrut.isGross());
    }

    @Test
    public void ueber185_istSehrGross(){
        Rekrut rekrut = new Rekrut(190, 80);
        
        assertTrue(rekrut.isSehrGross());
    }

    @Test
    public void unter185_istNichtSehrGross(){
        Rekrut rekrut = new Rekrut(180, 80);
        
        assertFalse(rekrut.isSehrGross());
    }

    @Test
    public void ueber185_istAuchGross(){
        Rekrut rekrut = new Rekrut(190, 80);
        
        assertTrue(rekrut.isGross());
    }
    
    @Test
    public void unter160_istKlein(){
        Rekrut rekrut = new Rekrut(155, 80);
        
        assertTrue(rekrut.isKlein());
    }

    @Test
    public void ueber160_istNichtKlein(){
        Rekrut rekrut = new Rekrut(165, 80);
        
        assertFalse(rekrut.isKlein());
    }


    // BMI > 25 ist dick
    @Test
    public void groesse160gewicht90_istDick(){
        // BMI = 35,16
        Rekrut rekrut = new Rekrut(160, 90);

        assertTrue(rekrut.isDick());
    }

    @Test
    public void groesse160gewicht64_istNichtDick(){
        // BMI = 25
        Rekrut rekrut = new Rekrut(160, 64);
    
        assertFalse(rekrut.isDick());
    }

    @Test
    public void groesse195gewicht90_istNichtDick(){
        // BMI = 23,7
        Rekrut rekrut = new Rekrut(195, 90);

        assertFalse(rekrut.isDick());
    }

}