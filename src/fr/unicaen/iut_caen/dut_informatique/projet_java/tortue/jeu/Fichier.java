/*
 * Nom de classe : 	Fichier
 *
 * Description   : 	Elle permet la gestion du dossier pour les classes qui manipulent des fichiers
 *					Elle est abstraite
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.File;
import java.io.FileFilter;

/**
 * Permet la gestion du dossier pour les classes qui manipulent des fichiers
 * 
 * @version 1.0
 *
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public abstract class Fichier {

	/**
	 * Permet de recuperer les noms des fichiers dans un dossier
	 */
	private File[] listeFichier;

	/**
	 * Permet de connaitre le dossier 
	 */
	private File folder ;

	/* Constructeur */

	public Fichier(String nom) {
		folder = new File(nom);
		if(! folder.exists()) folder.mkdirs();
	}


	/* getters */

	public File[] getListeFichier() {
		return listeFichier;
	}

	public File getFolder() {
		return folder;
	}


	/* setters */

	public void setListeFichier(File[] listeFichier) {
		this.listeFichier = listeFichier;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	/**
	 * Permet de recuperer l'ensemble des fichiers enregistrés
	 */
	public void recupererFichier() {
		listeFichier = folder.listFiles(new FileFilter() {
			public boolean accept(File fichier) {
				return fichier.isFile();
			}
		});
	}

	/**
	 * Permet d'afficher la liste des fichiers
	 * 
	 * @param indice Indice du ficheir à afficher (pour mieux reperer
	 * @return Retourne l'indice +1
	 */
	public int afficherFichier(int indice) {
		
		for(File fichier : listeFichier) {

			System.out.println("fichier "+indice+++" : "+fichier.getName().substring(0, fichier.getName().length()-4));

		}
		
		return indice;
	}

}
