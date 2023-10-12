package bataille;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Bataille {

	private static int pointsJoueur1 = 0;
	
	private static int pointsJoueur2 = 0;
	
	private static Paquet paquet = new Paquet();
	
	private static Joueur joueur1;
	
	private static Joueur joueur2;
	
	private static Carte[] pli = new Carte[Valeur.values().length * Couleur.values().length];
	
	private static int nbCartesPli = 2;
	
	private static JLabel affichePli;
	
	private static JLabel afficheScore1;
	
	private static JLabel afficheScore2;
	
	private static JButton piocherBouton;
	
	private static boolean bataille = false;
	
	private static int compare(Carte[] pli, int nbCartesPli) {
		
		Carte c1 = pli[nbCartesPli-2];
		Carte c2 = pli[nbCartesPli-1];
		int compare = c1.compareTo(c2);
		
		afficheScore1.setText(joueur1.getNbCartes()+"");
		afficheScore2.setText(joueur2.getNbCartes()+"");
		
		if(compare < 0) {
			
			String texte = "("+joueur1.getNbCartes()+") *** "+c1+" < "+c2+" *** ("+joueur2.getNbCartes()+")";
			System.out.println(texte);
			affichePli.setText(c1.toString2()+" < "+c2.toString2());
			
			pointsJoueur2 += 2;			
			return -1;			
			
		}else if(compare == 0) {
			String texte = "("+joueur1.getNbCartes()+") *** "+c1+" = "+c2+" *** ("+joueur2.getNbCartes()+")";
			System.out.println(texte);
			affichePli.setText(c1.toString2()+" = "+c2.toString2());
			
			pointsJoueur1++;
			pointsJoueur2++;					
			return 0;
			
		}else {
			String texte = "("+joueur1.getNbCartes()+") *** "+c1+" > "+c2+" *** ("+joueur2.getNbCartes()+")";
			System.out.println(texte);
			affichePli.setText(c1.toString2()+" > "+c2.toString2());
			
			pointsJoueur1 += 2;			
			return 1;
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Bataille");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
		//paquet.melanger();
		paquet.melanger();
		paquet.melanger();		
		
		joueur1 = new Joueur(paquet.premiereMoitie());
		joueur2 = new Joueur(paquet.secondeMoitie());
		
		afficheScore1 = new JLabel();
		afficheScore1.setText(new Integer(joueur1.getNbCartes()).toString());
		frame.getContentPane().add(afficheScore1, BorderLayout.WEST);
		
		affichePli = new JLabel();
		affichePli.setFont(new Font("Serif", Font.PLAIN, 180));
		frame.getContentPane().add(affichePli, BorderLayout.CENTER);
				
		afficheScore2 = new JLabel();
		afficheScore2.setText(new Integer(joueur2.getNbCartes()).toString());
		frame.getContentPane().add(afficheScore2, BorderLayout.EAST);
		
		piocherBouton = new JButton("piocher");        
		piocherBouton.setActionCommand("piocher");
		piocherBouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if ("piocher".equals(e.getActionCommand())) {
					jeu();
		        }
				
			}
		});
		frame.getContentPane().add(piocherBouton, BorderLayout.PAGE_END);
		
			
		
		frame.pack();
        frame.setVisible(true);
        frame.setSize(1000, 600);
	}
	
	private static void jeu() {
		
		joueur1.affichePaquet();
		joueur2.affichePaquet();				
		
		int choix  = 1;
		
		if(joueur1.aDesCartes() && joueur2.aDesCartes()) {
						
			if(choix == 1) {                          
				// on pioche
				Carte c1 = joueur1.pioche();
				Carte c2 = joueur2.pioche();
				
				pli[nbCartesPli-2] = c1;
				pli[nbCartesPli-1] = c2;
				
				int compare = compare(pli, nbCartesPli);
												
				if(compare == -1) {
					// carte 1 inférieure à carte 2
					joueur2.recupere(pli, nbCartesPli);
					if(bataille) {
						nbCartesPli = 2;
						bataille = false;
					}
				}else if(compare == 0) {
					// carte 1 égale à carte 2
					
					bataille = true;
					// on pioche 2 cartes qu'on ajoute au pli
					Carte c3 = joueur1.pioche();
					Carte c4 = joueur2.pioche();
					nbCartesPli += 2;
					pli[nbCartesPli-2] = c3;
					pli[nbCartesPli-1] = c4;
					// on ajoute 2 place pour le prochain tirage
					nbCartesPli += 2;
					
				}else if(compare == 1) {
					// carte 1 supérieure à carte 2
					joueur1.recupere(pli, nbCartesPli);
					if(bataille) {
						nbCartesPli = 2;
						bataille = false;
					}
				}
				
				if(!joueur1.aDesCartes()) {
					System.out.println("joueur 2 a gagné !");
					//break;
				}else if(!joueur2.aDesCartes()) {
					System.out.println("joueur 1 a gagné !");
					//break;
				}			
				
			}else if(choix == 0){ 
				// on affiche les paquets  
				joueur1.affichePaquet();
				joueur2.affichePaquet();
			}
			
		}else {
			affichePli.setFont(new Font("Serif", Font.PLAIN, 26));
			if(!joueur1.aDesCartes()) {
				System.out.println("le joueur2 a gagné la partie !");
				affichePli.setText("le joueur2 a gagné la partie !");
			}else {
				System.out.println("le joueur1 a gagné la partie !");
				affichePli.setText("le joueur1 a gagné la partie !");
			}
		}
		
	}
	
	
	private static void jeuVidePaquet() {
		Carte c1 = paquet.piocher();
		Carte c2 = paquet.piocher();
		while (c1 != null && c2 != null) {
			Carte[] pli = new Carte[2];
			pli[0] = c1;
			pli[1] = c2;
			compare(pli, nbCartesPli);
			c1 = paquet.piocher();
			c2 = paquet.piocher();
		}		
		System.out.println("points j1 "+pointsJoueur1+" points j2 "+pointsJoueur2);
	}
	
	

}
