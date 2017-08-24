package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.RecupererPartie;

public class RecupererPartieTest {

	public static void main(String[] args) {
		int indice = 0;
		RecupererPartie partie = new RecupererPartie();
	
			try {
				partie.recupererFichier();
				indice = partie.afficherFichier(indice);
				partie.choisirPartie();
				System.out.println(partie.getJoueur());
				System.out.println(partie.getPioche());
				System.out.println(partie.getPlateau());
				System.out.println(partie.getIndexJoueur());
				System.out.println(partie.getColor());
				
			} catch (FileNotFoundException e) {
				System.out.println("Probleme fichier non trouvée");
			} catch (ClassNotFoundException e) {
				System.out.println("Probleme chargement");
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
