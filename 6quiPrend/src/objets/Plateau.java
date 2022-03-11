package objets;
import java.util.ArrayList;
import java.util.HashMap;
import appli.*;

public class Plateau {
	public final int NB_SERIES = 4;
	
	//Création d'une ArrayList représentant l'ensemble des séries sur la table
	private ArrayList<Serie> listeS = new ArrayList<Serie>(NB_SERIES);
	//Création d'une HashMap représentant les cartes posées par chaque joueur à chaque tour
	private HashMap<Joueur, Carte> carteJouees = new HashMap<Joueur, Carte>();
	
	//Initialisation d'un plateau avec 4 séries
	public Plateau() {
		for (int i = 0; i < NB_SERIES; ++i)
			listeS.add(new Serie());
	}
	
	//Fonction permettant de placer les cartes jouées par les joueurs sur les séries
	public void placerCartes() {
		boolean placee;
		int serieChoisie;
		int ecart;
		Serie aux;
		
		//Affichage initial
		String str = "Les cartes ";
		ecart = 0;
		for (Joueur player: carteJouees.keySet())
			str = str + carteJouees.get(player) + " (" + player.getNom()+ "), ";
		str = str + "vont être posées.";
		System.out.println(str);
		
		for (Joueur player: carteJouees.keySet()) {
			placee = false;
			aux = null;
			ecart = 104;
			for (Serie s: listeS)
				if (carteJouees.get(player).getNum() - s.getLast().getNum() < ecart && carteJouees.get(player).getNum() - s.getLast().getNum() > 0) {
					aux = s;
					ecart = carteJouees.get(player).getNum() - s.getLast().getNum();
				}
			if (aux != null) {
				placee = true;
				if (aux.getNbCartes() == aux.MAX_SERIE) {
					player.ramasseSerie(aux);
					aux.poser(carteJouees.get(player));
				}else {
					aux.poser(carteJouees.get(player));
				}
			}
			//Impossible de placer la carte, le joueur choisit une série à ramasser
			if (!placee) {
				System.out.println("Pour poser la carte " + carteJouees.get(player).getNum() + ", " + player.getNom() + " doit choisir la série qu'il va ramasser.");
				System.out.println(this.toString());
				System.out.println("Saisissez votre choix : ");
				do {
					serieChoisie = Integer.parseInt(Jeu.scan.nextLine());
					if (serieChoisie > 4 || serieChoisie < 1)
						System.out.print("\nCe n'est pas une série valide, saisissez votre choix : ");
				}while(serieChoisie > 4 || serieChoisie < 1);
				player.ramasseSerie(this.getSerie(serieChoisie - 1));
				this.getSerie(serieChoisie - 1).poser(carteJouees.get(player));
			}
		}
		carteJouees.clear();
	}
	//Fonction servant à réinitialiser la partie
	public void reinitialiser() {
		for (int i = 0; i < NB_SERIES; ++i)
			listeS.get(i).reinitialiser();
	}
	
	//Setteur
	public void poseCarte(Joueur j, Carte c) {
		this.carteJouees.put(j, c);
		j.poserCarte(c);
	}
	
	//Getteurs
	public Serie getSerie(int i) {
		return listeS.get(i);
	}
	public Carte getCarteJouee(Joueur j) {
		return carteJouees.get(j);
	}
	
	//Fonction toString
	public String toString() {
		String s = "";
		for (int i = 0; i < NB_SERIES; ++i) {
			s = s + listeS.get(i).toString();
			if (i < NB_SERIES - 1)
				s = s + "\n";
		}
		return s;
	}
}
