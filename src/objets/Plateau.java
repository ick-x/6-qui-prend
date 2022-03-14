package objets;
import java.util.*;

import appli.*;

public class Plateau {
	public final int NB_SERIES = 4;
	
	//Cr�ation d'une ArrayList repr�sentant l'ensemble des s�ries sur la table
	private ArrayList<Serie> listeS = new ArrayList<Serie>(NB_SERIES);
	//Cr�ation d'une HashMap repr�sentant les cartes pos�es par chaque joueur � chaque tour
	private LinkedHashMap<Joueur, Carte> carteJouees = new LinkedHashMap<Joueur, Carte>();
	
	//Initialisation d'un plateau avec 4 s�ries
	public Plateau() {
		for (int i = 0; i < NB_SERIES; ++i)
			listeS.add(new Serie());
	}
	
	//Fonction permettant de trier une LinkedHashMap
	public LinkedHashMap<Joueur, Carte> sortHash(LinkedHashMap<Joueur, Carte> listeNonTriee){
		LinkedHashMap<Joueur, Carte> listeTriee = new LinkedHashMap<Joueur, Carte>();
		boolean plusPetit;
		while (listeNonTriee.size() > 0) {
			for (Map.Entry<Joueur, Carte> player:listeNonTriee.entrySet()) {
				plusPetit = true;
				for (Map.Entry<Joueur, Carte> playerBis:listeNonTriee.entrySet()) {
					if (player.getValue().getNum() < playerBis.getValue().getNum())
						plusPetit = false;
				}
				if (plusPetit) {
					listeTriee.put(player.getKey(), player.getValue());
					listeNonTriee.remove(player.getKey());
				}
			}
		}
		return listeTriee;  
	}
	//Fonction permettant de placer les cartes jou�es par les joueurs sur les s�ries
	public void placerCartes() {
		boolean placee;
		int serieChoisie;
		int ecart;
		Serie aux;
		
		carteJouees = sortHash(carteJouees);
		//Affichage initial
		String str = "Les cartes ";
		ecart = 0;
		for (Joueur player: carteJouees.keySet()) {
			ecart++;
			if (ecart < carteJouees.size() - 1) 
				str = str + carteJouees.get(player).getNum() + " (" + player.getNom()+ "), ";
			else 
				if(ecart == carteJouees.size() - 1)
					str = str + carteJouees.get(player).getNum() + " (" + player.getNom()+ ") et ";
				else
					str = str + carteJouees.get(player).getNum() + " (" + player.getNom() + ") ";
		}
		str = str + "vont �tre pos�es.";
		System.out.println(str);
		
		for (Joueur player: carteJouees.keySet()) {
			placee = false;
			aux = null;
			ecart = 104;
			player.setTetesRamasse(0);
			for (Serie s: listeS)
				if (carteJouees.get(player).getNum() - s.getLast().getNum() < ecart && carteJouees.get(player).getNum() - s.getLast().getNum() > 0) {
					aux = s;
					ecart = carteJouees.get(player).getNum() - s.getLast().getNum();
				}
			if (aux != null) {
				placee = true;
				if (aux.getNbCartes() == aux.MAX_SERIE) {
					ecart = player.getNbTetes();
					player.ramasseSerie(aux);
					player.setTetesRamasse(player.getNbTetes() - ecart);
					aux.poser(carteJouees.get(player));
				}else
					aux.poser(carteJouees.get(player));
			}
			//Impossible de placer la carte, le joueur choisit une s�rie � ramasser
			if (!placee) {
				ecart = player.getNbTetes();
				System.out.println("Pour poser la carte " + carteJouees.get(player).getNum() + ", " + player.getNom() + " doit choisir la s�rie qu'il va ramasser.");
				System.out.println(this.toString());
				System.out.println("Saisissez votre choix : ");
				do {
					serieChoisie = Integer.parseInt(Application.scan.nextLine());
					if (serieChoisie > 4 || serieChoisie < 1)
						System.out.print("\nCe n'est pas une s�rie valide, saisissez votre choix : ");
				}while(serieChoisie > 4 || serieChoisie < 1);
				player.ramasseSerie(this.getSerie(serieChoisie - 1));
				this.getSerie(serieChoisie - 1).poser(carteJouees.get(player));
				player.setTetesRamasse(player.getNbTetes() - ecart);
			}
		}
		str = "Les cartes ";
		ecart = 0;
		for (Joueur player: carteJouees.keySet()) {
			ecart++;
			if (ecart < carteJouees.size() - 1) 
				str = str + carteJouees.get(player).getNum() + " (" + player.getNom()+ "), ";
			else 
				if(ecart == carteJouees.size() - 1)
					str = str + carteJouees.get(player).getNum() + " (" + player.getNom()+ ") et ";
				else
					str = str + carteJouees.get(player).getNum() + " (" + player.getNom() + ") ";
		}
		str = str + "ont �t� pos�es.";
		System.out.println(str);
		boolean tetesRamassees = false;
		for (Joueur player : carteJouees.keySet()) {
			if (player.getTetesRamasses() > 0) {
				tetesRamassees = true;
				System.out.print(player.getNom() + " a rammass� "+ (player.getTetesRamasses()));
				if (player.getTetesRamasses()> 1)
					System.out.println(" t�tes de boeufs.");
				else
					System.out.println(" t�te de boeufs.");
			}
		}
		if (!tetesRamassees)
			System.out.println("Aucun joueur ne ramasse de t�te de boeufs.");
		carteJouees.clear();
	}
	//Fonction servant � r�initialiser la partie
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
