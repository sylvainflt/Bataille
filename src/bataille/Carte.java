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

	
	public String toString2() {
		String carte = "";
		switch(couleur) {
			case PIQUE : 
				switch(valeur) {
					case DEUX : carte = "\uD83C\uDCA2"; break;
					case TROIS : carte = "\uD83C\uDCA3"; break;
					case QUATRE : carte = "\uD83C\uDCA4"; break;
					case CINQ : carte = "\uD83C\uDCA5"; break;
					case SIX : carte = "\uD83C\uDCA6"; break;
					case SEPT : carte = "\uD83C\uDCA7"; break;
					case HUIT : carte = "\uD83C\uDCA8"; break;
					case NEUF : carte = "\uD83C\uDCA9"; break;
					case DIX : carte = "\uD83C\uDCAA"; break;
					case VALET : carte = "\uD83C\uDCAB"; break;
					case DAME : carte = "\uD83C\uDCAD"; break;
					case ROI : carte = "\uD83C\uDCAE"; break;
					case AS : carte = "\uD83C\uDCA1"; break;
				}
				break;
			case TREFLE : 
				switch(valeur) {
					case DEUX : carte = "\uD83C\uDCD2"; break;
					case TROIS : carte = "\uD83C\uDCD3"; break;
					case QUATRE : carte = "\uD83C\uDCD4"; break;
					case CINQ : carte = "\uD83C\uDCD5"; break;
					case SIX : carte = "\uD83C\uDCD6"; break;
					case SEPT : carte = "\uD83C\uDCD7"; break;
					case HUIT : carte = "\uD83C\uDCD8"; break;
					case NEUF : carte = "\uD83C\uDCD9"; break;
					case DIX : carte = "\uD83C\uDCDA"; break;
					case VALET : carte = "\uD83C\uDCDB"; break;
					case DAME : carte = "\uD83C\uDCDD"; break;
					case ROI : carte = "\uD83C\uDCDE"; break;
					case AS : carte = "\uD83C\uDCD1"; break;
				}
				break;
			case CARREAU : 
				switch(valeur) {
					case DEUX : carte = "\uD83C\uDCC2"; break;
					case TROIS : carte = "\uD83C\uDCC3"; break;
					case QUATRE : carte = "\uD83C\uDCC4"; break;
					case CINQ : carte = "\uD83C\uDCC5"; break;
					case SIX : carte = "\uD83C\uDCC6"; break;
					case SEPT : carte = "\uD83C\uDCC7"; break;
					case HUIT : carte = "\uD83C\uDCC8"; break;
					case NEUF : carte = "\uD83C\uDCC9"; break;
					case DIX : carte = "\uD83C\uDCCA"; break;
					case VALET : carte = "\uD83C\uDCCB"; break;
					case DAME : carte = "\uD83C\uDCCD"; break;
					case ROI : carte = "\uD83C\uDCCE"; break;
					case AS : carte = "\uD83C\uDCC1"; break;
				}
				break;
			case COEUR : 
				switch(valeur) {
					case DEUX : carte = "\uD83C\uDCB2"; break;
					case TROIS : carte = "\uD83C\uDCB3"; break;
					case QUATRE : carte = "\uD83C\uDCB4"; break;
					case CINQ : carte = "\uD83C\uDCB5"; break;
					case SIX : carte = "\uD83C\uDCB6"; break;
					case SEPT : carte = "\uD83C\uDCB7"; break;
					case HUIT : carte = "\uD83C\uDCB8"; break;
					case NEUF : carte = "\uD83C\uDCB9"; break;
					case DIX : carte = "\uD83C\uDCBA"; break;
					case VALET : carte = "\uD83C\uDCBB"; break;
					case DAME : carte = "\uD83C\uDCBD"; break;
					case ROI : carte = "\uD83C\uDCBE"; break;
					case AS : carte = "\uD83C\uDCB1"; break;
				}
				break;
		}				
		return carte;
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
