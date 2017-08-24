/*
 * Nom de classe : 	HistoriqueSauvegarde
 *
 * Description   : 	Elle permet d'archiver une partie terminée
 *					Elle etend de Fichier
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * Permet d'archiver une partie terminée
 * 
 * @version 1.0
 *
 * @see Fichier
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class HistoriqueSauvegarde extends Fichier {

	/**
	 * Scanner
	 */
	Scanner sc = new Scanner(System.in);

	/* Construteur */

	public HistoriqueSauvegarde() {
		super("historique");
	}

	/**
	 * Permet de deplacer la partie dans le fichier historique
	 * 
	 * @param fichier Fichier à déplacer
	 */
	public void deplacerFichierPartie(File fichier) {

		File folderH = new File("historique/parties");
		if(! folderH.exists()) folderH.mkdirs();
		File fichierO = new File("parties/"+fichier.getName());
		if(fichierO.renameTo(new File(super.getFolder().getName()+"\\parties\\" + fichier.getName()))) {
			System.out.println("fichier archivé");
		}
		else {
			System.out.println("probleme dans l'archivage");
		}
	}

	/**
	 * Permet de sauvegarder la fin de la partie
	 * 
	 * @param nbJoueur Correspond au nombre de joueur
	 * @param gagnant Correspond au joueur ayant gagner la partie
	 * @param plateau Correspond au plateau Plateau de jeux
	 * @param nomfichier Correspond au nom du fichier
	 * 
	 * @throws FileNotFoundException Fichier non trouvé
	 * @throws IOException Erreur d'entrée sortie
	 */
	public void sauvegarderFin(int nbJoueur, Joueur gagnant, Plateau plateau, String nomfichier) throws FileNotFoundException, IOException {

		System.out.println("enregistrement du fichier resumé");
		File fichier = new File(super.getFolder().getName()+"/"+nomfichier);
		FileOutputStream fileOutputStream=null;
		ObjectOutputStream objectOutputStream=null;

		fileOutputStream = new FileOutputStream(fichier);
		objectOutputStream = new ObjectOutputStream(fileOutputStream);
		if(objectOutputStream!=null)objectOutputStream.writeObject(nbJoueur);
		if(objectOutputStream!=null)objectOutputStream.writeObject(gagnant); // Erreur ici !!!
		if(objectOutputStream!=null)objectOutputStream.writeObject(plateau);
		if(objectOutputStream!=null)objectOutputStream.flush();
		if(objectOutputStream!=null)objectOutputStream.close();
		System.out.println("enregistré");
	}
}
