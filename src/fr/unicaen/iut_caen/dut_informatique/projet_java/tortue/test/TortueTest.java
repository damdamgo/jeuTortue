package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Tortue;

public class TortueTest {
	public static void main(String[] args) {
		
		Tortue couleur = new Tortue("jaune");
		System.out.println(couleur.afficherTortue(2));
		couleur.setCouleur("rouge");
		System.out.println(couleur.afficherTortue(2));
	}
}
