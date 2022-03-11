package objets;
import java.util.ArrayList;
import java.io.*;

public class Joueurs {
    private int nbJoueurs;
    public static final int MAX_JOUEURS = 10;

    //Création d'une ArrayList représentant l'ensemble des joueurs
    private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
    
    //Initialisation de la liste de joueurs à partir d'un fichier texte
    public Joueurs()
    {
    	//lecture du fichier texte 
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
    
    /*
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
    	
    } */
    	
    	
    
   
    
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