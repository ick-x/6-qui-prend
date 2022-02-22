import java.util.ArrayList;

public class Plateau {
	public final int nbSeries = 4;
	private ArrayList<Serie> plat = new ArrayList<Serie>(4);
	
	//Initialisation d'un plateau avec 4 séries
	public Plateau() {
		for (int i = 0; i < nbSeries; ++i)
			plat.add(new Serie());
	}
	
	public Serie getSerie(int i) {
		return plat.get(i);
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < nbSeries; ++i)
			s = s + plat.get(i).toString() + "\n";
		return s;
	}
}
