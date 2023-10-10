package bataille;

public class Carte {

	private Valeur valeur;
	private Couleur couleur;
	
	public Carte() {
		Valeur[] valeurs = Valeur.values();
		this.valeur = randomElement(valeurs);
		Couleur[] couleurs = Couleur.values();
		this.couleur = randomElement(couleurs);
	}
	
	private Valeur randomElement(Valeur[] valeurs) {
		return valeurs[(int)Math.floor(Math.random()*valeurs.length)];
	}
	private Couleur randomElement(Couleur[] couleurs) {
		return couleurs[(int)Math.floor(Math.random()*couleurs.length)];
	}
	
	public Carte(Valeur valeur, Couleur couleur) {
		super();
		this.valeur = valeur;
		this.couleur = couleur;
	}

	public Valeur getValeur() {
		return valeur;
	}

	public String toString() {
		String carte = "";
		switch(valeur) {
			case DEUX : carte = "2"; break;
			case TROIS : carte = "3"; break;
			case QUATRE : carte = "4"; break;
			case CINQ : carte = "5"; break;
			case SIX : carte = "6"; break;
			case SEPT : carte = "7"; break;
			case HUIT : carte = "8"; break;
			case NEUF : carte = "9"; break;
			case DIX : carte = "10"; break;
			case VALET : carte = "V"; break;
			case DAME : carte = "D"; break;
			case ROI : carte = "R"; break;
			case AS : carte = "A"; break;
		}
		switch(couleur) {
			case PIQUE : carte += "\u2660"; break;
			case TREFLE : carte += "\u2663"; break;
			case CARREAU : carte += "\u2662"; break;
			case COEUR : carte += "\u2661"; break;
		}
		return carte;
	}
	
	public int compareTo(Carte c) {
		return valeur.compareTo(c.valeur);
	}
	
}
