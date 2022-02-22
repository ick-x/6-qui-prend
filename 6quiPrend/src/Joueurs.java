import java.util.ArrayList;
import java.util.Scanner;

public class Joueurs {
    private int nbJoueurs;
    public static final int MAX_JOUEURS = 10;

    //création d'une ArrayList de joueurs
    private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>(0);

    public Joueurs() {
    	System.out.println("Veuillez saisir la liste de joueurs :");
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;
        
        do {
        	String nomJ = sc.nextLine();
        	if (nomJ.isEmpty() || listeJoueurs.size() > MAX_JOUEURS)
        		continuer = false;
        	else {
        		Joueur j = new Joueur(nomJ);
            	listeJoueurs.add(j);
            	nbJoueurs = listeJoueurs.size();
        	}
        }while(continuer);
        
        sc.close();
    }
    
    public Joueur getJoueur(int i) {
    	return listeJoueurs.get(i);   					
    }
    
    public int getNbJoueurs() {
    	return nbJoueurs;
    }
    
    public String toString() {
    	String s = "Nombre de joueurs : "  + this.nbJoueurs + "\n";
    	s = s + "Liste joueurs : \n";
    	for (Joueur j : listeJoueurs)
    		s = s + j.getNom() + System.lineSeparator();
    	return s;
    }
}