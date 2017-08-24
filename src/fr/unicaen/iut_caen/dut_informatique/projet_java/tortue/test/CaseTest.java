package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.test;


import java.util.LinkedList;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Case;
import fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.Tortue;

public class CaseTest {
	public static void main(String[] args) {
		
		Case cases = new Case();
		LinkedList<Tortue> ajout_tortue=new LinkedList<Tortue>();
		ajout_tortue.add(new Tortue("jaune"));
		ajout_tortue.add(new Tortue("vert"));
		ajout_tortue.add(new Tortue("rouge"));
		ajout_tortue.add(new Tortue("violet"));
		cases.add(ajout_tortue);

		System.out.println(cases.estPresente("jaune"));
		System.out.println(cases.estPresente("rouge"));
		LinkedList<Tortue> to =cases.getTortues("violet");
		System.out.println(to.get(0).afficherTortue(2));
		System.out.println(cases.getPremiere().afficherTortue(2));
		cases.Monter("jaune", 1);
		System.out.println(cases.getPremiere().afficherTortue(2));
}
}
