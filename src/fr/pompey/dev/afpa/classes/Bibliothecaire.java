package fr.pompey.dev.afpa.classes;

import java.util.ArrayList;
import java.util.List;

public class Bibliothecaire extends Personne {
    public String identifiant;

    private void setIdentifiant(){
        this.identifiant = "";
        while ((this.identifiant == null) || (this.identifiant.length()<5)) {
            System.out.println("Entrez l'identifiant de la bibliothécaire.");
            this.identifiant = sc.nextLine();
        }
    }
    private String getIdentifiant(){
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
