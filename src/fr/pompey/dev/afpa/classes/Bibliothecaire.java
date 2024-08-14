package fr.pompey.dev.afpa.classes;

import java.util.ArrayList;
import java.util.List;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Bibliothecaire extends Personne {
    private String identifiant;

    public void setIdentifiant(){
        this.identifiant = "";
        while ((this.identifiant == null) || (this.identifiant.length()<5)) {
            afficher("Entrez l'identifiant de la bibliothécaire.");
            this.identifiant = Saisie.getString();
        }
    }
    public String getIdentifiant(){
        return this.identifiant;
    }

    static List<String> biblio = new ArrayList<>();

    public Bibliothecaire() {
        super();
        setIdentifiant();
        biblio.add(getPrenom()+" "+getNom());
        biblio.add(getIdentifiant());
    }
}
