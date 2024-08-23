package test;

import fr.pompey.dev.afpa.classes.Bibliothecaire;
import fr.pompey.dev.afpa.classes.Personne;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliothecaireTest extends PersonneTest {

    private static Bibliothecaire bibliothecairePourTest;
    @BeforeEach
    void setUp() {
        bibliothecairePourTest = new Bibliothecaire("Fujimi","Aika","jemlépoiçon");
    }

    @AfterEach
    void tearDown() {
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