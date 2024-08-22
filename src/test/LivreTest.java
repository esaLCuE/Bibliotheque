package test;

import fr.pompey.dev.afpa.classes.Livre;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivreTest {

    private Livre livrePourTest;

    @BeforeEach
    void setUp() {
        try {
            livrePourTest = new Livre("testTit","testAut",5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void tearDown() {
        livrePourTest = null;
    }

    @Test
    void setTestTitre() {
    }

    @Test
    void setAuteur() {
    }

    @Test
    void setQuantite() {
    }
}