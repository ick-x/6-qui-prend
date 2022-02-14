package Jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueurs
{
    private static String nom;
    private static int nbJoueurs;
    private static int maxJoueurs = 10;

    //création d'une ArrayList de joueurs
    private static ArrayList<String> listeJoueurs = new ArrayList<String>(nbJoueurs);

    //constructeur de la class Joueurs
    public Joueurs(String nomJoueur)
    {
        this.nom = nomJoueur;
    }

    public static int initJoueurs()
    {
        //entrée des nouveaux Joueurs
        Scanner scanner = new Scanner(System.in);
        String nomJ = scanner.nextLine();

        for (int i = 1; i <= maxJoueurs; ++i)
        {


            //ajout des noms des Joueurs dans l'ArrayList
            listeJoueurs.add(nomJ);
            Joueurs joueur = new Joueurs(nomJ);

            //ajout du nombre de Joueurs dans la variable correspondante
            nbJoueurs = listeJoueurs.size();

            if((nomJ = scanner.nextLine()).isEmpty())
            {
                break; //ça marche pas
            }

            System.out.println(nbJoueurs);
            System.out.println(listeJoueurs);
        }


        return nbJoueurs;
    }
}
