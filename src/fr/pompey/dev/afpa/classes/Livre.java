package fr.pompey.dev.afpa.classes;
import java.util.*;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Livre {
    String titre;
    String auteur;
    int quantite;

    Scanner sc = new Scanner(System.in);

    public void setTitre(String titre) throws NullPointerException, InputMismatchException {
    /*  this.titre="";
        while (Objects.equals(this.titre, "") || this.titre==null || this.titre.matches("\\s+") ||
                !this.titre.matches("^[A-Za-z0-9\\s\\-_,.;:()]+$")){
            afficher("Veuillez entrer le titre du livre.");
            this.titre = Saisie.getString();
        }
     */
        if (titre == null) {
            throw new NullPointerException("Merci de saisir un titre valide.");
        }
        if (titre.isEmpty() || titre.matches("\\s+")) {
            throw new InputMismatchException("Merci de saisir un titre valide.");
        }
        if (!titre.matches("^[A-Za-zà-üÀ-Ü0-9\\s\\-_,.;:()]+$")) {
            throw new InputMismatchException("Merci de saisir un titre valide");
        }
        this.titre=titre;
    }
    public void setAuteur(String auteur) throws InputMismatchException, NullPointerException {
    /*    this.auteur="";
        while (Objects.equals(this.auteur, "") || this.auteur==null || this.auteur.matches("\\s+") ||
                !this.auteur.matches("^[a-zA-Z\\s]*$")){
            afficher("Veuillez entrer l'auteur du livre.");
            this.auteur = Saisie.getString();
        }
     */
        if (auteur == null) {
            throw new NullPointerException("Merci de saisir un auteur valide.");
        }
        if (auteur.isEmpty() || auteur.matches("\\s+")) {
            throw new InputMismatchException("Merci de saisir un auteur valide.");
        }
        if (!auteur.matches("^[a-zA-Zà-üÀ-Ü\\s-]*$")) {
            throw new InputMismatchException("Merci de saisir un auteur valide.");
        }
        this.auteur=auteur;
    }
    public void setQuantite(int quantite) throws IllegalArgumentException, InputMismatchException {
    /*    this.quantite=-1;
        while (this.quantite <1){
            afficher("Combien d'exemplaires ?");
            this.quantite = Saisie.getInt();
            if (this.quantite < 1){
                afficher("Nombre d'exemplaires invalide.");
            }
        }
     */
        if (quantite < 0) {
            throw new InputMismatchException("Merci de saisir un quantité valide de livres.");
        }

        this.quantite=quantite;
    }

    public String getTitre(){
        return this.titre;
    }
    public String getAuteur(){
        return this.auteur;
    }
    public int getQuantite(){
        return this.quantite;
    }

    public static List<Livre> livres = new ArrayList<>();

    public Livre(String titre, String auteur, int quantite) throws NullPointerException, IllegalArgumentException, InputMismatchException {
        setTitre(titre);
        setAuteur(auteur);
        setQuantite(quantite);
    }

    public static void augmenterQtt(int idL, int ajoutL){
        livres.get(idL).quantite += ajoutL;
    }

    public static void afficherLivres(){
        for (int i = 0; i < livres.size(); i++){
            afficher(livres.get(i).titre + " de " + livres.get(i).auteur + " en " + livres.get(i).quantite + " exemplaires.");
        }
        afficher("---------------");
    }
}
