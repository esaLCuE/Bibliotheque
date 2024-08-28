package test;

import fr.pompey.dev.afpa.classes.Bibliothecaire;
import fr.pompey.dev.afpa.classes.Personne;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BibliothecaireTest {

    private static Bibliothecaire bibliothecairePourTest;
    @BeforeEach
    void setUp() {
        bibliothecairePourTest = new Bibliothecaire("Nombiblio","Prenombiblio","identifiantbiblio");
    }

    @AfterAll
    static void tearDown() {
        bibliothecairePourTest = null;
    }

    @Test
    void setIdentifiant() {
        String testIdentifiant = bibliothecairePourTest.getIdentifiant();
        assertTrue(testIdentifiant.length() >= 5);
        assertFalse(testIdentifiant == null);
        assertFalse(testIdentifiant.isEmpty() || testIdentifiant.matches("\\s+"));
    }
}