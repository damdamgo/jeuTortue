/*
 * Nom de classe : 	Tortue
 *
 * Description   : 	Elle permet de definir une tortue dans le jeu
 *					Elle etend la classe couleur et implemente Serializable pour la sauvegarde
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.Serializable;

/**
 * Permet de gerer et definir le plateau du jeu
 * 
 * @version 1.0
 *
 * @see Couleur
 * @see Serializable
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class Tortue extends Couleur implements Serializable {

	/**
	 * Clé de hachage SHA qui identifie de manière unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est sérialisée, de la marquer 
	 *  	 avec une somme de contrôle (checksum) pour que lors de la 
	 *  	 désérialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu’il manipule
	 */
	private static final long serialVersionUID = 7L;
	
	/* Constructeur */

	public Tortue(String couleur) {
		super(couleur);
	}

	/* toString */

	@Override
	public String toString() {

		return null;
	}

	/**
	 * Permet d'afficher une tortue
	 * 
	 * @param x Partie de la tortue à retourner
	 * @return Retourne une partie de la tortue
	 */
	public String afficherTortue(int x) {
		String affTort[] = new String[10];
		String str = "";
		affTort[0] = "   ___    ";
		affTort[1] = " _/   \\ _ ";
		affTort[2] = "/  "+super.toString().substring(0, 2)+"  °_\\";
		affTort[3] = "\\_ __ _/  ";
		affTort[4] = "  O  O    ";

		str = affTort[x];
		return str;
	}

}