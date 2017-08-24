/*
 * Nom de classe : 	Couleur
 *
 * Description   : 	Elle permet de definir les classes tortue et tuile qui possedent les memes attributs
 *					Elle est abstraite et implemente Serializable pour la sauvegarde
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.Serializable;

/**
 * Permet de definir les classes {@link Tortue} et {@link Tuile} qui possedent les memes attributs
 * 
 * @version 1.0
 *
 * @see Serializable
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public abstract class Couleur implements Serializable {

	/**
	 * Clé de hachage SHA qui identifie de manière unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est sérialisée, de la marquer 
	 *  	 avec une somme de contrôle (checksum) pour que lors de la 
	 *  	 désérialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu’il manipule
	 */
	private static final long serialVersionUID = 3L;

	/**
	 * Permet de sauvegarder la couleur de la tortue ou de la tuile
	 */
	private String couleur;

	/* Constructeur */

	public Couleur(String couleur) {
		this.couleur=couleur;
	}

	/* getter */

	public String getCouleur() {
		return couleur;
	}

	/* setter */

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/* toString */

	public String toString() {
		return couleur;
	}
}

