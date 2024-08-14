package fr.pompey.dev.afpa.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.time.*;
import java.util.List;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Abonne extends Personne {
    private String email;
    private LocalDate inscription;
    Scanner sc = new Scanner(System.in);

    public void setEmail(){
        this.email = "";
        while (this.email==null || this.email.isEmpty() ||
                !this.email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            afficher("Entrez l'email de l'abonné.");
            this.email = Saisie.getString();
        }
    }

    public String getEmail(){
        return this.email;
    }


    public void setInscription(){
        this.inscription = Saisie.getDate("l'inscription");
    }

    public LocalDate getInscription(){
        return this.inscription;
    }

    static List<String> abonnes = new ArrayList<>();
    static List<String> emails = new ArrayList<>();
    static List<LocalDate> inscriptions = new ArrayList<>();

    public Abonne(){
        super();
        setEmail();
        setInscription();
        abonnes.add(getPrenom()+" "+getNom());
        emails.add(getEmail());
        inscriptions.add(getInscription());
    }

    public static void afficherAbonnes(){
        for (String abonne : abonnes) {
            System.out.println(abonne);
        }
    }
}
