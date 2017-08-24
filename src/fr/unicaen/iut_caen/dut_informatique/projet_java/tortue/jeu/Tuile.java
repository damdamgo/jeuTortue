/*
 * Nom de classe : 	Tuile
 *
 * Description   : 	Elle permet de definir une tuile dans le jeu
 * 					Elle est abstract et implemente Serializable pour la sauvegarde
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
 * @see Serializable
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class Tuile extends Couleur implements Serializable {
	
	/**
	 * Clé de hachage SHA qui identifie de manière unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est sérialisée, de la marquer 
	 *  	 avec une somme de contrôle (checksum) pour que lors de la 
	 *  	 désérialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu’il manipule
	 */
	private static final long serialVersionUID = 8L;
	
	/* Constructeur */

	public Tuile(String couleur) {
		super(couleur);
	}

	
	/* toString */
	
	@Override
	public String toString() {
		return "Tuile "+super.toString();
	}
}