package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Carte;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Plateau;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Tortue;

import java.util.LinkedList;

public class PlateauTest {
	public static void main(String[] args) {
		
		Plateau plateau = new Plateau();
		
		
		LinkedList<Tortue> ajout_tortue=new LinkedList<Tortue>();
		ajout_tortue.add(new Tortue("jaune"));
		ajout_tortue.add(new Tortue("vert"));
		ajout_tortue.add(new Tortue("rouge"));
		ajout_tortue.add(new Tortue("violet"));
		
		plateau.initialiseJeu(ajout_tortue);
		System.out.println(plateau.toString(4));
		LinkedList<String> tab = new LinkedList<String>();
		tab.add("jaune");
		tab.add("vert");
		tab.add("rouge");
		tab.add("violet");
			
		plateau.deplacerTortues(new Carte("jaune",1),tab);
		System.out.println(plateau.toString(4));
		
		plateau.deplacerTortues(new Carte("neutre",3),tab);
		System.out.println(plateau.toString(4));
				
		
	}
}
