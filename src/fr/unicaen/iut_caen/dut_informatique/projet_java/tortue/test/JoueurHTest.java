package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Carte;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.JoueurH;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Tuile;

public class JoueurHTest {
	public static void main(String[] args) {
		
		JoueurH joueur=new JoueurH("damdam");
		
		joueur.setTuile(new Tuile("rouge"));
		joueur.addCarte(new Carte("rouge",2));
		joueur.addCarte(new Carte("rouge",1));
		joueur.addCarte(new Carte("rouge",1));
		joueur.addCarte(new Carte("rouge",1));
		joueur.addCarte(new Carte("rouge",1));

		System.out.println(joueur.jouer());
	}
}