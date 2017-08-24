package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;


import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Pioche;


public class PiocheTest {
public static void main(String[] args) {
		
		String couleur[] = {"Jaune","Verte","Rouge","Bleue ","Violette "};
		
		Pioche p = new Pioche();
		for(int i = 0; i < couleur.length;i++)
		{
			p.ajouterCouleur(couleur[i]);
		}
		p.ajouterNeutre();
        System.out.println(p.getJeuxCarte()); 
        p.melanger();
        System.out.println(p.getJeuxCarte());
    }
}
