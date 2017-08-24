/*
 * Nom de classe : 	Sauvegarde
 *
 * Description   : 	Elle permet de sauvegarder une partie
 * 					Elle etend de Fichier
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
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Permet de sauvegarder une partie
 * 
 * @version 1.0
 *
 * @see Fichier
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class Sauvegarde extends Fichier {

	/**
	 * Permet de sauvegarder le nom du fichier de sauvegarde
	 */
	private String nom;
	
	/**
	 * Permet de definir le fichier de sauvegarde
	 */
	private File fichier;
	
	/**
	 * Permet la recuperation d'informations données par l'utilisateur
	 */
	private Scanner sc = new Scanner(System.in);

	/* Constructeur */

	public Sauvegarde() {
		super("parties");
	}

	/* getters */

	public String getNom() {
		return nom;
	}

	public File getFichier() {
		return fichier;
	}

	/* setters */
	
	public void setNom(String nom) {
		this.nom = nom;
		setFichier(new File(nom+".txt"));
	}

	public void setFichier(File fichier) {
		this.fichier = fichier;
	}

	//p
	
	/**
	 * Permet de sauvegarder une partie avec la serialisation 
	 * 
	 * @param plateau Plateau de jeu à sauvegarder
	 * @param joueur Liste de joueurs à sauvegarder
	 * @param color Liste de couleurs de la partie
	 * @param pioche Liste des cartes de la pioche
	 * @param indexJoueur Index du joueur qui va jouer
	 * 
	 * @throws FileNotFoundException Fichier non trouvé
	 * @throws IOException Erreur d'entrée sortie
	 */
	public void sauvegarder(Plateau plateau,LinkedList<Joueur> joueur,LinkedList <String> color,Pioche pioche,int indexJoueur) throws FileNotFoundException, IOException {
		System.out.println("\nEnregistrement en cours...");
		FileOutputStream fileOutputStream=null;
		ObjectOutputStream objectOutputStream=null;

		// Si le fichier existe il ne faut pas ecrire d'entete
		if(new File(super.getFolder()+"/"+fichier.getName()).exists()) {
			fileOutputStream = new FileOutputStream(super.getFolder()+"/"+fichier,true);
			objectOutputStream = new AppendObjectOutputStream(fileOutputStream);
		}
		
		// Sinon on peut ecrire une entete
		else {
			fileOutputStream = new FileOutputStream(super.getFolder()+"/"+fichier,true);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
		}
		if(objectOutputStream!=null)objectOutputStream.writeObject(plateau);
		if(objectOutputStream!=null)objectOutputStream.writeObject(pioche);
		if(objectOutputStream!=null)objectOutputStream.writeObject(color);
		if(objectOutputStream!=null)objectOutputStream.writeObject(joueur);
		if(objectOutputStream!=null)objectOutputStream.writeObject(indexJoueur);
		if(objectOutputStream!=null)objectOutputStream.flush();
		if(objectOutputStream!=null)objectOutputStream.close();
		if(objectOutputStream!=null)System.out.println("Partie enregistrée !");
		else System.out.println("Un probleme est survenu");
	}

	/**
	 * Permet de verifier si le nom est deja attribué à une sauvegarde
	 * 
	 * @param nom Nom de la sauvegarde
	 * @return Retourne un booleen afin de savoir si le nom est déjà utiliser
	 */
	public boolean verificationNom(String nom) {
		boolean autorisation=false;
		for(File fichier : super.getListeFichier()) {
			if(nom.equals(fichier.getName().substring(0,fichier.getName().length()-4)))autorisation=true;
		}
		HistoriqueSauvegarde historique = new HistoriqueSauvegarde();
		historique.recupererFichier();
		for(File fichier : historique.getListeFichier()) {
			if(nom.equals(fichier.getName().substring(0,fichier.getName().length()-4)))autorisation=true;
		}
		return autorisation;
	}
	
	/**
	 * Permet au joueur de definir un nom pour le fichier
	 */
	public void choisirNom() {
		String nom;
		int err = 0;
		do {
			if(err != 0) {
				System.out.println("Erreur : ce nom est déjà utiliser. Merci d'en utiliser un autre.");
			}
			System.out.println("Veuillez saisir un nom pour la sauvegarde : ");
			nom=sc.nextLine();
		}while(verificationNom(nom));
		setNom(nom);
	}

}

