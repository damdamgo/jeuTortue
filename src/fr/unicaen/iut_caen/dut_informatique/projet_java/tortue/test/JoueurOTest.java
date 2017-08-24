package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Carte;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.JoueurO;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Tuile;

public class JoueurOTest {
	public static void main(String[] args) {
		
		JoueurO joueur=new JoueurO("damdam");

		joueur.setTuile(new Tuile("rouge"));

		joueur.addCarte(new Carte("rouge",2));
		joueur.addCarte(new Carte("rouge",1));
		joueur.addCarte(new Carte("rouge",1));
		joueur.addCarte(new Carte("rouge",1));
		joueur.addCarte(new Carte("rouge",1));
		System.out.println(joueur);
		System.out.println(joueur.jouer());
	}
}
