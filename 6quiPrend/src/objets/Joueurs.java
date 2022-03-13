package objets;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Joueurs {
    private int nbJoueurs;
    public static final int MAX_JOUEURS = 10;

    //Création d'une ArrayList représentant l'ensemble des joueurs
    private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
    
  //Initialisation de la liste de joueurs à partir d'un fichier texte
    public Joueurs() {
    	try {
    		String fichier ="config.txt";
    		InputStream input=new FileInputStream(fichier); 
    		InputStreamReader reader=new InputStreamReader(input);
    		BufferedReader buffer=new BufferedReader(reader);
    		String ligne;
			while ((ligne=buffer.readLine())!=null) {
				Joueur j = new Joueur(ligne);
            	listeJoueurs.add(j);
            	nbJoueurs = listeJoueurs.size();
			}
    	buffer.close(); 
    	}  
    	catch (Exception e){
    	System.out.println(e.toString());
    	}
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