package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.HistoriqueSauvegarde;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.JoueurO;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Plateau;

public class HistoriqueSauvegardeTest {
	public static void main(String[] args) {
		
		File fichier = new File("parties/test.txt");
		try {
			fichier.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HistoriqueSauvegarde histo = new HistoriqueSauvegarde();
		histo.deplacerFichierPartie(fichier);
		try {
			histo.sauvegarderFin(2, new JoueurO("damien"), new Plateau(), "test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
