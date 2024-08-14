import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import fr.pompey.dev.afpa.classes.*;

import static fr.pompey.dev.afpa.classes.Saisie.afficher;


public class Main {
    public static void main(String[] args) {
        afficher("Enregistrement de l'abonné.");
        Abonne abo = new Abonne();

        afficher("Enregistrement de la bibliothécaire.");
        Bibliothecaire bib = new Bibliothecaire();

        afficher("Enregistrement du livre.");
        Livre liv = new Livre();

        afficher("Enregistrement du prêt.");
        Pret pre = new Pret();

        Scanner sc = new Scanner(System.in);
        int choix =- 1;
        while (choix != 7){
            afficher("Entrez 1 pour enregistrer un nouvel abonné.");
            afficher("Entrez 2 pour enregistrer un nouveau livre.");
            afficher("Entrez 3 pour enregistrer un nouveau prêt.");
            afficher("Entrez 4 pour afficher la liste des abonnés.");
            afficher("Entrez 5 pour afficher la liste des livres.");
            afficher("Entrez 6 pour afficher la liste des prêts.");
            afficher("Entrez 7 pour quitter.");
            while(choix<1 || choix >7){
                choix = sc.nextInt();
                switch (choix){
                    case 1:
                        Abonne nouvelAbo;
                        break;
                    case 2:
                        Livre nouveauLiv;
                        break;
                    case 3:
                        Pret nouveauPre;
                        break;
                    case 4:
                        Abonne.afficherAbonnes();
                        break;
                    case 5:
                        Livre.afficherLivres();
                        break;
                    case 6:
                        Pret.afficherPrets();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        afficher("Merci de choisir une option valide.");
                }
            }
            choix=-1;

        }
    }
}