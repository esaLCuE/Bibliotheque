package test;

import fr.pompey.dev.afpa.classes.Abonne;
import fr.pompey.dev.afpa.classes.Pret;
import fr.pompey.dev.afpa.classes.Livre;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static test.AbonneTest.testAbonnes;
import static test.LivreTest.testTitres;

class PretTest {

    private static Pret testPourPret;

    @BeforeAll
    static void setUp() {
        testPourPret = new Pret("Prénom Nom", "TitreLivre", "Auteur Livre", LocalDate.of(2020,2,20),
                LocalDate.of(2024,2,20));
    }

    @AfterAll
    static void tearDown() {
        testPourPret = null;
    }

    @Test
    void setAboPret() {
        String testNomAboPret = testPourPret.getNomAboPret();
        assert(testAbonnes.contains(testNomAboPret));
    }

    @Test
    void setLivrePret() {
        String testNomLivrePret = testPourPret.getNomLivrePret();
        assert(testTitres.contains(testNomLivrePret));
        int i;
        for (i = 0; i < testTitres.size(); i++) {
            if (testNomLivrePret.equalsIgnoreCase(testTitres.get(i))) {
                if (!(LivreTest.testQuantites.get(i) > 0)) {
                    throw new IllegalArgumentException("Ce titre n'est pas disponible actuellement.");
                } else {
                    int idLivre = i;
                    break;
                }
            }
        }
        assertTrue(LivreTest.testQuantites.get(i)>0);
    }

    @Test
    void setDebut() {
    }

    @Test
    void setFin() {
    }
}