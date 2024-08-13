package fr.pompey.dev.afpa.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.time.*;
import java.util.List;

public class Abonne extends Personne {
    public String email;
    public LocalDate inscription;
    Scanner sc = new Scanner(System.in);

    private void setEmail(){
        this.email = "";
        while (this.email==null || this.email.isEmpty() ||
                !this.email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            System.out.println("Entrez l'email de l'abonné.");
            this.email = sc.nextLine();
        }
    }

    private String getEmail(){
        return this.email;
    }


    private void setInscription(){
        System.out.println("Entrez l'année de l'inscription.");
        int annee = sc.nextInt();
        int mois = -1;
        int jour = -1;
        while (mois<1||mois>12){
            System.out.println("Entrez le mois de l'inscription.");
            mois = sc.nextInt();
        }

        int jmax;
        if (mois==2){
            if (annee%4!=0 || (annee%100 == 0 && annee%400 != 0)){
                jmax = 28;
            } else {
                jmax = 29;
            }
        } else if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {
            jmax = 30;
        } else {
            jmax = 31;
        }
        while (jour < 1 || jour > jmax) {
            System.out.println("Entrez le jour de l'inscription.");
            jour = sc.nextInt();
        }
        this.inscription = LocalDate.of(annee,mois,jour);
    }

    private LocalDate getInscription(){
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
