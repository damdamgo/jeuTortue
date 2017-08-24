package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Joueur;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Pioche;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Plateau;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Sauvegarde;

public class SauvegardeTest {

	public static void main(String[] args) {
		
		int indice = 0;
		Sauvegarde save = new Sauvegarde();
		save.recupererFichier();
		indice = save.afficherFichier(indice);
		save.choisirNom();
		Pioche pioche = new Pioche();
		pioche.ajouterCouleur("jaune");
		try {
			save.sauvegarder(new Plateau(), new LinkedList<Joueur>(), new LinkedList<String>(),pioche, 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
