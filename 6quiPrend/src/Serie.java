import java.util.ArrayList;

public class Serie {
	private int indice;
	private int nbCartes = 0;
	private ArrayList<Carte> ligne = new ArrayList<Carte>(0);
	private static int compteur = 0;
	
	//Initialisation d'une s�rie avec un indice g�n�r� automatiquement
	public Serie() {
		indice = ++compteur;
	}
	
	//M�thode permettant de poser une nouvelle carte sur une s�rie
	public void poser(Carte c) {
		ligne.add(c);
		nbCartes = ligne.size();
		if (nbCartes > 5)
			System.out.println("Six qui prend !"); //� compl�ter
	}
	
	public String toString() {
		String s = "S�rie n�" + this.indice + " : ";
		for (int i = 0; i < nbCartes; ++i) {
			s = s + ligne.get(i) + " ";
		}
		return s;
	}
}
