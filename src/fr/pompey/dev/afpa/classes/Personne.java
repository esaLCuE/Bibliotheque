package fr.pompey.dev.afpa.classes;
import java.util.Scanner;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Personne {
    Scanner sc = new Scanner(System.in);
    private String nom;
    private String prenom;

    public void setNom(String nom) throws NullPointerException, IllegalArgumentException {
        /* while (nom==null || nom.matches("\\s+") || nom.isEmpty() ||
                !nom.matches("^[a-zA-Z\\s]*$")) {
            afficher("Entrez le nom de famille.");
            nom = Saisie.getString();
        }*/
        try {
            if (nom == null) {
                throw new NullPointerException("Erreur Systeme : valeur nulle");
            }

            if (nom.isEmpty() || nom.matches("\\s+")) {
                throw new IllegalArgumentException("Merci de saisir un nom");
            }

            if (!nom.matches("^[a-zA-Zà-üÀ-Ü\\s-]*$")) {
                throw new IllegalArgumentException("Merci de saisir un nom valide");
            }

            this.nom=nom;
        } catch (Exception e) {
            afficher(e.getMessage());
        }

    }
    public void setPrenom(String prenom){
    /*  while (prenom==null || prenom.matches("\\s+") || prenom.isEmpty() ||
                !prenom.matches("^[a-zA-Z\\s]*$")) {
            afficher("Entrez le prénom.");
            prenom = Saisie.getString();
        } */
        try {
            if (prenom == null) {
                throw new NullPointerException("Erreur Systeme : valeur nulle");
            }

            if (prenom.isEmpty() || prenom.matches("\\s+")) {
                this.prenom = null;
                throw new IllegalArgumentException("Merci de saisir un prénom");
            }

            if (!prenom.matches("^[a-zA-Zà-üÀ-Ü\\s-]*$")) {
                this.prenom=null;
                throw new IllegalArgumentException("Merci de saisir un prénom valide");
            }

            this.prenom = prenom;
        } catch (Exception e) {
            afficher(e.getMessage());
        }
    }

    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }

    public Personne(String nom, String prenom) throws NullPointerException, IllegalArgumentException  {
        setNom(nom);
        setPrenom(prenom);
    }
}
