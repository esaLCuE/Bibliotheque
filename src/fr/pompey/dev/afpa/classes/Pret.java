package fr.pompey.dev.afpa.classes;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static fr.pompey.dev.afpa.classes.Abonne.*;
import static fr.pompey.dev.afpa.classes.Livre.*;
import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Pret {
    private LocalDate debutPret;
    private LocalDate finPret;
    private String livrePret;
    private String aboPret;
    private String autPret;

    Scanner sc = new Scanner(System.in);
    private int idAbo;
    private int idLivre;
    private boolean livdispo;
    private boolean abotrouve;
    private boolean dateImpos = false;

    public void setAboPret(String aboPret) {
    /*    // ON ENTRE LE NOM D'UN ABONNE ET ON VERIFIE QU'IL EST BIEN INSCRIT
        boolean abotrouve = false;
        this.aboPret = "";
        while (this.aboPret == null || this.aboPret.isEmpty() ||  this.aboPret.matches("\\s+") ||
                !this.aboPret.matches("^[a-zA-Z\\s]*$") || !abotrouve) {
            afficher("Quel abonné souhaite emprunter (Prénom Nom) ?");
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
     */
        try {
            abotrouve = true;
            if (!Abonne.abonnes.contains(aboPret)) {
                abotrouve = false;
                throw new IllegalArgumentException("Nom inconnu dans la base de données.");
            }
            //ON RECUPERE L'ID DE L'ABONNE
            if (abotrouve) {
                for (int i = 0; i < abonnes.size(); i++) {
                    if (aboPret.equalsIgnoreCase((abonnes.get(i).getPrenom())+" "+abonnes.get(i).getNom())) {
                        idAbo = i;
                        break;
                    }
                }
            }
            this.aboPret = aboPret;
        } catch (Exception e){
            this.idAbo =-1;
            afficher(e.getMessage());
        }
    }

    public void setLivrePret(String livrePret) {
    /*    // ON CHOISIT UN LIVRE ET ON VERIFIE QU'IL EST PRESENT DANS LA BASE DE DONNEES ET QU'UN EXEMPLAIRE EST DISPO
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
     */
        try {
            for (int i = 0; i < livres.size(); i++) {
                if (livrePret.equalsIgnoreCase(livres.get(i).titre)) {
                    if (!(livres.get(i).quantite > 0)) {
                        throw new IllegalArgumentException("Ce titre n'est pas disponible actuellement.");
                    } else {
                        idLivre = i;
                        livdispo = true;
                        break;
                    }
                } else if (i==livres.size()-1) {
                    throw new IllegalArgumentException("Titre inconnu dans la base de données.");
                }
            }
            this.livrePret = livrePret;
        } catch (Exception e){
            this.idLivre = -1;
            afficher(e.getMessage());
        }
    }

    public void setDebut(LocalDate debutPret) {
    /*    // ON FIXE DATE DE DEBUT DE PRÊT ET ON S'ASSURER QU'IL N'EST PAS ANTERIEUR A LA DATE D'INSCRIPTION
        this.debutPret = inscriptions.get(idAbo).minusDays(1);
        while (this.debutPret.isBefore(inscriptions.get(idAbo))) {

            this.debutPret = Saisie.getDate("début de prêt");

            if (this.debutPret.isBefore(inscriptions.get(idAbo))){
                afficher("Date invalide : un prêt ne peut pas précéder l'inscription.");
            }
        }
     */
        try {
            if (debutPret.isBefore(abonnes.get(idAbo).inscription)) {
                throw new IllegalArgumentException("Erreur : un prêt ne peux pas précéder l'inscription.");
            }
            this.debutPret = debutPret;
        } catch (Exception e){
            dateImpos=true;
            afficher(e.getMessage());
        }
    }

    public void setFin(LocalDate finPret){
    /*    // ON FIXE DATE DE FIN ET ON VERIFIE QU'ELLE EST ULTERIEURE A LA DATE DE DEBUT
        this.finPret = this.debutPret.minusDays(1);
        while (this.finPret.isBefore(this.debutPret)) {

            this.finPret = Saisie.getDate("fin de prêt");

            if (this.finPret.isBefore(this.debutPret)) {
                afficher("La date de fin de prêt ne peut pas être antérieure à celle de début.");
            }
        }
     */
        try {
            if (!dateImpos) {
                if (finPret.isBefore(this.debutPret)) {
                    throw new IllegalArgumentException("Erreur : la fin de prêt ne peux pas précéder le début.");
                }
                this.finPret = finPret;
            }
        } catch (Exception e){
            dateImpos=true;
            afficher(e.getMessage());
        }
    }

    public String getNomAboPret(){
        return this.aboPret;
    }
    public int getAboPret(){
        return this.idAbo;
    }

    public String getNomLivrePret(){
        return livrePret;
    }
    public int getLivrePret(){
        return this.idLivre;
    }

    public LocalDate getDebut(){
        return this.debutPret;
    }
    public LocalDate getFin(){
        return this.finPret;
    }

    static List<Pret> prets = new ArrayList<>();
    static List<Integer> idAbos = new ArrayList<>();
    static List<Integer> idLivres = new ArrayList<>();
    static List<LocalDate> debuts = new ArrayList<>();
    static List<LocalDate> fins = new ArrayList<>();
    static List<String> tousPrets = new ArrayList<>();

    public Pret(String aboPret, String livrePret, String autPret, LocalDate debutPret, LocalDate finPret)
            throws NullPointerException, IllegalArgumentException {
        setAboPret(aboPret);
        setLivrePret(livrePret);
        setDebut(debutPret);
        setFin(finPret);
        if (livdispo && abotrouve && !dateImpos) {

            idAbos.add(getAboPret());
            idLivres.add(getLivrePret());
            livres.get(idLivre).quantite-=1;
            debuts.add(getDebut());
            fins.add(getFin());

            prets.add(new Pret (aboPret, livrePret, autPret, debutPret, finPret));

            tousPrets.add(livrePret + " de " + livres.get(idLivre).auteur + " a été emprunté le " + debutPret + " par " + aboPret
                    + " et devra être rendu le " + finPret);
            afficher(tousPrets.getLast());
        }
    }

    public static void afficherPrets(){
        for (int i=0; i< livres.size(); i++) {
            afficher(prets.get(i).livrePret + " de " + prets.get(i).autPret + " a été emprunté le " + prets.get(i).debutPret
                    + " par " + prets.get(i).aboPret + " et devra être rendu le " + prets.get(i).finPret);
        }
    }

}
