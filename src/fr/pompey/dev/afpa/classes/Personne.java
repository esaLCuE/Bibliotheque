package fr.pompey.dev.afpa.classes;
import java.util.Scanner;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Personne {
    Scanner sc = new Scanner(System.in);
    private String nom;
    private String prenom;

    public void setNom(){
        this.nom="";
        while (this.nom==null || this.nom.isEmpty() || !this.nom.matches("^[a-zA-Z\\s]*$")) {
            afficher("Entrez le nom de famille.");
            this.nom = Saisie.getString();
        }
    }
    public void setPrenom(){
        this.prenom="";
        while (this.prenom==null || this.prenom.isEmpty() || !this.prenom.matches("^[a-zA-Z\\s]*$")) {
            afficher("Entrez le prénom.");
            this.prenom = Saisie.getString();
        }
    }

    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }

    public Personne() {
        setNom();
        setPrenom();
    }
}
