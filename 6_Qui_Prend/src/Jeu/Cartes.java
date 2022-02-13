package Jeu;
import java.util.ArrayList;

public class Cartes {
    public static int nbCartes = 104;
    private static int valeur;
    private static int nbTetes;

    //création d'une Array liste de Cartes qui servira de paquet
    private static ArrayList<Cartes> paquet = new ArrayList<Cartes>(nbCartes);
    
    public Cartes(int numéro, int tetes)
    {
            //constructeur de la Class carte, qui défini le numéro
            //et le nombre de têtes de boeuf associés à chaque cartes.

            this.valeur = numéro;
            this.nbTetes = tetes;
    }

    public static void creerPaquet()
    {
        int tetes;
        //incrémentation des toutes les cartes dans le paquet avec leur valeur et leur nombre de têtes
        for (int i = 1; i <= nbCartes; ++i)
        {
            if (i % 11 == 0 && i != 55)
            {
                //la valeur est formée par deux chiffres égaux mais =/= 55
                tetes = 5;
                paquet.add(new Cartes(i, tetes));
            }
            else if (i == 55)
            {
                //la carte 5
                tetes = 7;
                paquet.add(new Cartes(i, tetes));
            }
            else if (i % 10 == 5 && i != 55)
            {
                //la valeur se termine par un 5 et =/= 55
                tetes = 2;
                paquet.add(new Cartes(i, tetes));
            }
            else if (i % 10 == 0)
            {
                //la valeur se termine par un 0
                tetes = 3;
                paquet.add(new Cartes(i, tetes));
            }
            else
            {
                //Toutes les autres cartes
                tetes = 1;
                paquet.add(new Cartes(i, tetes));
            }
        }
    }
}
