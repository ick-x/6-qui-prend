package objets;
import java.util.ArrayList;
import java.util.Collections;

public class Cartes {
	public final int NB_CARTES = 104;
	public final int INIT_CARTES = 10;
	
	//Création d'une ArrayList représentant le paquet de cartes
	private ArrayList<Carte> paquet = new ArrayList<Carte>();
	
	//Initialisation et mélange du paquet de cartes
	public Cartes() {
		for (int i = 1; i <= NB_CARTES; ++i) {
			Carte c = new Carte(i);
			paquet.add(c);
		}
		Collections.shuffle(paquet);
	}
	
	//Fonction permettant de réinitialiser le paquet de cartes
	public void reinitialiser() {
		paquet.clear();
		for (int i = 1; i <= NB_CARTES; ++i) {
			Carte c = new Carte(i);
			paquet.add(c);
		}
		Collections.shuffle(paquet);
	}
	//Fonction retirant et retournant la carte au sommet du paquet
	public Carte prendreCarte() {
		assert(!paquet.isEmpty());
		Carte aux = paquet.get(0);
		paquet.remove(0);
		return aux;
	}
	
	//Getteur
	public int getTaille() {
		return paquet.size();
	}
	
	//Fonction toString
	public String toString() {
		String s = "";
		for (Carte c: paquet)
			s = s + c.toString() + " ";
		return s;
	}
}
