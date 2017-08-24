package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Tuile;

public class TuileTest {
	public static void main(String[] args) {
		
		Tuile couleur = new Tuile("jaune");
		System.out.println(couleur);
		couleur.setCouleur("rouge");
		System.out.println(couleur);
	}
}
