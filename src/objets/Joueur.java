package objets;
import java.util.ArrayList;
import appli.*;


public class Joueur {
    private String nom;
    private int teteBoeuf;
    private ArrayList<Carte> main = new ArrayList<Carte>();
    private int aRamasse;
    private Carte cartePosee;
    
    //Initialisation du nom du joueur
    public Joueur(String nomJoueur) {
        this.nom = nomJoueur;
        this.teteBoeuf = 0;
        this.aRamasse = 0;
    }
    
    //Fonction permettant d'ajouter une carte à la main du joueur
    public void prendreCarte(Carte c) {
    	this.main.add(c);
    }
    //Fonction permettant au joueur de poser une carte
    public Carte poserCarte(Carte c) {
    	assert(main.contains(c));
    	this.cartePosee = c;
    	this.main.remove(c);
    	return c;
    }
    //Fonction permettant de faire choisir une carte à un joueur dans sa main
  	public Carte choixCarte() {
  		boolean cartePresente = false;
  		Carte aux = this.getCarte(0);
  		System.out.println("Saisissez votre choix : ");
  		do {
  			String choix = Application.scan.nextLine();
  			for (int j = 0; j < this.carteRestantes(); ++j)
  				if (this.getCarte(j).getNum() == Integer.parseInt(choix)) {
  					cartePresente = true;
  					aux = this.getCarte(j);
  				}	
  			if (!cartePresente)
  				System.out.print("\nVous n'avez pas cette carte, saisissez votre choix : ");
  		}while (!cartePresente);
  		this.cartePosee = aux;
  		return aux;
  	}	
  	//Fonction permettant à un joueur de ramasser une série donnée
  	public void ramasseSerie(Serie s) {
  		for (int i = 0; i < s.getNbCartes(); ++i)
  			this.teteBoeuf += s.getCarte(i).getTete();
  		s.reinitialiser();
  	}
  	
  	//Setteur
  	public void setTetesRamasse(int i) {
  		this.aRamasse = i;
  	}
    
    //Getteurs
    public int carteRestantes() {
    	return main.size();
    }
    public String getNom() {
    	return this.nom;
    }
    public Carte getCarte(int i) {
    	return main.get(i);
    }
    public int getNbTetes() {
    	return this.teteBoeuf;
    }
    public int getTetesRamasses() {
    	return this.aRamasse;
    }
    
    //Fonction toString
	public String toString() {
    	String s = "- Vos cartes : ";
    	for (int i = 0; i < main.size(); ++i) { 
    		s = s + main.get(i).toString();
    		if (i < main.size() - 1)
    			s = s + ", ";
    	}
    	return s;
    }
}