package bataille;

public class Paquet {

	private Carte[] cartes = new Carte[Valeur.values().length * Couleur.values().length];
	private int indiceTop = Valeur.values().length * Couleur.values().length -1;
	
	public Paquet() {
		Valeur[] valeurs = Valeur.values();
		Couleur[] couleurs = Couleur.values();
		int k = 0;
		for(int i=0; i < couleurs.length; i++) {
			for(int j=0; j < valeurs.length; j++) {
				cartes[k] = new Carte(valeurs[j], couleurs[i]);
				k++;
			}
		}
	}
	
	public String toString() {
		String cartesString = "";
		for(int i=0; i < cartes.length; i++) {
			cartesString += cartes[i].toString()+"\n";
		}
		return cartesString;
	}
	
	public void melanger() {		
		Carte[] paquet1 = new Carte[cartes.length/2];
		Carte[] paquet2 = new Carte[cartes.length/2];
		
		for(int i=0; i<cartes.length/2; i++) {
			paquet1[i] = cartes[i];
			//System.out.println(paquet1[i]);
		}
		//System.out.println("------------------------");
		for(int i=0,j=cartes.length/2; i<cartes.length/2; i++, j++) {
			paquet2[i] = cartes[j];
			//System.out.println(paquet2[i]);
		}
		//System.out.println("------------------------");
		int alea;
		int indPaquet1 = 0;
		int indPaquet2 = 0;
		for(int i=0; i<cartes.length; i++) {
			alea = (int)Math.round(Math.random());
			//System.out.println("alea : "+alea);
			if(alea == 0 && indPaquet1 < cartes.length/2) {
				cartes[i] = paquet1[indPaquet1];
				indPaquet1++;
			}else if(alea == 0 && indPaquet1 == cartes.length/2){
				cartes[i] = paquet2[indPaquet2];
				indPaquet2++;
			}
			else if(alea == 1 && indPaquet2 < cartes.length/2){
				cartes[i] = paquet2[indPaquet2];
				indPaquet2++;
			}
			else if(alea == 1 && indPaquet2 == cartes.length/2){
				cartes[i] = paquet1[indPaquet1];
				indPaquet1++;
			}
			
		}
	}
	
	public Carte piocher() {
		if(indiceTop>=0) {
			//System.out.println("--------pioche--------");
			Carte pioche = cartes[indiceTop];
			//System.out.println(pioche);
			indiceTop--;
			return pioche;
		}
		return null;
	}

	public void remettre() {		
		
		if(cartes.length>2) {
			Carte p1 = cartes[cartes.length-1];
			Carte p2 = cartes[cartes.length-2];
			for(int i=cartes.length-3; i>=0; i--) {				
				cartes[i+2] = cartes[i];				
			}
			cartes[1] = p1;
			cartes[0] = p2;
		}	
		indiceTop += 2;
	}
	
	public Carte[] premiereMoitie() {
				
			Carte[] paquet1 = new Carte[cartes.length/2];						
			for(int i=0; i<cartes.length/2; i++) {
				paquet1[i] = cartes[i];				
			}	
			return paquet1;
	}
	public Carte[] secondeMoitie() {
		
			Carte[] paquet2 = new Carte[cartes.length/2];				
			for(int i=0,j=cartes.length/2; i<cartes.length/2; i++, j++) {
				paquet2[i] = cartes[j];				
			}
			return paquet2;
	}
}
