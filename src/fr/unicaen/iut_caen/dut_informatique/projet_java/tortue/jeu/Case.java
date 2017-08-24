/*
 * Nom de classe : 	Case
 *
 * Description   : 	Elle permet de gerer les cases du plateau de jeu
 *					Elle implemente Serializable pour la sauvegarde
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Permet de gerer les cases du plateau de jeu
 * 
 * @version 1.0
 *
 * @see Serializable
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class Case implements Serializable {

	/**
	 * Cl� de hachage SHA qui identifie de mani�re unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est s�rialis�e, de la marquer 
	 *  	 avec une somme de contr�le (checksum) pour que lors de la 
	 *  	 d�s�rialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu�il manipule
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * Ensemble des tortues qui sont sur une case
	 * 
	 * @see #Case()
	 * @see Couleur#getCouleur()
	 * @see Couleur#setCouleur(String)
	 */
	private LinkedList<Tortue> tableauTortues;


	/* Constructeur */

	public Case() {
		tableauTortues = new LinkedList<Tortue>();
	}

	/* getters */
	public LinkedList<Tortue> getTableauTortues() {
		return tableauTortues;
	}
	/**
	 * Permet de recuperer un tableau de tortues � partir d'une couleur
	 * 
	 * @param couleur Chaine de caract�re correspondant � une couleur
	 * @return Retourne une liste de tortue(s)
	 */
	public LinkedList<Tortue> getTortues(String couleur) {
		LinkedList<Tortue> retour = new LinkedList<Tortue>();
		int index=0;
		while(!tableauTortues.get(index).getCouleur().equals(couleur))index++; // On recupere l'emplacement de la tortue qui correspond � la couleur
		while((index)!=tableauTortues.size())
		{
			retour.add(tableauTortues.remove(index)); // On recupere la tortue ainsi que celles presentent sur elle
		}
		return retour;
	}	

	/**
	 * Permet de recuperer la premiere tortue de la liste donc celle la plus en dessous
	 * 
	 * @return Retourne la 1er tortue d'une liste
	 */
	public Tortue getPremiere() {
		return tableauTortues.getFirst();
	}

	/* toString */

	/** 
	 * Retourne une cha�ne de caract�re correspondant � un bout de case
	 * 
	 * @param k correspond � la hauteur de la case (qui varie suivant le nombre de joueur)
	 * @return retourne une cha�ne de caract�re correspondant � un bout de case
	 * 
	 * @note Cette m�thode est appel�e pour afficher les cases en shell de mani�re plus "graphique"
	 */
	public String[] toString(int k) {

		String tab[] = new String[k]; // Tableau de String qui contient toutes les lignes d'une cases
		int trace = k-1; // Variable de naviguabilit�

		tab[trace] = "|____________";
		trace--;

		for(Tortue tortue : tableauTortues) 
		{
			for(int i = 4; i >= 0; i--)
			{
				tab[trace] = "| "+tortue.afficherTortue(i)+" ";
				trace--;

			}
		}

		if(trace > 0)
		{
			while(trace > 0)
			{
				tab[trace] = "|            ";
				trace--;
			}
		}

		tab[0] = "_____________";

		return tab;    
	}

	/** 
	 * Permet de savoir si la case est vide
	 * 
	 * @return retourne un bool�en
	 * 
	 */
	public boolean estvide() {
		return tableauTortues.isEmpty();
	}

	/** 
	 * Permet de savoir si une tortue qui correspond � la couleur est presente dans la liste de la carte
	 * 
	 * @param couleur de la tortue
	 * @return retourne un bool�en
	 */
	public boolean estPresente(String couleur) {
		int index=0;
		while(index<tableauTortues.size() && !(tableauTortues.get(index).getCouleur().equals(couleur)))
		{
			index++;
		}
		if(index>=tableauTortues.size())return false;
		else return true;
	}

	/** 
	 * Permet d'ajouter une liste de tortues � celle existante
	 * 
	 * @param ajout liste de tortue(s)
	 */
	public void add(LinkedList<Tortue> ajout) {
		tableauTortues.addAll(ajout);
	}

	/** 
	 * Permet de faire monter la tortue sur les autres tortues
	 * 
	 * @param couleur de la carte (tortue � faire monter)
	 * @param action de la carte
	 */
	public void Monter(String couleur, int action) {
		int index=0;
		while(tableauTortues.get(index).getCouleur()!=couleur)index++;
		if(tableauTortues.size()>index+1) tableauTortues.add(index+1,tableauTortues.remove(index));
		if(tableauTortues.size()>index+2 && action==2)tableauTortues.add(index+2,tableauTortues.remove(index+1));
	}

}
