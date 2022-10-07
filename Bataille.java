
public class Bataille {
	
	/** Déclaration des attributs pour le bon déroulement de la bataille 
	 	1er attribut permettant de créer le jeu complet de 52 cartes puis le second pour le nombre de carte*/
	private Carte pile[];
	
	private int nombreCartes;
	
	/**Constructeur de la bataille*/
	Bataille(){
		pile=new Carte [52];
		nombreCartes=0;
	}
	
	/** Création du paquet de 52 cartes mélangé sous forme de tableau */
	 public void creationJeu() {
		int i;
		String c=null;
		for (i=0; i<52;i++) {
			if(i<13)c="Coeurs";
			if(i>=13 && i<26) c="Carreaux";
			if(i>=26 && i<39) c="Trefles";
			if(i>=39 && i<59) c="Piques";
			pile[i]=new Carte(i%13,c);
			nombreCartes++;
		}
		
		Carte jeuMelange;
		int j, k=0,l=0;
		for (j=0; j<500; j++) {
			k=(int) (Math.random()*nombreCartes);
			l=(int) (Math.random()*nombreCartes);
			jeuMelange=pile[k];
			pile[k]=pile[l];
			pile[l]=jeuMelange;
		}
	}
	 
	/** Méthode permettant au joueur de prendre la première carte*/
	public Carte pioche() {
		if(nombreCartes>0) {
			nombreCartes--;
			return pile[nombreCartes];
		}
		else
			return null;
	}
	
	/** Méthode permettant au joueur d'ajouter une carte dans son paquet*/
	public boolean ajoute(Carte c) {
		if(nombreCartes<26) {
			pile[nombreCartes]=c; 
			nombreCartes++;
			return true;
		}
		else
			return false;
	}
	
	/** Ajoute la carte à la fin du paquet (en dessous de sa pile de carte qui est face à lui)*/
	public boolean ajouteEnDessous(Carte c) {
		nombreCartes++;
		if(nombreCartes<51) {
			for(int j=nombreCartes; j>0; j--)
				pile[j]=pile[j-1];
			pile[0]=c;
			return true;
		}
		
		else
			return false;
	}
	
	/** Permet de savoir si le joueur a encore des cartes dans sa main ou non*/
	public boolean plusDeCarte() {
		if(nombreCartes==0)
			return true;
		else
			return false;
	}
	
	public static void main(String args[]) {
	
		/**Déclaration des joueurs et de l'environnement du jeu */
		Joueur covid= new Joueur("Covid");
		Joueur vaccin= new Joueur("Vaccin");
		
		Bataille tapisJeu= new Bataille();
		Bataille paquet= new Bataille();
		paquet.creationJeu();
		
		
		System.out.println("\n\n\n Bienvenue dans le super jeu de la bataille");
		
		/** Distribution des cartes aux 2 joueurs*/
		for(int k=0; k<26; k++) {
			covid.prendreCarte(paquet.pioche());
			vaccin.prendreCarte(paquet.pioche());
		}
		
		System.out.println(covid+"\n\n"+vaccin);
		
		/** Condition : tant que les 2 joueurs ont des cartes dans leur jeu*/
		while(covid.carteEnMains() && vaccin.carteEnMains()) {
			
			/** Chaque joueur pose une carte*/
			Carte carteCovid=covid.joue();
			Carte carteVaccin=vaccin.joue();
			tapisJeu.ajoute(carteCovid);
			tapisJeu.ajoute(carteVaccin);
			System.out.println("Covid:   "+carteCovid+"<-------->"+carteVaccin+"   :Vaccin");
			
			/** Différentes comparaisons des 2 cartes précédemment posées par les joueurs
			 	Si valeur inférieur ou supérieur le score du gagnant est incrémenté de 2,
			 	en revanche si il y a bataille, les joueurs reposent chacun une carte et il y a à nouveau une caparaison des cartes*/
			if(carteCovid.plusForte(carteVaccin)) {
				while(!tapisJeu.plusDeCarte())
					covid.ramasse(tapisJeu.pioche());
					covid.gagne(1);
					System.out.println("\n          Le Covid a remporté la bataille\n");
			}
			if(carteVaccin.plusForte(carteCovid)) {
				while(!tapisJeu.plusDeCarte())
					vaccin.ramasse(tapisJeu.pioche());
					vaccin.gagne(1);
					System.out.println("\n          Le Vaccin a remporté la bataille\n");
			}
			if(carteCovid.egale(carteVaccin)) {
				System.out.println("\n             BATAILLE\n");
				if(covid.carteEnMains() && vaccin.carteEnMains()) {
					tapisJeu.ajoute(covid.joue());
					tapisJeu.ajoute(vaccin.joue());
				}
				else break;
			}
		}
		
		/** Lorsqu'un joueur n'a plus de carte dans son jeu, la boucle while s'arrête et le jeu aussi
		 	comparaison des scores des jeu joueurs,
		 	Le joueur ayant le score le plus élevé remporte la partie */
		if (covid.scoreJoueur>vaccin.scoreJoueur) {
			System.out.println("Le Covid a remporté la GUERRE avec un score de "+covid.scoreJoueur+" face un score décevant de "+vaccin.scoreJoueur+" du Vaccin !");
		}
		else 
			System.out.println("Le Vaccin a remporté la GUERRE avec un score de "+vaccin.scoreJoueur+" face un score décevant  de "+covid.scoreJoueur+" du Covid !");
		
		System.exit(0);
	}
}
