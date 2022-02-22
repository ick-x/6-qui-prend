import java.util.ArrayList;

public class Serie {
	private int indice;
	private int nbCartes = 0;
	private ArrayList<Carte> ligne = new ArrayList<Carte>(0);
	private static int compteur = 0;
	
	//Initialisation d'une série avec un indice généré automatiquement
	public Serie() {
		indice = ++compteur;
	}
	
	//Méthode permettant de poser une nouvelle carte sur une série
	public void poser(Carte c) {
		ligne.add(c);
		nbCartes = ligne.size();
		if (nbCartes > 5)
			System.out.println("Six qui prend !"); //à compléter
	}
	
	public String toString() {
		String s = "Série n°" + this.indice + " : ";
		for (int i = 0; i < nbCartes; ++i) {
			s = s + ligne.get(i) + " ";
		}
		return s;
	}
}
