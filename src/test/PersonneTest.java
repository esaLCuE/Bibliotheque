package test;

import fr.pompey.dev.afpa.classes.Personne;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    private static Personne personnePourTest;

    @BeforeEach
    void setUp() {
        personnePourTest = new Personne("Nomtest", "Prenomtest");
    }

    @AfterAll
    static void tearDown() {
        personnePourTest = null;
    }

    @Test
    void setNom() {
        String testNom = personnePourTest.getNom();
        assertTrue(testNom.matches("^[a-zA-Z\\s-]*$"));
        assertFalse(testNom.isEmpty() || testNom.matches("\\s+"));
        assertFalse(testNom ==null);
    }

    @Test
    void setPrenom() {
        String testPrenom = personnePourTest.getPrenom();
        assertTrue(testPrenom.matches("^[a-zA-Z\\s-]*$"));
        assertFalse(testPrenom.isEmpty() || testPrenom.matches("\\s+"));
        assertFalse(testPrenom == null);
    }
}