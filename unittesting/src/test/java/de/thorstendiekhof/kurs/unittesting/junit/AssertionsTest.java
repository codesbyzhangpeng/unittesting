package de.thorstendiekhof.kurs.unittesting.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class AssertionsTest {

    @Test
    @Ignore
    // @Disabled
    public void wichtigeAssertions(){

        assertTrue(true);
        assertFalse(false);
        
        String expected = "Wert";
        String actual = "Wert";
        assertEquals(expected, actual);

        String[] expectedArray = {"eins","zwei"};
        String[] actualArray = {"eins","zwei"};
        assertArrayEquals(expectedArray, actualArray);

    }

    @Test(expected=IllegalArgumentException.class)
    public void exeption(){
        /*
            val exception = assertThrows<IllegalArgumentException> ("Should throw an exception") {
                throw IllegalArgumentException("a message")
            }
            assertEquals("a message", exception.message)
        */

        throw new IllegalArgumentException();
    }
    
}