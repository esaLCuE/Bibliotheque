package fr.pompey.dev.afpa.classes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Livre {
    private String titre;
    private String auteur;
    private int quantite;

    Scanner sc = new Scanner(System.in);

    private void setTitre(){
        this.titre="";
        while (Objects.equals(this.titre, "") || this.titre==null || !this.titre.matches("^[A-Za-z0-9\\s\\-_,.;:()]+$")){
            System.out.println("Veuillez entrer le titre du livre.");
            this.titre = sc.nextLine();
        }
    }
    private void setAuteur(){
        this.auteur="";
        while (Objects.equals(this.auteur, "") || this.auteur==null || !this.auteur.matches("^[a-zA-Z\\s]*$")){
            System.out.println("Veuillez entrer l'auteur du livre.");
            this.auteur = sc.nextLine();
        }
    }
    private void setQuantite(){
        this.quantite=-1;
        while (this.quantite <1){
            System.out.println("Combien d'exemplaires ?");
            this.quantite = sc.nextInt();
            if (this.quantite < 1){
                System.out.println("Nombre d'exemplaires invalide.");
            }
        }
        sc.nextLine();
    }

    private String getTitre(){
        return this.titre;
    }
    private String getAuteur(){
        return this.auteur;
    }
    private int getQuantite(){
        return this.quantite;
    }

    static List<String> titres = new ArrayList<>();
    static List<String> auteurs = new ArrayList<>();
    static List<Integer> quantites = new ArrayList<>();

    public Livre(){
        setTitre();
        setAuteur();
        setQuantite();
        boolean dejaPres=false;
        for (int i = 0; i < titres.size(); i++){
            if ( (titres.get(i).equals(this.titre)) && (auteurs.get(i).equals(this.auteur)) ){
                quantites.set(i, quantites.get(i)+this.quantite);
                dejaPres=true;
            }
        }
        if (!dejaPres) {
            titres.add(getTitre());
            auteurs.add(getAuteur());
            quantites.add(getQuantite());
        }
    }

    public static void afficherLivres(){
        for (int i = 0; i < titres.size(); i++){
            System.out.println(titres.get(i)+" en "+quantites.get(i)+" exemplaires.");
        }
    }
}
