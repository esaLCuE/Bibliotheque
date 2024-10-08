package test;

import fr.pompey.dev.afpa.classes.Livre;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;
import static org.junit.jupiter.api.Assertions.*;

class LivreTest {

    private static Livre livrePourTest;

    static List<String> testTitres = new ArrayList<>();
    static List<String> testAuteurs = new ArrayList<>();
    static List<Integer> testQuantites = new ArrayList<>();

    @BeforeEach
    void setUp() {
        try {
            livrePourTest = new Livre("testTit", "testAut", 5);
            testTitres.add(livrePourTest.getTitre());
            testAuteurs.add(livrePourTest.getAuteur());
            testQuantites.add(livrePourTest.getQuantite());
        } catch (Exception e) {
            afficher(e.getMessage());
        }
    }


    @AfterAll
    static void tearDown() {
        livrePourTest = null;
    }

    @Test
    void setTestTitre() {
        String testTitre = livrePourTest.getTitre();
        assertTrue(testTitre.matches("^[A-Za-z0-9\\s\\-_,.;:()]+$"));
        assertFalse(testTitre.isEmpty() || testTitre.matches("\\s+"));
        assertFalse(testTitre==null);
    }

    @Test
    void setTestAuteur() {
        String testAuteur = livrePourTest.getAuteur();
        assertTrue(testAuteur.matches("^[a-zA-Z\\s-]*$"));
        assertFalse(testAuteur.isEmpty() || testAuteur.matches("\\s+"));
        assertFalse(testAuteur==null);
    }

    @Test
    void setTestQuantite() {
        try {
            int testQuantite = livrePourTest.getQuantite();
            assertTrue(testQuantite >= 0);
        } catch (Exception e) {
            afficher(e.getMessage());
        }
    }
}
