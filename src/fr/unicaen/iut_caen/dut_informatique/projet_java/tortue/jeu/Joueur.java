/*
 * Nom de classe : 	Joueur
 *
 * Description   : 	Permet de definir et de gerer un joueur pendant la partie
 * 					Elle est abstraite
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
 * Permet de definir et de gerer un joueur pendant la partie
 * 
 * @version 1.0
 *
 * @see Serializable
 * @see Melanger
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public abstract class Joueur implements Serializable,Melanger {

	/**
	 * Clé de hachage SHA qui identifie de manière unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est sérialisée, de la marquer 
	 *  	 avec une somme de contrôle (checksum) pour que lors de la 
	 *  	 désérialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu’il manipule
	 */
	private static final long serialVersionUID = 4L;

	/**
	 * Permet de sauvegarder le pseudo du joueur
	 */
	private String pseudo;

	/**
	 * Main permet de sauvegarder les cartes que le joueur possedent
	 * 
	 * @see Carte
	 */
	private LinkedList<Carte> main = new LinkedList<Carte>();

	/**
	 * Permet de sauvegarder la tuile du joueur
	 * 
	 * @see Tuile
	 */
	private Tuile tuile;


	/* Constructeur */

	public Joueur(String pseudo) {
		this.pseudo=pseudo;
	}

	/* getters */

	public Tuile getTuile() {
		return tuile;
	}

	public LinkedList<Carte> getMain() {
		return main;
	}

	public String getPseudo() {
		return pseudo;
	}

	/* setters */

	public void setTuile(Tuile tuile) {
		this.tuile = tuile;
	}

	public void setMain(LinkedList<Carte> main) {
		this.main = main;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}	

	/* toString */

	@Override
	public String toString() {
		String msg = "Joueur : " + pseudo + "\n\rVotre tuile : "+ tuile +"\n\rVotre main : \n\r";

		for(int i = 0; i < 11; i++) {
			for(int j =0; j < 5; j++) {
				if(i < 10) {
					// Si l'indice est compris entre 0 et 9 on recupere la partie de carte correpsondant à l'indice donnéer en paramètre
					msg+= main.get(j).toString(i)+"\t";
				}

				else {
					// Sinon on retourne la couleur de la carte ainsi que son indice dans la liste des cartes
					msg+=main.get(j).toString(i)+"("+j+")\t";
				}
			}
			msg+="\n";
		}

		return msg;
	}

	/**
	 * Permet au joueur de recuperer une carte
	 * 
	 * @param carte Carte à ajouter
	 */
	public void addCarte(Carte carte) {
		main.add(carte);
	}

	/**
	 * Permet de melanger une liste de carte
	 * 
	 * @note Algorithme de mélange :<br>
	 * 		 celui ci va ajouter deux par deux des cartes à un 
	 * 		 emplacement aleatoire dans la nouvelle liste
	 */
	public void melanger() {
		LinkedList<Carte> copy = (LinkedList <Carte>) main.clone(); // Copie de la pioche avant tri
		main.clear(); // Reinitialisation de l'attribut jeuxCartes
		Random rand = new Random(); 
		int index=0; // Permet de sauvegarder la numero aleatoire
		for(int i=2;i<=copy.size()/2*2;i=i+2) {
			if(main.size()!=0)index=rand.nextInt(main.size()+1); // Si la liste est non vide
			else index=0; // Si la liste est vide
			main.add(index, copy.get(i-2)); // On inisert la premier element à un emplacement aleatoire
			index=rand.nextInt(main.size()+1); // On tire un nombre aleatoire puis on insert le second element
			main.add(index, copy.get(i-1));
		}
		index=rand.nextInt(main.size()+1);
		main.add(index, copy.get(copy.size()-1));

	}	

	abstract public Carte jouer();
}
