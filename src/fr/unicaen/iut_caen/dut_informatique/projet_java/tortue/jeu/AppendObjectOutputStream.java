/*
 * Nom de classe : 	AppendObjectOutputStream
 *
 * Description   : 	Elle permet de ne pas mettre d'entete pour l'ajout d'objet dans un fichier existant
 *					Elle etend ObjectOutputStream
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * Permet de ne pas mettre d'entete pour l'ajout d'objet dans un fichier existant
 * 
 * @version 1.0
 *
 * @see ObjectOutputStream
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 */
public class AppendObjectOutputStream extends ObjectOutputStream {

	/* Constructeur */
	
	/**
	 * Constructeur de la classe
	 * 
	 * @param out Sortie fichier
	 * 
	 * @throws IOException Erreur d'entrée sortie
	 */
	public AppendObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}

	/**
	 * Redéfinit la fonction pour ne pas ajouter de header
	 */
	@Override
	protected void writeStreamHeader() throws IOException {
		reset();
	}
}
