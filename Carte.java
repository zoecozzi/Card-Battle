public class Carte 
	{
	
	/** Déclaration des attributs couleur et valeur de la carte*/
		private int valeur;
		private String couleur;
		
		/** Constructeur de la carte*/
		Carte (int v, String c){
			valeur = v;
			couleur = c;
		}
		
		/** Permet d'accéder à la valeur de la carte */
		private int getValeur() {
			return valeur;
		}
		
		/** Permet d'accéder à la couleur de la carte*/
		String getCouleur() {
			return couleur;
		}
		
		/** Création de la carte sous forme de chaîne de caractère */
		public String toString() {
			String val=null;
			switch (valeur) {
			case 0: 
			case 1: 
			case 2: 
			case 3: 
			case 4: 
			case 5: 
			case 6: 
			case 7: 
			case 8: val=""+(valeur+2);
			break;
			case 9: val="Valet";
			break;
			case 10: val="Dame";
			break;
			case 11: val="Roi";
			case 12: val="As";
			break;
			}
			return val+" de "+couleur;
		}
		
		/** Comparaison de 2 cartes grâce à leur valeur.
		 	Avec le boolean, cela renvoi vrai si la carte est plus forte que la carte "ca" ou bien cela renvoi faux*/
		public boolean plusForte(Carte ca) {
			return valeur>ca.getValeur();
		}
		
		/** Permet de savoir si 2 cartes sont égales.
	 	Avec le boolean, cela renvoi vrai si la valeur de la carte est égale à la valeur de la carte "ca" ou bien cela renvoi faux*/
		public boolean egale(Carte ca) {
			return valeur==ca.getValeur();
		}
	}
	
	
	
