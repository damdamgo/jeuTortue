/*
 * Nom de classe : 	RecupererPartie
 *
 * Description   : 	Elle permet de charger une partie
 * 					Elle etend fichier
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Permet de charger une partie
 * 
 * @version 1.0
 *
 * @see Fichier
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class RecupererPartie extends Fichier {

	/**
	 * Permet de sauvegarder l'indice du fichier qui doit etre chargé
	 */
	private int index;
	
	/**
	 * Permet de sauvegarder le plateau de la partie chargée
	 */
	private Plateau plateau ;
	
	/**
	 * Permet de sauvegarder la pioche de la partie chargée
	 */
	private Pioche pioche;
	
	/**
	 * Permet de sauvegarder la liste des joueurs de la partie chargée
	 */
	private LinkedList<Joueur> joueur;
	
	/**
	 * Permet de sauvegarder la liste des couleurs de la partie chargée 
	 */
	private LinkedList<String> color;
	
	/**
	 * Permet de sauvegarder le joueur qui doit jouer
	 */
	private int indexJoueur;
	
	/**
	 * Permet de recuperer des informations données par le joueur
	 */
	Scanner sc = new Scanner(System.in);

	/* Constructeur */

	public RecupererPartie() {
		super("parties");
	}


	/* getters */

	public Plateau getPlateau() {
		return plateau;
	}

	public Pioche getPioche() {
		return pioche;
	}

	public LinkedList<Joueur> getJoueur() {
		return joueur;
	}

	public LinkedList<String> getColor() {
		return color;
	}

	public int getIndexJoueur() {
		return indexJoueur;
	}

	public int getIndex() {
		return index;
	}

	/* setters */

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}

	public void setJoueur(LinkedList<Joueur> joueur) {
		this.joueur = joueur;
	}

	public void setColor(LinkedList<String> color) {
		this.color = color;
	}

	public void setIndexJoueur(int indexJoueur) {
		this.indexJoueur = indexJoueur;
	}
	
	/**
	 * Permet de choisir la partie qui doit etre chargée
	 * 
	 * @throws FileNotFoundException Fichier non trouvé
	 * @throws IOException Erreur d'entrée sortie
	 * @throws ClassNotFoundException Classe non trouvée
	 */
	public void choisirPartie() throws FileNotFoundException, IOException, ClassNotFoundException {
		do {
			System.out.println("veuillez choisir le numero de la partie (0 pour la premiere) :");
			while (!sc.hasNextInt()) {
				// Tant que ce n'est pas un entier on demande de saisir à nouveau
				System.out.println("saisir un entier");
				sc.next();
			}
			index = sc.nextInt();
			sc.nextLine();
		}while(index<0 || index>super.getListeFichier().length-1);
		chargerPartie(index);
	}

	/**
	 * Permet le chargement de la partie
	 * 
	 * @param index Indice du fichier choisi
	 * 
	 * @throws FileNotFoundException Fichier non trouvé
	 * @throws IOException Erreur d'entrée sortie
	 * @throws ClassNotFoundException Classe non trouvée
	 */
	public void chargerPartie(int index) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		System.out.println("chargement de la partie ...");
		File fichier =  new File(super.getFolder()+"/"+super.getListeFichier()[index].getName()); // Recuperation du fichier
		ObjectInputStream objectInputStream=null;

		objectInputStream = new ObjectInputStream(new FileInputStream(fichier));

		Plateau plateau2 = null;
		try {
			plateau = (Plateau) objectInputStream.readObject();
		} catch (ClassNotFoundException e1) {
		} catch (IOException e1) {
		}
		plateau2=plateau;
		while(plateau2!=null) {
			plateau=plateau2;

			pioche = (Pioche) objectInputStream.readObject();

			color =(LinkedList<String>) objectInputStream.readObject();

			joueur =(LinkedList<Joueur>) objectInputStream.readObject();

			indexJoueur=(int) objectInputStream.readObject();

			try {//si il y a une erreur alors on aura parcouru l'ensemble du fichier
				plateau2 = (Plateau) objectInputStream.readObject();
			} catch (ClassNotFoundException e) {
			} catch (IOException e) {
				plateau2=null;
			}
		}
		if(objectInputStream!=null)objectInputStream.close();
		if(objectInputStream!=null)System.out.println("Chargement terminé");
	}	

}
