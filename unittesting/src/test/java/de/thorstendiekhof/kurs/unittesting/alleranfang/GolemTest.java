package de.thorstendiekhof.kurs.unittesting.alleranfang;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class GolemTest {

	private static final String ES_PASSIERT_NICHTS = "Es passiert Nichts.";
	private static final String LOSUNGSWORT = "LOSUNGSWORT";
    private static final String FALSCHES_LOSUNGSWORT = "FALSCH";


	@Test
    public void losungswortFalsch_tutNichts(){
        Golem golem = neuerGolemMitLosungswort();

        String aktion = golem.bewegeDich(FALSCHES_LOSUNGSWORT, 3, Richtung.NORDEN);

        assertEquals(Golem.NICHTS_PASSIERT, aktion);
    }

    private Golem neuerGolemMitLosungswort(){
		Golem golem = new Golem(LOSUNGSWORT);
		return golem;
	}

    @Test
    public void losungswortRichtig_bewegtSich(){
        Golem golem = neuerGolemMitLosungswort();

        String aktion = golem.bewegeDich(LOSUNGSWORT, 2, Richtung.SUEDEN);

        assertEquals("Der Golem bewegt sich 2 Schritte nach SUEDEN", aktion);
    }

    @Test
    public void bewegen1Meter_bewegtSich1Meter(){
        Golem golem = neuerGolemMitLosungswort();

        String aktion = golem.bewegeDich(LOSUNGSWORT, 1, Richtung.NORDWESTEN);

        assertEquals("Der Golem bewegt sich 1 Schritte nach NORDWESTEN", aktion); 
    }

    @Test
    public void bewegen0Meter_tutNichts(){
        Golem golem = neuerGolemMitLosungswort();

        String aktion = golem.bewegeDich(LOSUNGSWORT, 0, Richtung.WESTEN);

        assertEquals(ES_PASSIERT_NICHTS, aktion);
    }

    @Test
    public void bewegenMinus1Meter_tutNichts(){
        Golem golem = neuerGolemMitLosungswort();

        String aktion = golem.bewegeDich(LOSUNGSWORT, -1, Richtung.WESTEN);

        assertEquals(ES_PASSIERT_NICHTS, aktion);
    }

    @Test
    public void bewegen1000Meter_bewegtSich1000Meter(){
        Golem golem = neuerGolemMitLosungswort();
    
        String aktion = golem.bewegeDich(LOSUNGSWORT, 1000, Richtung.NORDWESTEN);

        assertEquals("Der Golem bewegt sich 1000 Schritte nach NORDWESTEN", aktion); 
    }

    @Test
    public void losungswortFuerSiegelFalsch_tutNichts(){
        Golem golem = neuerGolemMitLosungswort();
        Siegel siegel = mock(Siegel.class);

        String aktion = golem.siegelEinsetzen(FALSCHES_LOSUNGSWORT, siegel);

        assertEquals(ES_PASSIERT_NICHTS, aktion);
    }

    @Test
    public void losungswortFuerSiegelRichtig_golemGlimmt(){
        Golem golem = neuerGolemMitLosungswort();
        Siegel siegel = mock(Siegel.class);

        String aktion = golem.siegelEinsetzen(LOSUNGSWORT, siegel);

        assertEquals("Das Siegel beginnt zu glimmen. Die Augen des " +
                    "Golems öffnen sich.", aktion);
    }

    @Test
    public void nullSiegeleinsetzen_golemGlimmt(){
        Golem golem = neuerGolemMitLosungswort();
        Siegel siegel = null;

        String aktion = golem.siegelEinsetzen(LOSUNGSWORT, siegel);

        assertEquals("Das Siegel beginnt zu glimmen. Die Augen des " +
                    "Golems öffnen sich.", aktion);
    }

    @Test
    public void starteMissionFalschesLosungswort_tutNichts(){
        Golem golem = neuerGolemMitLosungswort();
        golemBekommtSiegel(golem);

        String aktion = golem.starteMission(FALSCHES_LOSUNGSWORT);

        assertEquals(ES_PASSIERT_NICHTS, aktion);
    }

	private Siegel golemBekommtSiegel(Golem golem) {
		Siegel siegel = mock(Siegel.class);
        golem.siegelEinsetzen(LOSUNGSWORT, siegel);
        return siegel;
	}

    @Test
    public void starteMissionEnergieDa_missionWirdGestartet(){
        Golem golem = neuerGolemMitLosungswort();
        Siegel siegel = golemBekommtSiegel(golem);
        when(siegel.hatEnergie()).thenReturn(true);

        String aktion = golem.starteMission(LOSUNGSWORT);

        assertEquals("Der Golem startet seine Mission." 
        +" Er verschwindet in den Gassen der Stadt.", aktion);
    }

    @Test
    public void starteMissionEnergieDa_siegelWirdNachEnergieGefragt(){
        Golem golem = neuerGolemMitLosungswort();
        Siegel siegel = golemBekommtSiegel(golem);

        golem.starteMission(LOSUNGSWORT);

        verify(siegel).hatEnergie();
    }

}