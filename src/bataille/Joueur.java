package bataille;

public class Joueur {

	private Carte[] cartes = new Carte[Valeur.values().length * Couleur.values().length];
	private int nbCartes = 26;
	
	public Joueur(Carte[] paquet) {
		for(int i=0; i<paquet.length; i++) {
			cartes[i] = paquet[i];
		}
	}
	
	public Carte pioche() {
		Carte c = cartes[nbCartes-1];
		nbCartes--;
		return c;
	}
	
	public void recupere(Carte[] pli) {
		
		nbCartes += pli.length;
		
		for(int i=nbCartes-1; i>1; i--) {				
			cartes[i] = cartes[i-pli.length];				
		}
		
		for(int i=0; i<pli.length; i++) {
			cartes[i] = pli[i];
		}
		
	}
	
	public void affichePaquet() {
		for(int i=0; i<nbCartes; i++) {
			System.out.println(cartes[i]);
		}
	}
}
