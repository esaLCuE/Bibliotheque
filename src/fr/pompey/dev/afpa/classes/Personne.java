package fr.pompey.dev.afpa.classes;
import java.util.Scanner;

public class Personne {
    Scanner sc = new Scanner(System.in);
    private String nom;
    private String prenom;

    private void setNom(){
        this.nom="";
        while (this.nom==null || this.nom.isEmpty() || !this.nom.matches("^[a-zA-Z\\s]*$")) {
            System.out.println("Entrez le nom de famille.");
            this.nom = sc.nextLine();
        }
    }
    private void setPrenom(){
        this.prenom="";
        while (this.prenom==null || this.prenom.isEmpty() || !this.prenom.matches("^[a-zA-Z\\s]*$")) {
            System.out.println("Entrez le prénom.");
            this.prenom = sc.nextLine();
        }
    }

    protected String getNom(){
        return this.nom;
    }
    protected String getPrenom(){
        return this.prenom;
    }

    public Personne() {
        setNom();
        setPrenom();
    }
}
