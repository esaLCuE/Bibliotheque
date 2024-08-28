package test;

import fr.pompey.dev.afpa.classes.Abonne;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbonneTest {

    private static Abonne abonnePourTest;
    static List<String> testAbonnes = new ArrayList<>();
    static List<String> testEmails = new ArrayList<>();
    static List<LocalDate> testInscriptions = new ArrayList<>();

    @BeforeEach
    void setUp() {
        abonnePourTest = new Abonne("Nom","Prenom", "adressemail@jsp.com", LocalDate.of(2018,12,6));
        testAbonnes.add(abonnePourTest.getPrenom()+" "+abonnePourTest.getNom());
        testEmails.add(abonnePourTest.getEmail());
        testInscriptions.add(abonnePourTest.getInscription());
    }

    @AfterAll
    static void tearDown() {
        abonnePourTest = null;
    }

    @Test
    void setEmail() {
        String testEmail = abonnePourTest.getEmail();
        assertTrue(testEmail.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"));
        assertFalse(testEmail.isEmpty() || testEmail.matches("\\s+"));
        assertFalse(testEmail==null);
    }

    @Test
    void setInscription() {
        LocalDate testInscription = abonnePourTest.getInscription();
        assertTrue(testInscription.getYear()>0);
        assertTrue(testInscription.getMonthValue()>0 && testInscription.getMonthValue()<=12);
        assertTrue(testInscription.getDayOfMonth()>0);
        int nbJmax;
        if (testInscription.getMonthValue()==2) {
            if (testInscription.getYear()%4==0 && testInscription.getYear()%100==0 && testInscription.getYear()%400!=0) {
                nbJmax = 29;
            } else {
                nbJmax = 28;
            }
        } else if (testInscription.getMonthValue()==4 || testInscription.getMonthValue()==6 ||
                testInscription.getMonthValue()==9 || testInscription.getMonthValue()==11) {
            nbJmax = 30;
        } else {
            nbJmax = 31;
        }
        assertTrue(testInscription.getDayOfMonth()<=nbJmax);
    }
}