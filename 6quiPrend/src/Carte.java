
public class Carte {
	private int num;
	private int nbTete = 1;
	
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
	
	public int getNum() {
		return this.num;
	}
	
	public int getTete() {
		return this.nbTete;
	}
	public String toString() {
		return Integer.toString(getNum());
	}
}
