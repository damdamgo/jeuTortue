/*
 * Nom de classe : 	HistoriqueRecuperer
 *
 * Description   : 	Elle permet de recuperer une partie terminée
 *					Elle etend de Fichier
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
import java.io.Serializable;
import java.util.Scanner;

/**
 * Permet de recuperer une partie terminée
 * 
 * @version 1.0
 *
 * @see Serializable
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class HistoriqueRecuperer extends Fichier {

	/**
	 * Sauvegarder le choix du fichier 
	 */
	private int index;

	/**
	 * Scanner
	 */
	private Scanner sc = new Scanner(System.in);


	/* constructeur */

	public HistoriqueRecuperer() {
		super("historique");
	}

	/**
	 * Permet de choisir la partie
	 * 
	 * @throws FileNotFoundException Fichier non trouvé
	 * @throws IOException Erreur d'entrée sortie
	 * @throws ClassNotFoundException Classe non trouvée
	 */
	public void choisirPartie() throws FileNotFoundException, IOException, ClassNotFoundException {
		do
		{
			System.out.println("veuillez choisir le numero de la partie ( 0 pour la premier) ");
			while (!sc.hasNextInt()) { 
				// Tant que ce n'est pas un entier on demande de saisir à nouveau

				System.out.println("saisir un entier");
				sc.next();
			}
			index = sc.nextInt();
			sc.nextLine();
		}while(index<0 || index>super.getListeFichier().length-1);
		charger(index);
	}

	/**
	 * Charge la partie 
	 * 
	 * @param index Indice du fichier
	 * 
	 * @throws FileNotFoundException Fichier non trouvé
	 * @throws IOException Erreur d'entrée sortie
	 * @throws ClassNotFoundException Classe non trouvée
	 */
	public void charger(int index) throws FileNotFoundException, IOException, ClassNotFoundException {

		int nbJoueur  = 0;

		// On recupere les informations importantes et on les affiches dont le joueur gagnant , plateau qui contient les emplacements finaux des tortues
		System.out.println("------------------Resumé------");
		File fichier =  new File(super.getFolder()+"/"+super.getListeFichier()[index].getName()); // Recuperation du fichier

		ObjectInputStream objectInputStream=null;
		objectInputStream = new ObjectInputStream(new FileInputStream(fichier));
		if(objectInputStream!=null)nbJoueur= (int) objectInputStream.readObject();
		if(objectInputStream!=null)System.out.println((Joueur) objectInputStream.readObject());
		if(objectInputStream!=null) {
			String st=((Plateau) objectInputStream.readObject()).toString(nbJoueur);
			System.out.println(st);
		}
		if(new File(super.getFolder()+"/parties/"+super.getListeFichier()[index].getName()).exists()) {
			// Puis on recupere l'évolution du plateau durant la partie puis on affiche
			System.out.println("------------------Partie------");
			fichier =  new File(super.getFolder()+"/parties/"+super.getListeFichier()[index].getName()); // Recuperation du fichier
			objectInputStream = new ObjectInputStream(new FileInputStream(fichier));
			Plateau plateau=null;
			if(objectInputStream!=null)plateau = (Plateau) objectInputStream.readObject();
			while(plateau!=null) {

				/* 
				 * Pour lire l'ensemble des plateaux il faut parcourir le fichier est quand on 
				 * recupere l'exeption alors il n'y a plus rien à recuperer 
				 */
				String st=plateau.toString(nbJoueur);
				System.out.println(st);
				objectInputStream.readObject();
				objectInputStream.readObject();
				objectInputStream.readObject();
				objectInputStream.readObject();
				try {
					plateau = (Plateau) objectInputStream.readObject();
				} catch (ClassNotFoundException e) {
				} catch (IOException e) {
					plateau=null;
				}
			}
			if(objectInputStream!=null)objectInputStream.close();
		}
	}
}
