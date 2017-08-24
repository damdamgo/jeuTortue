package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;

import java.io.IOException;

import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.HistoriqueRecuperer;

public class HistoriqueRecupererTest {
	public static void main(String[] args) {
		int indice = 0;
		HistoriqueRecuperer histo = new HistoriqueRecuperer();
		histo.recupererFichier();
		indice = histo.afficherFichier(indice);
		try {
			histo.choisirPartie();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
