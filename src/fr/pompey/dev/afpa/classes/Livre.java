package fr.pompey.dev.afpa.classes;
import java.util.*;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;

public class Livre {
    private String titre;
    private String auteur;
    private int quantite;

    Scanner sc = new Scanner(System.in);

    public void setTitre(String titre){
    /*  this.titre="";
        while (Objects.equals(this.titre, "") || this.titre==null || this.titre.matches("\\s+") ||
                !this.titre.matches("^[A-Za-z0-9\\s\\-_,.;:()]+$")){
            afficher("Veuillez entrer le titre du livre.");
            this.titre = Saisie.getString();
        }
     */
        if (titre == null) {
            throw new NullPointerException("Erreur Systeme : valeur nulle");
        }
        if (titre.isEmpty() || titre.matches("\\s+")) {
            throw new InputMismatchException("Merci de saisir un titre");
        }
        if (!titre.matches("^[A-Za-z0-9\\s\\-_,.;:()]+$")) {
            throw new InputMismatchException("Merci de saisir un titre valide");
        }
        try {
            this.titre=titre;
        } catch (Exception e) {
            afficher(e.getMessage());
        }
    }
    public void setAuteur(String auteur){
    /*    this.auteur="";
        while (Objects.equals(this.auteur, "") || this.auteur==null || this.auteur.matches("\\s+") ||
                !this.auteur.matches("^[a-zA-Z\\s]*$")){
            afficher("Veuillez entrer l'auteur du livre.");
            this.auteur = Saisie.getString();
        }
     */
        if (auteur == null) {
            throw new NullPointerException("Erreur Systeme : valeur nulle");
        }
        if (auteur.isEmpty() || auteur.matches("\\s+")) {
            throw new InputMismatchException("Merci de saisir un auteur");
        }
        if (!auteur.matches("^[a-zA-Z\\s-]*$")) {
            throw new InputMismatchException("Merci de saisir un auteur valide");
        }
        try {
            this.auteur=auteur;
        } catch (Exception e) {
            afficher(e.getMessage());
        }
    }
    public void setQuantite(int quantite){
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
            throw new InputMismatchException("Merci de saisir un quantité positive");
        }
        try {
            this.quantite=quantite;
        } catch (Exception e) {
            afficher(e.getMessage());
        }
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

    static List<String> titres = new ArrayList<>();
    static List<String> auteurs = new ArrayList<>();
    static List<Integer> quantites = new ArrayList<>();

    public Livre(String titre, String auteur, int quantite) throws NullPointerException, IllegalArgumentException {
        setTitre(titre);
        setAuteur(auteur);
        setQuantite(quantite);
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
            afficher(titres.get(i)+" en "+quantites.get(i)+" exemplaires.");
        }
    }
}
