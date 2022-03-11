package objets;
import java.util.ArrayList;

public class Serie {
	private int indice;
	private static int compteur = 0;
	private int nbCartes;
	private ArrayList<Carte> ligne = new ArrayList<Carte>();
	public final int MAX_SERIE = 5;
	
	//Initialisation d'une série
	public Serie() {
		this.indice = ++compteur;
		this.nbCartes = 0;
	}
	
	//Méthode permettant de poser une nouvelle carte sur une série
	public void poser(Carte c) {
		ligne.add(c);
		nbCartes = ligne.size();
	}
	//Méthode permettant de réinitialiser une série
	public void reinitialiser() {
		this.ligne.clear();
		this.nbCartes = 0;
	}
	
	//Getteur
	public Carte getLast() {
		return ligne.get(nbCartes - 1);
	}
	public Carte getCarte(int i) {
		return ligne.get(i);
	}
	public int getNbCartes() {
		return this.nbCartes;
	}
	
	//Fonction toString
	public String toString() {
		String s = "- Série n° " + this.indice + " : ";
		for (int i = 0; i < nbCartes; ++i)
			s = s + ligne.get(i) + " ";
		return s;
	}
}
