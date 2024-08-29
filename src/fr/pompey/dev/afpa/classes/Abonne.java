package fr.pompey.dev.afpa.classes;

import java.util.*;
import java.time.*;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Abonne extends Personne {
    private String email;
    LocalDate inscription;
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

    public static List<Abonne> abonnes = new ArrayList<>();

    public Abonne(String nom, String prenom, String email, LocalDate inscription)
            throws  NullPointerException, IllegalArgumentException {
        super(nom, prenom);
        setEmail(email);
        setInscription(inscription);
        abonnes.add(new Abonne(nom, prenom, email, inscription));
    }

    public static void afficherAbonnes(){
        for (int i = 0; i < abonnes.size(); i++) {
            afficher(abonnes.get(i).toString());
        }
    }
}
