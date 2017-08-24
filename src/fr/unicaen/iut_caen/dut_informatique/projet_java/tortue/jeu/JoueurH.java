/*
 * Nom de classe : 	JoueurH
 *
 * Description   : 	Permet de definir un joueur humain
 * 					Elle etend joueur et implemente serializable pour la sauvegarde
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Permet de definir un joueur humain
 * 
 * @version 1.0
 *
 * @see Serializable
 * @see Joueur
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class JoueurH extends Joueur implements Serializable {
	
	/**
	 * Clé de hachage SHA qui identifie de manière unique la Classe
	 * 
	 * @note Cela permet lorsque la classe est sérialisée, de la marquer 
	 *  	 avec une somme de contrôle (checksum) pour que lors de la 
	 *  	 désérialisation, le programme soit certain de la version 
	 *  	 de la classe Java qu’il manipule
	 */
	private static final long serialVersionUID = 5L;
	
	/**
	 * Permet de recuperer le choix de carte du joueur
	 */
	private int index;
	
	/* Constructeur */
	public JoueurH(String pseudo) {
		super(pseudo);
	}
	
	/**
	 * Permet au joueur de jouer une carte
	 * 
	 * @return Retourne la carte souhaitée
	 */
	@Override
	public Carte jouer() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(super.toString()); // On affiche les informations
		System.out.print("Veuillez indiquer la carte que vous souhaitez jouer (0 pour la premiere 4 pour la derniere) : ");
		do {
			while(!sc.hasNextInt()) {
				// Tant que ce n'est pas un entier on demande de saisir à nouveau
				
				System.out.println("saisir un entier entre 0 et 4");
				sc.next();
			}
			index = sc.nextInt();
			sc.nextLine();
		}while(index<0 || index > 4);
		return super.getMain().remove(index);
	}

}
