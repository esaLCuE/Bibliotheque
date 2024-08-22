package fr.pompey.dev.afpa.classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Bibliothecaire extends Personne {
    private String identifiant;

    public void setIdentifiant(String identifiant){
    /*  this.identifiant = "";
        while ((this.identifiant == null) || (this.identifiant.length()<5)) {
            afficher("Entrez l'identifiant de la bibliothécaire.");
        } */
        if (identifiant == null) {
            throw new NullPointerException("Erreur Systeme : valeur nulle");
        }

        if (identifiant.isEmpty() || identifiant.matches("\\s+")) {
            throw new InputMismatchException("Merci de saisir un identifiant");
        }

        if (identifiant.length()<5) {
            throw new InputMismatchException("Merci de saisir un identifiant d'une longueur de 5 minimum");
        }
        try {
            this.identifiant=identifiant;
        } catch (Exception e) {
            afficher(e.getMessage());
        }

    }
    public String getIdentifiant(){
        return this.identifiant;
    }

    static List<String> biblio = new ArrayList<>();

    public Bibliothecaire(String nom, String prenom, String identifiant)
            throws NullPointerException, IllegalArgumentException {
        super(nom, prenom);
        setIdentifiant(identifiant);
        biblio.add(getPrenom()+" "+getNom());
        biblio.add(getIdentifiant());
    }
}
