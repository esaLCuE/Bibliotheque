package fr.pompey.dev.afpa.classes;
import java.time.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Saisie {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(){
        return sc.nextLine();
    }

    public static int getInt(){
        try {
            int x = sc.nextInt();
            sc.nextLine();
            return x;
        }catch(InputMismatchException e){
            afficher("Valeur invalide");
            sc.nextLine();
            return -1;
        }
    }

    public static LocalDate getDate(String motif){

        int annee = -1;
        int mois = -1;
        int jour = -1;
        while (annee<1) {
            afficher("Entrez l'année de "+motif+".");
            annee = Saisie.getInt();
            if(annee<1) {
                afficher("Année invalide");
            }
        }
        while (mois<1||mois>12){
            afficher("Entrez le mois de "+motif+".");
            mois = Saisie.getInt();
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
            afficher("Entrez le jour de "+motif+".");
            jour = Saisie.getInt();
        }
        return(LocalDate.of(annee, mois, jour));
    }

    public static void afficher(String message){
        System.out.println(message);
    }

    public static Abonne creerAbonne(){

        Abonne abo = null;
        boolean ok = false;
        while (!ok) {
            try {
                afficher("Quel est le nom de famille de l'abonné ?");
                String nom = getString();
                afficher("Quel est le prénom de l'abonné ?");
                String prenom = getString();
                afficher("Quel est l'email de l'abonné ?");
                String email = getString();
                afficher("Quelle est la date d'inscription de l'abonné ?");
                LocalDate date = getDate("l'inscription");

                abo = new Abonne(nom, prenom, email, date);
                if(abo.getNom()==null || abo.getPrenom()==null || abo.getEmail()==null){
                    throw new InputMismatchException();
                }

                ok=true;
            } catch (InputMismatchException e) {
                afficher(e.getMessage());
            }
        }
        return(abo);
    }

    public static Bibliothecaire creerBibliothecaire(){

        Bibliothecaire bib = null;
        boolean ok = false;
        while (!ok) {
            try {
                afficher("Quel est le nom de famille de la bibliothécaire ?");
                String nom = getString();
                afficher("Quel est le prénom de la bibliothécaire ?");
                String prenom = getString();
                afficher("Quel est l'identifiant de la bibliothécaire ?");
                String identifiant = getString();

                bib = new Bibliothecaire(nom, prenom, identifiant);
                if(bib.getNom()==null || bib.getPrenom()==null || bib.getIdentifiant()==null){
                    throw new InputMismatchException();
                }

                ok=true;
            } catch (InputMismatchException e) {
                afficher(e.getMessage());
            }
        }
        return(bib);
    }

    public static Livre creerLivre(){

        Livre liv = null;
        boolean ok = false;
        while (!ok) {
            try {
                afficher("Quel est le titre du livre ?");
                String titre = getString();
                afficher("Qui est l'auteur du livre ?");
                String auteur = getString();
                afficher("En combien d'exemplaires ?");
                int quantite = getInt();

                liv = new Livre(titre, auteur, quantite);
                if (liv.getTitre()==null || liv.getAuteur()==null){
                    throw new InputMismatchException();
                }

                ok=true;
            } catch (InputMismatchException e) {
                afficher(e.getMessage());
            }
        }
        return(liv);
    }

    public static Pret creerPret(){

        Pret pre = null;
            try {
                afficher("Qui souhaite emprunter ? (Prénom Nom)");
                String aboPret = getString();
                afficher("Quel livre emprunter ?");
                String livrePret = getString();
                LocalDate debutPret = getDate("debut de prêt");
                LocalDate finPret = getDate("fin de prêt");

                pre = new Pret(aboPret, livrePret, debutPret, finPret);
                if (pre.getAboPret()==-1 || pre.getLivrePret()==-1 || pre.getDebut()==null || pre.getFin()==null){
                    throw new InputMismatchException();
                }

            } catch (InputMismatchException e) {
                afficher(e.getMessage());
            }

        return(pre);
    }

}
