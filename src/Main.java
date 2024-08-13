import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import fr.pompey.dev.afpa.classes.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Enregistrement de l'abonné.");
        Abonne abo = new Abonne();
        System.out.println("Enregistrement de la bibliothécaire.");
        Bibliothecaire bib = new Bibliothecaire();
        System.out.println("Enregistrement du livre.");
        Livre liv = new Livre();
        System.out.println("Enregistrement du prêt.");
        Pret pre = new Pret();

        Scanner sc = new Scanner(System.in);
        int choix =- 1;
        while (choix != 7){
            System.out.println("Entrez 1 pour enregistrer un nouvel abonné.");
            System.out.println("Entrez 2 pour enregistrer un nouveau livre.");
            System.out.println("Entrez 3 pour enregistrer un nouveau prêt.");
            System.out.println("Entrez 4 pour afficher la liste des abonnés.");
            System.out.println("Entrez 5 pour afficher la liste des livres.");
            System.out.println("Entrez 6 pour afficher la liste des prêts.");
            System.out.println("Entrez 7 pour quitter.");
            while(choix<1 || choix >7){
                choix = sc.nextInt();
                switch (choix){
                    case 1:
                        abo = new Abonne();
                        break;
                    case 2:
                        liv = new Livre();
                        break;
                    case 3:
                        pre = new Pret();
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
                        System.out.println("Merci de choisir une option valide.");
                }
            }
            choix=-1;

        }
    }
}