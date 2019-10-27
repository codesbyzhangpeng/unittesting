package de.thorstendiekhof.kurs.unittesting.junit;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// @DisplayName("Hier kann man die Test-Klasse sauber beschreiben.")
public class AnnotationenTest {

    @Test
    // @DisplayName("Hier kann man eine Testmethode sauber beschreiben.")
    public void test(){
        assertTrue(true);
    }

    // @BeforeEach
    @Before
    public void beforeEach(){
        System.out.println("Dies wird je einmal vor jedem Test ausgeführt.");
    }
 
    // @BeforeAll
    @BeforeClass
    public static void beforeAll(){
        System.out.println("Dies wird nur ein einziges Mal vor allen Tests der Klasse ausgeführt.");
    }

    // @AfterEach
    @After
    public void afterEach(){
        System.out.println("Dies wird je einmal nach jedem Test ausgeführt.");
    }

    // @AfterAll
    @AfterClass
    public static void afterAll(){
        System.out.println("Dies wird nur ein einziges Mal nach allen Tests der Klasse ausgeführt.");
    }

}