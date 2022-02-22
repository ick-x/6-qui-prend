import java.util.ArrayList;
import java.util.Collections;

public class Cartes {
	public final int nbCartes = 104;
	public final int cartesMainInit = 10;
	private ArrayList<Carte> deck = new ArrayList<Carte>(nbCartes);
	
	//Initialisation et mélange du paquet de cartes
	public Cartes() {
		for (int i = 1; i <= nbCartes; ++i) {
			Carte c = new Carte(i);
			deck.add(c);
		}
		Collections.shuffle(deck);
	}
	
	public Carte prendreCarte() {
		assert(!deck.isEmpty());
		Carte aux = deck.get(0);
		deck.remove(0);
		return aux;
	}
	
	public String toString() {
		String s = "";
		for (Carte c: deck)
			s = s + c.toString();
		return s;
	}
}
