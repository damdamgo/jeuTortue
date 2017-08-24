/*
 * Nom de classe : 	JoueurO
 *
 * Description   : 	Permet de definir un joueur control� par l'ordinateur
 * 					Elle etend joueur et implemente serializable pour la sauvegarde
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * Permet de definir un joueur control� par l'ordinateur
 * 
 * @version 1.0
 *
 * @see Serializable
 * @see Joueur
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class JoueurO extends Joueur implements Serializable {

	/**
	 * Cl� de hachage SHA qui identifie de mani�re unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est s�rialis�e, de la marquer 
	 *  	 avec une somme de contr�le (checksum) pour que lors de la 
	 *  	 d�s�rialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu�il manipule
	 */
	private static final long serialVersionUID = 6L;
	
	/**
	 * Permet de choisir un nombre aleatoire entre 0 et 5
	 */
	private Random r=new Random();
	
	/* Constructeur */
	
	public JoueurO(String pseudo) {
		super(pseudo);
	}

	/**
	 * Permet � l'ordinateur de jouer une carte
	 * 
	 * @return Retourne une carte de la main aleatoire
	 */
	@Override
	public Carte jouer() {
		Scanner sc = new Scanner(System.in);
		System.out.println(super.toString());
		System.out.println("appuyez sur entrer pour que l'ordinateur joue");
		sc.nextLine();// Faire une "pause"
		return super.getMain().remove(r.nextInt(5));
	}

}

