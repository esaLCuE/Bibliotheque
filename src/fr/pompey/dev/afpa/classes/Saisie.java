package fr.pompey.dev.afpa.classes;
import java.time.*;
import java.util.Scanner;

public class Saisie {
    private static Scanner sc = new Scanner(System.in);
    public static String getString(){
        return sc.nextLine();
    }
    public static int getInt(){
        int x = sc.nextInt();
        sc.nextLine();
        return x;
    }
    public static LocalDate getDate(String motif){
        afficher("Entrez l'année de "+motif+".");
        int annee = Saisie.getInt();
        int mois = -1;
        int jour = -1;
        while (mois<1||mois>12){
            afficher("Entrez le mois de "+motif+".");
            mois = Saisie.getInt();
        }

        int jmax;
        if (mois==2){
            if (annee%4!=0 || (annee%100 == 0 && annee%400 != 0)){
                jmax = 28;
            } else {
                jmax = 29;
            }
        } else if (mois == 4 || mois == 6 || mois == 9 || mois == 11) {
            jmax = 30;
        } else {
            jmax = 31;
        }
        while (jour < 1 || jour > jmax) {
            afficher("Entrez le jour de "+motif+".");
            jour = Saisie.getInt();
        }
        return(LocalDate.of(annee, mois, jour));
    }

    public static void afficher(String message){
        System.out.println(message);
    }
}
