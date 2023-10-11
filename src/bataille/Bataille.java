package bataille;

import java.util.Scanner;

public class Bataille {

	private static int pointsJoueur1 = 0;
	
	private static int pointsJoueur2 = 0;
	
	private static Paquet paquet = new Paquet();
	
	private static Joueur joueur1;
	
	private static Joueur joueur2;
	
	private static int compare(Carte[] pli) {
		
		Carte c1 = pli[0];
		Carte c2 = pli[1];
		int compare = c1.compareTo(c2);
		
		if(compare < 0) {
			
			System.out.println(joueur1.getNbCartes()+" --- "+c1.toString()+" est inférieure à "+c2.toString()+" --- "+joueur2.getNbCartes());
			pointsJoueur2 += 2;			
			return -1;			
			
		}else if(compare == 0) {
			
			System.out.println(joueur1.getNbCartes()+" --- "+c1.toString()+" est égale à "+c2.toString()+" --- "+joueur2.getNbCartes());
			pointsJoueur1++;
			pointsJoueur2++;					
			return 0;
			
		}else {
			
			System.out.println(joueur1.getNbCartes()+" --- "+c1.toString()+" est supérieure à "+c2.toString()+" --- "+joueur2.getNbCartes());
			pointsJoueur1 += 2;			
			return 1;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		paquet.melanger();
		paquet.melanger();
		paquet.melanger();		
		
		joueur1 = new Joueur(paquet.premiereMoitie());
		joueur2 = new Joueur(paquet.secondeMoitie());
		
		Scanner sc = new Scanner(System.in);
		jeu(sc);	
	}
	
	private static void jeu(Scanner sc) {
		
		joueur1.affichePaquet();
		joueur2.affichePaquet();
				
		System.out.println("taper 1 pour piocher, 0 pour afficher les paquets");
		int choix  = sc.nextInt();
		
		while(joueur1.aDesCartes() && joueur2.aDesCartes()) {
						
			if(choix == 1) {                          
				
				// on pioche
				piocher();
				
				if(!joueur1.aDesCartes()) {
					System.out.println("joueur 2 a gagné !");
					break;
				}else if(!joueur2.aDesCartes()) {
					System.out.println("joueur 1 a gagné !");
					break;
				}			
				
			}else if(choix == 0){ 
				// on affiche les paquets  
				joueur1.affichePaquet();
				joueur2.affichePaquet();
			}
			System.out.println("taper 1 pour piocher, 0 pour afficher les paquets");
			choix  = sc.nextInt();
		}
		
	}
	
	private static void piocher() {
			
		Carte c1 = joueur1.pioche();
		Carte c2 = joueur2.pioche();
		Carte[] pli = new Carte[2];
		pli[0] = c1;
		pli[1] = c2;
		
		int compare = compare(pli);
		
		if(compare == -1) {
			// carte 1 inférieure à carte 2
			joueur2.recupere(pli);
		}else if(compare == 0) {
			// carte 1 égale à carte 2
			
			
			
		}else if(compare == 1) {
			// carte 1 supérieure à carte 2
			joueur1.recupere(pli);
		}
		
	}
	
	private static void jeuVidePaquet() {
		Carte c1 = paquet.piocher();
		Carte c2 = paquet.piocher();
		while (c1 != null && c2 != null) {
			Carte[] pli = new Carte[2];
			pli[0] = c1;
			pli[1] = c2;
			compare(pli);
			c1 = paquet.piocher();
			c2 = paquet.piocher();
		}		
		System.out.println("points j1 "+pointsJoueur1+" points j2 "+pointsJoueur2);
	}
	
	

}
