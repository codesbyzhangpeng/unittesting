package de.thorstendiekhof.kurs.unittesting.dreitestarten;


import static org.mockito.Mockito.*;

import org.junit.Test;

public class AufrufFremdsystemTest {

    @Test
    public void leuchtendesLichtWirdAusgeschaltet(){
        Licht testLicht = mock(Licht.class);
        when(testLicht.isAn()).thenReturn(true);
        Schalter schalter = new Schalter(testLicht);
        
        schalter.schalteLicht();

        verify(testLicht).schalteAus();
    }
    
}