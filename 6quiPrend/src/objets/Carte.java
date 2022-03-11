package objets;

public class Carte {
	private int num;
	private int nbTete = 1;
	
	//Initialisation de la valeur et calcul du nombre de tête de boeuf
	public Carte(int numCarte) {
		this.num = numCarte;
		
		//Définition nombre de têtes de boeuf
		if (numCarte % 10 == 0)
			this.nbTete += 2;
		if (numCarte % 10 == 5)
			this.nbTete++;
		if (numCarte % 11 == 0) {
			this.nbTete += 4;
			if (numCarte == 55)
				this.nbTete++;
		}
	}
	
	//Getteurs
	public int getNum() {
		return this.num;
	}
	public int getTete() {
		return this.nbTete;
	}
	
	//Fonction toString
	public String toString() {
		String s = Integer.toString(getNum());
		if (this.getTete() > 1)
			s = s + " (" + this.getTete() + ")";
		return s;
	}
}
