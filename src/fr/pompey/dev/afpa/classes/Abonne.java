package fr.pompey.dev.afpa.classes;

import java.util.*;
import java.time.*;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Abonne extends Personne {
    private String email;
    private LocalDate inscription;
    Scanner sc = new Scanner(System.in);

    public void setEmail(String email){
    /*  while (email==null || email.isEmpty() ||
                !email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            afficher("Entrez l'email de l'abonné.");
            email = Saisie.getString();
        }
     */
        if (email == null) {
            throw new NullPointerException("Erreur Systeme : valeur nulle");
        }

        if (email.isEmpty() || email.matches("\\s+")) {
            throw new InputMismatchException("Merci de saisir un email non vide");
        }

        if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            throw new InputMismatchException("Merci de saisir un email valide");
        }
        try {
            this.email=email;
        } catch (Exception e) {
            afficher(e.getMessage());
        }
    }

    public String getEmail(){
        return this.email;
    }


    public void setInscription(LocalDate inscription){
    /*    inscription = LocalDate.of(-1,1,1);
        while (inscription.getYear()<1) {
            inscription = Saisie.getDate("l'inscription");
        }
     */
        try {
            this.inscription = inscription;
        } catch (Exception e) {
            afficher(e.getMessage());
        }
    }

    public LocalDate getInscription(){
        return this.inscription;
    }

    static List<String> abonnes = new ArrayList<>();
    static List<String> emails = new ArrayList<>();
    static List<LocalDate> inscriptions = new ArrayList<>();

    public Abonne(String nom, String prenom, String email, LocalDate inscription)
            throws  NullPointerException, IllegalArgumentException {
        super(nom, prenom);
        setEmail(email);
        setInscription(inscription);
        abonnes.add(getPrenom()+" "+getNom());
        emails.add(getEmail());
        inscriptions.add(getInscription());
    }

    public static void afficherAbonnes(){
        for (String abonne : abonnes) {
            afficher(abonne);
        }
    }
}
