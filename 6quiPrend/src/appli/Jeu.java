package appli;
import objets.*;
import util.Console;
import java.util.Scanner;

public class Jeu {
	public static Scanner scan = new Scanner(System.in);
	
	//Fonction principale du jeu
	public static void main(String[] args) {
		Joueurs listeJ = new Joueurs();
		int nbTetesMin = 104;
		String continuer;
		Joueur vainqueur = null;
		do {
			Cartes deck = new Cartes();
			Plateau table = new Plateau();
			//Distribution cartes
			for (int i = 0; i < listeJ.getNbJoueurs(); ++i)
				for (int j = 0; j < deck.INIT_CARTES; ++j)
					listeJ.getJoueur(i).prendreCarte(deck.prendreCarte());
			//Pose des cartes sur le plateau
			for (int i = 0; i < table.NB_SERIES; ++i)
				table.getSerie(i).poser(deck.prendreCarte());
			
			//Affichage initial
			System.out.print("Les " + listeJ.getNbJoueurs() + " joueurs sont ");
			for (int i = 0; i < listeJ.getNbJoueurs(); ++i) {
				System.out.print(listeJ.getJoueur(i).getNom());
				if (i == listeJ.getNbJoueurs() - 1)
					System.out.print(". Merci de jouer à 6 qui prend !\n");
				else
					if (i == listeJ.getNbJoueurs() - 2)
						System.out.print(" et ");
					else
						System.out.print(", ");
			}
			
			//Début du jeu
				
			for (int c = 0; c < deck.INIT_CARTES; ++c) {
				for (int i = 0; i < listeJ.getNbJoueurs(); ++i) {
					System.out.println("A " + listeJ.getJoueur(i).getNom() + " de jouer.");
					Console.pause();
					System.out.println(table);
					System.out.println(listeJ.getJoueur(i));
					table.poseCarte(listeJ.getJoueur(i), listeJ.getJoueur(i).choixCarte());
					Console.clearScreen();
				}
				table.placerCartes();
			}
			System.out.println("** Score final");
			for (int i = 0; i < listeJ.getNbJoueurs(); ++i)
				System.out.println(listeJ.getJoueur(i).getNom() + " a ramassé " + listeJ.getJoueur(i).getNbTetes() + " têtes de boeufs.");
			
			
			//Décision du vainqueur
			for (int i = 0; i < listeJ.getNbJoueurs(); ++i)
				if (listeJ.getJoueur(i).getNbTetes() < nbTetesMin) {
					nbTetesMin = listeJ.getJoueur(i).getNbTetes();
					vainqueur = listeJ.getJoueur(i);
				}
			System.out.println("Le vainqueur est " + vainqueur.getNom() + " !");
			
			System.out.println("Voulez-vous rejouer ? o/n");
			continuer = scan.nextLine(); //Problème ici, il ne lit pas correctement
		}while(continuer.toLowerCase().equals("o"));
		scan.close();
		//Décision du vainqueur
		for (int i = 0; i < listeJ.getNbJoueurs(); ++i)
			if (listeJ.getJoueur(i).getNbTetes() < nbTetesMin) {
				nbTetesMin = listeJ.getJoueur(i).getNbTetes();
				vainqueur = listeJ.getJoueur(i);
			}
		System.out.println("Le vainqueur est " + vainqueur.getNom() + " !");
	}
}