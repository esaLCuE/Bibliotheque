package fr.pompey.dev.afpa.classes;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static fr.pompey.dev.afpa.classes.Abonne.*;
import static fr.pompey.dev.afpa.classes.Livre.*;

public class Pret {
    private LocalDate debut;
    private LocalDate fin;
    private String livrePret;
    private String aboPret;

    Scanner sc = new Scanner(System.in);
    int idAbo;
    int idLivre;
    boolean abotrouve;
    boolean livdispo;
    boolean livtrouve;

    private void setAboPret() {
        // ON ENTRE LE NOM D'UN ABONNE ET ON VERIFIE QU'IL EST BIEN INSCRIT
        boolean abotrouve = false;
        this.aboPret = "";
        while (this.aboPret == null || this.aboPret.isEmpty() || !this.aboPret.matches("^[a-zA-Z\\s]*$") || !abotrouve) {
            System.out.println("Quel abonné souhaite emprunter (format Prénom Nom).");
            this.aboPret = sc.nextLine();
            if(!this.aboPret.matches("^[a-zA-Z\\s]*$")) {
                System.out.println("Nom invalide.");
            } else {
                for (int i = 0; i < abonnes.size(); i++) {
                    if (this.aboPret.equalsIgnoreCase(abonnes.get(i))) {
                        abotrouve = true;
                        idAbo = i;
                        break;
                    }
                }
                if (!abotrouve) {
                    System.out.println("Nom inconnu dans la base de données.");
                }
            }
        }
    }

    private void setLivrePret() {
        // ON CHOISIT UN LIVRE ET ON VERIFIE QU'IL EST PRESENT DANS LA BASE DE DONNEES ET QU'UN EXEMPLAIRE EST DISPO
        livdispo=false;
        livtrouve=false;
        this.livrePret = "";
        while (Objects.equals(this.livrePret, "") || this.livrePret == null ||
                !this.livrePret.matches("^[A-Za-z0-9\\s\\-_,.;:()]+$") || !livtrouve) {
            System.out.println("Quel livre emprunter ?");
            this.livrePret = sc.nextLine();
            if (!this.livrePret.matches("^[A-Za-z0-9\\s\\-_,.;:()]+$")) {
                System.out.println("Titre invalide.");
            } else {
                for (int i = 0; i < titres.size(); i++) {
                    if (this.livrePret.equalsIgnoreCase(titres.get(i))) {
                        livtrouve=true;
                        if (!(quantites.get(i) >0)){
                            System.out.println("Ce titre n'est pas disponible actuellement.");
                            break;
                        } else {
                            idLivre = i;
                            livdispo = true;
                            break;
                        }
                    }
                }
                if (!livtrouve) {
                    System.out.println("Titre inconnu dans la base de données.");
                }
            }
        }
    }

    private void setDebut() {
        // ON FIXE DATE DE DEBUT DE PRÊT ET ON S'ASSURER QU'IL N'EST PAS ANTERIEUR A LA DATE D'INSCRIPTION
        this.debut = inscriptions.get(idAbo).minusDays(1);
        while (this.debut.isBefore(inscriptions.get(idAbo))) {

            System.out.println("Entrez l'année de début de prêt.");
            int annee = sc.nextInt();
            int mois = -1;
            int jour = -1;
            while (mois < 1 || mois > 12) {
                System.out.println("Entrez le mois de début de prêt.");
                mois = sc.nextInt();
            }

            int jmax;
            if (mois == 2) {
                if (annee % 4 != 0 || (annee % 100 == 0 && annee % 400 != 0)) {
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
                System.out.println("Entrez le jour de début de prêt.");
                jour = sc.nextInt();
            }
            this.debut = LocalDate.of(annee, mois, jour);

            if (this.debut.isBefore(inscriptions.get(idAbo))){
                System.out.println("Date invalide : un prêt ne peut pas précéder l'inscription.");
            }
        }
    }

    private void setFin(){
        // ON FIXE DATE DE FIN ET ON VERIFIE QU'ELLE EST ULTERIEURE A LA DATE DE DEBUT
        this.fin = this.debut.minusDays(1);
        while (this.fin.isBefore(this.debut)) {
            System.out.println("Entrez l'année de fin de prêt.");
            int annee = sc.nextInt();
            int mois = -1;
            int jour = -1;
            while (mois < 1 || mois > 12) {
                System.out.println("Entrez le mois de fin de prêt.");
                mois = sc.nextInt();
            }

            int jmax;
            if (mois == 2) {
                if (annee % 4 != 0 || (annee % 100 == 0 && annee % 400 != 0)) {
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
                System.out.println("Entrez le jour de fin de prêt.");
                jour = sc.nextInt();
            }
            this.fin = LocalDate.of(annee, mois, jour);
            if (this.fin.isBefore(this.debut)) {
                System.out.println("La date de fin de prêt ne peut pas être antérieure à celle de début.");
            }
        }
    }

    private int getAboPret(){
        return this.idAbo;
    }
    private int getLivrePret(){
        return this.idLivre;
    }

    private LocalDate getDebut(){
        return this.debut;
    }
    private LocalDate getFin(){
        return this.fin;
    }

    static List<Integer> idAbos = new ArrayList<>();
    static List<Integer> idLivres = new ArrayList<>();
    static List<LocalDate> debuts = new ArrayList<>();
    static List<LocalDate> fins = new ArrayList<>();
    static List<String> tousPrets = new ArrayList<>();

    public Pret(){
        setAboPret();
        setLivrePret();
        if (livdispo) {
            setDebut();
            setFin();
            idAbos.add(getAboPret());
            idLivres.add(getLivrePret());
            quantites.set(idLivre, quantites.get(idLivre) - 1);
            debuts.add(getDebut());
            fins.add(getFin());
            tousPrets.add(titres.get(idLivre) + " a été emprunté le " + debuts.getLast() + " par " + abonnes.get(idAbo)
                    + " et sera rendu d'ici au " + fins.getLast());
            System.out.println(tousPrets.getLast());
        }
    }

    public static void afficherPrets(){
        for (String tousPret : tousPrets) {
            System.out.println(tousPret);
        }
    }

}
