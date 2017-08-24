package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Carte;

public class CarteTest {
	
	public static void main(String[] args) {
		String co = "Jaune";
		Carte carte = new Carte(co.substring(0,2),-1);
		System.out.println(carte);
		carte.setAction(4);
		System.out.println(carte);
		System.out.println(carte.getCouleur());
	}
}
