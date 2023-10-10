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
		return valeur.toString()+" de "+couleur.toString();
	}
	
	public int compareTo(Carte c) {
		return valeur.compareTo(c.valeur);
	}
	
}
