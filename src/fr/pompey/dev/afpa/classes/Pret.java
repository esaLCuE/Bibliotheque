package fr.pompey.dev.afpa.classes;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static fr.pompey.dev.afpa.classes.Abonne.*;
import static fr.pompey.dev.afpa.classes.Livre.*;
import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Pret {
    private LocalDate debut;
    private LocalDate fin;
    private String livrePret;
    private String aboPret;

    Scanner sc = new Scanner(System.in);
    private int idAbo;
    private int idLivre;
    private boolean abotrouve;
    private boolean livdispo;
    private boolean livtrouve;

    public void setAboPret() {
        // ON ENTRE LE NOM D'UN ABONNE ET ON VERIFIE QU'IL EST BIEN INSCRIT
        boolean abotrouve = false;
        this.aboPret = "";
        while (this.aboPret == null || this.aboPret.isEmpty() || !this.aboPret.matches("^[a-zA-Z\\s]*$") || !abotrouve) {
            afficher("Quel abonné souhaite emprunter (Prénom Nom).");
            this.aboPret = Saisie.getString();
            if(!this.aboPret.matches("^[a-zA-Z\\s]*$")) {
                afficher("Nom invalide.");
            } else {
                for (int i = 0; i < abonnes.size(); i++) {
                    if (this.aboPret.equalsIgnoreCase(abonnes.get(i))) {
                        abotrouve = true;
                        idAbo = i;
                        break;
                    }
                }
                if (!abotrouve) {
                    afficher("Nom inconnu dans la base de données.");
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
            afficher("Quel livre emprunter ?");
            this.livrePret = sc.nextLine();
            if (!this.livrePret.matches("^[A-Za-z0-9\\s\\-_,.;:()]+$")) {
                afficher("Titre invalide.");
            } else {
                for (int i = 0; i < titres.size(); i++) {
                    if (this.livrePret.equalsIgnoreCase(titres.get(i))) {
                        livtrouve=true;
                        if (!(quantites.get(i) >0)){
                            afficher("Ce titre n'est pas disponible actuellement.");
                            break;
                        } else {
                            idLivre = i;
                            livdispo = true;
                            break;
                        }
                    }
                }
                if (!livtrouve) {
                    afficher("Titre inconnu dans la base de données.");
                }
            }
        }
    }

    private void setDebut() {
        // ON FIXE DATE DE DEBUT DE PRÊT ET ON S'ASSURER QU'IL N'EST PAS ANTERIEUR A LA DATE D'INSCRIPTION
        this.debut = inscriptions.get(idAbo).minusDays(1);
        while (this.debut.isBefore(inscriptions.get(idAbo))) {

            this.debut = Saisie.getDate("début de prêt");

            if (this.debut.isBefore(inscriptions.get(idAbo))){
                afficher("Date invalide : un prêt ne peut pas précéder l'inscription.");
            }
        }
    }

    private void setFin(){
        // ON FIXE DATE DE FIN ET ON VERIFIE QU'ELLE EST ULTERIEURE A LA DATE DE DEBUT
        this.fin = this.debut.minusDays(1);
        while (this.fin.isBefore(this.debut)) {

            this.fin = Saisie.getDate("fin de prêt");

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
            afficher(tousPret);
        }
    }

}
