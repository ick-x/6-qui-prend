package objets;
import java.util.ArrayList;

import appli.*;

public class Joueurs {
    private int nbJoueurs;
    public static final int MAX_JOUEURS = 10;

    //Cr�ation d'une ArrayList repr�sentant l'ensemble des joueurs
    private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
    
    //Initialisation de la liste de joueurs � partir d'un fichier texte
    public Joueurs() {
    	System.out.println("Veuillez saisir la liste de joueurs :");
        boolean continuer = true;
        do {
        	String nomJ = Jeu.scan.nextLine();
        	if (nomJ.isEmpty() || listeJoueurs.size() > MAX_JOUEURS)
        		continuer = false;
        	else {
        		Joueur j = new Joueur(nomJ);
            	listeJoueurs.add(j);
            	nbJoueurs = listeJoueurs.size();
        	}
        }while(continuer);
    }
    
    //Getteurs
    public Joueur getJoueur(int i) {
    	return listeJoueurs.get(i);   					
    }
    public int getNbJoueurs() {
    	return nbJoueurs;
    }
    
    //Fonction toString
    public String toString() {
    	String s = "Nombre de joueurs : "  + this.nbJoueurs + "\n";
    	s = s + "Liste joueurs : \n";
    	for (Joueur j : listeJoueurs)
    		s = s + j.getNom() + System.lineSeparator();
    	return s;
    }
}