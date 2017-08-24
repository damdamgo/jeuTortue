/*
 * Nom de classe : 	Carte
 *
 * Description   : 	Elle permet la gestion de l'objet carte
 *					Elle implémente Serializable pour la sauvegarde
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.Serializable;

/**
 * Permet la gestion de l'objet carte
 * 
 * @version 1.0
 *
 * @see Serializable
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class Carte implements Serializable {

	/**
	 * Clé de hachage SHA qui identifie de manière unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est sérialisée, de la marquer 
	 *  	 avec une somme de contrôle (checksum) pour que lors de la 
	 *  	 désérialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu’il manipule
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Couleur de la carte
	 * 
	 * @see Carte#Carte(String, int)
	 * @see Carte#getCouleur()
	 * @see Carte#setCouleur(String)
	 */
	private String couleur;

	/**
	 * Action que peut effectuer la carte ('+', '-' ou encore '{@literal >}')
	 * 
	 * @see #Carte(String, int)
	 * @see #getAction()
	 * @see #setAction(int)
	 */
	private int action;

	/* Constructeur */

	public Carte(String couleur, int action) {
		this.couleur = couleur;
		this.action = action;
	}

	/* getters */

	public String getCouleur() {
		return couleur;
	}
	public int getAction() {
		return action;
	}

	/* setters */

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void setAction(int action) {
		this.action = action;
	}

	/* toString */

	/** 
	 * Retourne une chaîne de caractère avec les elements de la classe 
	 *
	 * @return retourne la carte avec sa couleur et son symbole
	 */	
	@Override
	public String toString() {

		// actionString va contenir le symbole de la carte ('+', '-' ou encore '>')
		String actionString = "";

		// On associe à chaque cas un symbole
		if(action==-1)
		{
			actionString="-";
		}
		else if(action==1)
		{
			actionString="+";
		}
		else if(action==2)
		{
			actionString="++";
		}
		else if(action==3)
		{
			actionString=">";
		}
		else if(action==4)
		{
			actionString=">>";
		}
		return "Carte " + couleur + " " + actionString;
	}

	/** 
	 * Retourne une chaîne de caractère correspondant à un bout de carte
	 * 
	 * @param y Correspond à la coordonée 'y' du tableau {@link #toString(int) affCarte} à retourner 
	 * @return retourne une chaîne de caractère correspondant à un bout de carte
	 * 
	 * @note Cette méthode est appeler pour afficher les cartes en shell de façon plus "graphique"
	 */
	public String toString(int y) {

		// Coordonée x du tableau affCarte - Etablie la relation en entre les coordonées de ce tableau et la variable 'action'
		int act = 0;

		// La chaîne de caractère qui sera retournée
		String jeuxCarte = "";

		// Tableau de String qui contient toutes les cartes pour une représentation plus "graphique"
		String affCarte[][] = new String[5][10];

		affCarte[0][0] = " ___________";
		affCarte[0][1] = "/     _     \\";
		affCarte[0][2] = "|   _| |_   |";
		affCarte[0][3] = "|  |_   _|  |";
		affCarte[0][4] = "|    |_|    |";
		affCarte[0][5] = "|     _     |";
		affCarte[0][6] = "|   _| |_   |";
		affCarte[0][7] = "|  |_   _|  |";
		affCarte[0][8] = "|    |_|    |";
		affCarte[0][9] = "\\___________/";

		affCarte[1][0] = " ___________";
		affCarte[1][1] = "/           \\";
		affCarte[1][2] = "|           |";
		affCarte[1][3] = "|     _     |";
		affCarte[1][4] = "|   _| |_   |";
		affCarte[1][5] = "|  |_   _|  |";
		affCarte[1][6] = "|    |_|    |";
		affCarte[1][7] = "|           |";
		affCarte[1][8] = "|           |";
		affCarte[1][9] = "\\___________/";

		affCarte[2][0] = " ___________";
		affCarte[2][1] = "/           \\";
		affCarte[2][2] = "|           |";
		affCarte[2][3] = "|           |";
		affCarte[2][4] = "|   ____    |";
		affCarte[2][5] = "|  |____|   |";
		affCarte[2][6] = "|           |";
		affCarte[2][7] = "|           |";
		affCarte[2][8] = "|           |";
		affCarte[2][9] = "\\___________/";

		affCarte[3][0] = " ___________";
		affCarte[3][1] = "/           \\";
		affCarte[3][2] = "|           |";
		affCarte[3][3] = "|    / \\    |";
		affCarte[3][4] = "|   /   \\   |";
		affCarte[3][5] = "|           |";
		affCarte[3][6] = "|    / \\    |";
		affCarte[3][7] = "|   /   \\   |";
		affCarte[3][8] = "|           |";
		affCarte[3][9] = "\\___________/";

		affCarte[4][0] = " ___________";
		affCarte[4][1] = "/           \\";
		affCarte[4][2] = "|           |";
		affCarte[4][3] = "|           |";
		affCarte[4][4] = "|    / \\    |";
		affCarte[4][5] = "|   /   \\   |";
		affCarte[4][6] = "|           |";
		affCarte[4][7] = "|           |";
		affCarte[4][8] = "|           |";
		affCarte[4][9] = "\\___________/";

		// On associe à chaque cas un emplacement du tableau d'affichage des cartes
		if(action==-1)
		{
			act = 2;
		}
		else if(action==1)
		{
			act = 1;
		}
		else if(action==2)
		{
			act = 0;
		}
		else if(action==3)
		{
			act = 4;
		}
		else if(action==4)
		{
			act = 3;
		}

		// On regarde si on retourne un bout de carte ou la couleur
		if(y < 10)
		{
			jeuxCarte = affCarte[act][y];
		}
		else
		{
			jeuxCarte = couleur;
		}

		// Et on retourne
		return jeuxCarte;
	}

}
