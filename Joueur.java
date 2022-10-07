
public class Joueur {

	/** Déclaration des attributs*/
	Bataille sesCartes;
	
	int scoreJoueur;
	
	String nom;
	/** Déclaration du constructeur du joueur*/
	Joueur(String n){
		sesCartes= new Bataille();
		scoreJoueur=0;
		nom=n;
	}
	
	/** Méthode permettant au joueur de prendre une carte (elle sera utilisée pour la création des jeux de cartes de chaque joueur*/
	public void prendreCarte (Carte c) {
		sesCartes.ajoute(c);
	}
	
	/** Méthode permettant au joueur de ramasser les cartes sur le plateau lorsqu'il gagne */
	public void ramasse(Carte c) {
		sesCartes.ajouteEnDessous(c);
	}
	
	/** Méthode permettant de vérifier si le joueur a toujours des cartes dans son jeu*/
	public boolean carteEnMains() {
		return !sesCartes.plusDeCarte();
	}
	
	/** Méthode permettant au joueur de prendre la carte sur le dessus de son jeu pour qu'elle puisse être comparée avec celle de son adversaire*/
	public Carte joue() {
		return sesCartes.pioche();
	}
	
	/** Méthode permettant d'augmenter le score du joueur qui gagne*/
	public void gagne (int n) {
		scoreJoueur+=n;
	}
	
	/** Récupération du score du joueur*/
	public int getScore () {
		return scoreJoueur;
	}
	
	public String toString() {
		return "\nJoueur "+nom+
		"\nSon score : "+scoreJoueur+"\n";
	}
	
	
}
