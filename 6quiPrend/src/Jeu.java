
public class Jeu {
	public static void main(String[] args) {
		Joueurs listeJ = new Joueurs();
		Cartes deck = new Cartes();
		Plateau table = new Plateau();
		
		//Distribution cartes
		for (int i = 0; i < listeJ.getNbJoueurs(); ++i) {
			for (int j = 0; j < deck.cartesMainInit ; ++j)
				listeJ.getJoueur(i).prendreCarte(deck.prendreCarte());
			System.out.println(listeJ.getJoueur(i));
		}
		//Pose des cartes sur le plateau
		for (int i = 0; i < table.nbSeries ; ++i)
			table.getSerie(i).poser(deck.prendreCarte());
		System.out.println(table);
	}
}