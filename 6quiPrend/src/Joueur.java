import java.util.ArrayList;

public class Joueur {
    private String nom;
    private ArrayList<Carte> main = new ArrayList<Carte>(0);
    
    public Joueur(String nomJoueur) {
        this.nom = nomJoueur;
    }
    public String getNom() {
    	return this.nom;
    }
    public void prendreCarte(Carte c) {
    	this.main.add(c);
    }
    public Carte poserCarte(Carte c) {
    	assert(main.contains(c));
    	this.main.remove(c);
    	return c;
    }
    /*
    public ArrayList<Carte> getMain(){
    	return main;
    }
    */
	public String toString() {
    	String s = "Main de " + this.nom + "\n";
    	for (int i = 0; i < main.size(); ++i) 
    		s = s + main.get(i).toString() + " ";
    	return s;
    }
}