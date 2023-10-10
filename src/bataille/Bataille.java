package bataille;

public class Bataille {

	private static int pointsJoueur1 = 0;
	
	private static int pointsJoueur2 = 0;
	
	private static void compare(Carte c1, Carte c2) {
		int compare = c1.compareTo(c2);
		if(compare < 0) {
			System.out.println(c1.toString()+" est inférieure à "+c2.toString());
			pointsJoueur2 += 2;
		}else if(compare == 0) {
			System.out.println(c1.toString()+" est égale à "+c2.toString());
			pointsJoueur1++;
			pointsJoueur2++;
		}else {
			System.out.println(c1.toString()+" est supérieure à "+c2.toString());
			pointsJoueur1 += 2;
		}
	}
	
	
	
	public static void main(String[] args) {

		/*Carte c1 = new Carte();
		Carte c2 = new Carte();		
		compare(c1, c2);*/
		Paquet paquet = new Paquet();
		paquet.melanger();
		paquet.melanger();
		paquet.melanger();		
		System.out.println(paquet.toString());
		
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
