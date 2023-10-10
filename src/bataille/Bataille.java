package bataille;

public class Bataille {

	private static int pointsJoueur1 = 0;
	
	private static int pointsJoueur2 = 0;
	
	private static Paquet paquet = new Paquet();
	
	private static Joueur joueur1;
	
	private static Joueur joueur2;
	
	private static void compare(Carte c1, Carte c2) {
		int compare = c1.compareTo(c2);
		Carte[] pli = new Carte[2];
		pli[0] = c1;
		pli[1] = c2;
		if(compare < 0) {
			System.out.println(c1.toString()+" est inférieure à "+c2.toString());
			pointsJoueur2 += 2;
			
			joueur2.recupere(pli);
			
		}else if(compare == 0) {
			System.out.println(c1.toString()+" est égale à "+c2.toString());
			pointsJoueur1++;
			pointsJoueur2++;
		}else {
			System.out.println(c1.toString()+" est supérieure à "+c2.toString());
			pointsJoueur1 += 2;
			
			joueur1.recupere(pli);
		}
	}
	
	
	
	public static void main(String[] args) {

		/*Carte c1 = new Carte();
		Carte c2 = new Carte();		
		compare(c1, c2);*/
		paquet.melanger();
		paquet.melanger();
		paquet.melanger();		
		System.out.println(paquet.toString());
		joueur1 = new Joueur(paquet.premiereMoitie());
		joueur2 = new Joueur(paquet.secondeMoitie());
		//jeuVidePaquet();
		jeu();	
	}
	
	private static void jeu() {
		joueur1.affichePaquet();
		joueur2.affichePaquet();
		while(joueur1.aDesCartes() || joueur2.aDesCartes()) {
			Carte c1 = joueur1.pioche();
			Carte c2 = joueur2.pioche();
			compare(c1,c2);
		}
	}
	
	private static void jeuVidePaquet() {
		Carte c1 = paquet.piocher();
		Carte c2 = paquet.piocher();
		while (c1 != null && c2 != null) {
			compare(c1,c2);
			c1 = paquet.piocher();
			c2 = paquet.piocher();
		}		
		System.out.println("points j1 "+pointsJoueur1+" points j2 "+pointsJoueur2);
	}
	
	

}
