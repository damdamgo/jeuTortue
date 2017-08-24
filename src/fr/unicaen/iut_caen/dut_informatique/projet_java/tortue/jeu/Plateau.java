/*
 * Nom de classe : 	Plateau
 *
 * Description   : 	Elle permet de gerer et definir le plateau du jeu
 * 					Elle implemente Serializable pour la sauvegarde
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

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
public class Plateau implements Serializable {

	/**
	 * Clé de hachage SHA qui identifie de manière unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est sérialisée, de la marquer 
	 *  	 avec une somme de contrôle (checksum) pour que lors de la 
	 *  	 désérialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu’il manipule
	 */
	private static final long serialVersionUID = 8L;
	
	/**
	 * Une liste de case
	 */
	private LinkedList<Case> plateau;
	
//	/**
//	 * Scanner
//	 */
//	private Scanner sc;

	/* Constructeur */
	
	public Plateau() {
		plateau = new LinkedList<Case>();
		for(int i=0;i<10;i++)plateau.add(new Case());
	}

	/* getter */
	
	public LinkedList<Case> getPlateau() {
		return plateau;
	}

	/* setter */
	
	public void setPlateau(LinkedList<Case> plateau) {
		this.plateau = plateau;
	}

	/* toString */
	
	/**
	 * Cette methode affiche le plateau de jeux
	 * 
	 * @param nbJ Nombre de joueur
	 * @return Retourne le plateau de jeux en String à afficher
	 */
	public String toString(int nbJ) {
		String retour="";
		int sizeCase = 2+5*nbJ;
		int x = 0;
		String plat[][] = new String [10][sizeCase];
		String tab[] = new String [sizeCase];
		
		// On remplie le tableau avec le contenu des cases
		for(Case cases : plateau) {
			tab=cases.toString(sizeCase);
			for(int i = 0; i < sizeCase; i++) {
				plat[x][i] = tab[i];
			}
			x++;
		}
		
		// On met tout cela dans une variable de retour
		for(int i = 0; i <sizeCase;i++) {
			for(int j = 0; j < 10; j++) {
				retour+=plat[j][i];
			}
			if(i != 0) {
				retour+="|";
			}
			retour+="\n";
		}
		return retour;
	}

	/**
	 * Permet  de deplacer une tortue
	 * 
	 * @param carte Carte pour l'action à réaliser sur une ou plusieurs tortues
	 * @param tabCouleur Liste de couleur 
	 */
	public void deplacerTortues(Carte carte, LinkedList<String> tabCouleur) {
		
		int index=0;
		if(carte.getCouleur().equals("neutre")==false) {
			// Si la carte n'a pas pour couleur neutre		
			while(! plateau.get(index).estPresente(carte.getCouleur()))index++; // On recherche la case qui contient la couleur
			if(index+carte.getAction() < 0) plateau.get(0).add(plateau.get(index).getTortues(carte.getCouleur())); // Puis on deplace la tortue ou les tortues dans la case
			else if(index+carte.getAction() > 9)plateau.get(9).add(plateau.get(index).getTortues(carte.getCouleur()));
			else plateau.get(index+carte.getAction()).add(plateau.get(index).getTortues(carte.getCouleur()));
		}
		else {
			int couleur;
			if(tabCouleur.size()==1)couleur=0; // Si le joueur est l'ordinateur alors la liste de couleur est de taille 1
			else {
				Scanner sc = new Scanner(System.in);
				System.out.println("choisir couleur : \n"); // Le joueur doit choisir une couleur
				for(int i =0;i<tabCouleur.size();i++) {
					System.out.println(i+" : "+tabCouleur.get(i));
				}
				do {
					while (!sc.hasNextInt()) {
						// Tant que ce n'est pas un entier on demande de saisir a nouveau
						System.out.println("saisir un entier entre 0 et "+(tabCouleur.size()-1));
						sc.next();
					}
					couleur=sc.nextInt();
					sc.nextLine();
				}while(couleur<0 || couleur > tabCouleur.size());
			}
			if(carte.getAction()<3) {
				// Si l'action est un deplacement vers une autre case
				while(! plateau.get(index).estPresente(tabCouleur.get(couleur)))index++; // On recherche la case qui contient la couleur
				if(index+carte.getAction() < 0) plateau.get(0).add(plateau.get(index).getTortues(tabCouleur.get(couleur))); // On deplace les tortues
				else if(index+carte.getAction() > 9 ) plateau.get(9).add(plateau.get(index).getTortues(tabCouleur.get(couleur)));
				else plateau.get(index+carte.getAction()).add(plateau.get(index).getTortues(tabCouleur.get(couleur)));
			}
			else {
				// Si l'action est de monter sur d'autre tortues
				while(! plateau.get(index).estPresente(tabCouleur.get(couleur))) index++; // On recherche la case qui contient la couleur
				plateau.get(index).Monter(tabCouleur.get(couleur),carte.getAction()-2); // On effectue l'action
			}
		}
	}

	/**
	 * Celle ci verifie si la partie n'est pas terminée
	 * 
	 * @return Retourne un booleen de la dernier case afin de savoir si elle comporte une tortue
	 */
	public boolean verifierFin() {
		return plateau.getLast().estvide();
	}

	/**
	 * Permet d'initialisé la premiere case pour commencer le jeu
	 * 
	 * @param ajout Liste de tortue à ajouter sur la 1er case du plateau
	 */
	public void initialiseJeu(LinkedList<Tortue> ajout) {
		plateau.getFirst().add(ajout);
	}

	/**
	 * Permet de recuperer le joueur gagnant
	 * 
	 * @param joueur Liste des joueurs
	 * @return Retourne le joueur gagnant
	 */
	public Joueur getGagnant(LinkedList<Joueur> joueur) {
		boolean flag=true;
		int i=9;
		int indexGagnant=0;
		LinkedList<Tortue> getListeTortues;
		while(flag)
		{
			getListeTortues=plateau.get(i).getTableauTortues();
			for(int y =0;y<joueur.size();y++)
			{
				for(int x=0;x<getListeTortues.size();x++)
				{
					if(joueur.get(y).getTuile().getCouleur().equals(getListeTortues.get(x).getCouleur()))
					{
						if(flag==true)indexGagnant=y;
						flag=false;
					}
				}
			}
			i=i-1;
		}
		
		
		return joueur.get(indexGagnant);
	}
}