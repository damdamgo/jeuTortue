/*
 * Nom de classe : 	Pioche
 *
 * Description   : 	Elle permet de gerer la pioche pendant la partie
 * 					Elle implemente Serializable et melanger
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Random;

/**
 * Permet de gerer la pioche pendant la partie
 * 
 * @version 1.0
 *
 * @see Serializable
 * @see Melanger
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class Pioche implements Serializable, Melanger {

	/**
	 * Clé de hachage SHA qui identifie de manière unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est sérialisée, de la marquer 
	 *  	 avec une somme de contrôle (checksum) pour que lors de la 
	 *  	 désérialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu’il manipule
	 */
	private static final long serialVersionUID = 7L;
	
	/* Traduction des actions de String en entier : 
	 * - : -1
	 * + : 1
	 * ++ : 2
	 * > : 3
	 * >> : 4 
	 */
	
	/**
	 * Liste qui contient l'ensemble des cartes
	 */
	private LinkedList<Carte> jeuxCartes;
	
	/**
	 * Contient l'ensemble des actions pour creer plus facilement l'ensemble des cartes couleurs non neutres
	 */
	private int[] tabaction = {2,1,1,1,1,1,-1,-1};
	
	/**
	 * Contient l'ensemble des actions pour les cartes neutres
	 */
	int [] tabactionneutre = {-1,-1,1,1,1,1,1,4,4,3,3,3};
	
	/* Constructeur */
	
	public Pioche() {
		jeuxCartes= new LinkedList<Carte>();
	}

	/* getter */
	
	public LinkedList<Carte> getJeuxCarte() {
		return jeuxCartes;
	}

	/* setter */
	public void setJeuxCarte(LinkedList<Carte> jeuxCarte) {
		this.jeuxCartes = jeuxCarte;
	}
	
	/* toString */
	public String toString() {
		String retour="";
		for(Carte carte : jeuxCartes) {
			retour+=carte.toString()+"----";
		}
		return retour;
	}
	
	/**
	 * Permet la recuperation d'une carte de la pioche
	 * 
	 * @return Retourne la 1er carte de la pioche (et la supprime donc de la lsite)
	 */
	public Carte enleverCarte() {
		return jeuxCartes.removeFirst();
	}
	
	/**
	 * Permet l'ajout d'une nouvelle carte dans la pioche
	 * 
	 * @param nouvelle Nouvelle carte à ajouter à la pioche
	 */
	public void ajouterCarte(Carte nouvelle) {
		jeuxCartes.add(nouvelle);
	}
	
	/**
	 * Permet l'ajout des cartes correspondants à une couleur autre que neutre
	 * 
	 * @param couleur Couleur à rajouter dans la liste carte
	 */
	public void ajouterCouleur(String couleur) {
		for(int j=0;j<tabaction.length;j++) {
			jeuxCartes.add(new Carte(couleur,tabaction[j]));
		}	
	}
	
	/**
	 * Permet d'ajouter les cartes neutres dans la pioche
	 */
	public void ajouterNeutre() {
		for(int i=0;i<tabactionneutre.length;i++) {
			jeuxCartes.add(new Carte("neutre",tabactionneutre[i]));
		}
	}
	

	/**
	 * Permet de melanger une liste de carte
	 * 
	 * @note Deuxieme algo de melange
	 * 		 il suit l'idée du melange : Riffle Shuffle
	 * 		 on decoupe en deux le tableau
	 * 		 puis on prend un nombre aleatoire de carte d'un paquet allant de 0 a 5 puis la meme chose pour le deuxieme
	 * 		 et ce jusqu'à qu'un des deux paquets soit vide
	 * 		 ensuite on insert l'ensemble des cartes de l'autre paquet
	 * 		 et on repete trois fois l'operation
	 */
	public void melanger() {

			LinkedList<Carte> copy1 = new LinkedList<Carte>(); // Les deux listes pour contenir les deux parties de la pioche d'origine
			LinkedList<Carte> copy2 =  new LinkedList<Carte>();
			Random rand = new Random();
			int tour=0; // Sauvegarde le nombre de tour
			while(tour!=3) {
				// Pour faire les trois tours
				copy1.clear(); // On initialise les listes
				copy2.clear();
				int milieu=jeuxCartes.size()/2; // On recherche le milieu
				while(jeuxCartes.size()>milieu)copy1.add(jeuxCartes.removeFirst()); // On insert dans la premiere liste la moitié
				copy2=(LinkedList<Carte>) jeuxCartes.clone(); // Puis on copie le reste donc l'autre moitié dans la liste restante
				jeuxCartes.clear(); // On reinitialise la pioche
				while(copy1.size()!=0 && copy2.size()!=0) {
					// Tant que une des deux listes n'est pas vide
					for(int i=0;i<rand.nextInt(5);i++) {
						// Pour un nombre de cartes aleatoire
						if(!copy1.isEmpty())jeuxCartes.add(copy1.removeFirst()); // On ajoute à la pioche si la liste n'est pas vide
					}
					for(int i=0;i<rand.nextInt(5);i++) {
						if(!copy2.isEmpty())jeuxCartes.add(copy2.removeFirst());
					}		
				}
				while(copy1.size()!=0)jeuxCartes.add(copy1.removeFirst()); // Puis pour l'autre liste on ajoute l'ensemble des cartes restantes
				while(copy2.size()!=0)jeuxCartes.add(copy2.removeFirst());
				tour++; // On incremente le nombre de tours
			}
	}
	
}
