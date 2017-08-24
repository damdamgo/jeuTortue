/*
 * Nom de classe : 	Main
 *
 * Description   : 	Classe principale du programme
 *
 * Version       : 	1.0
 *
 * Date          : 	02/05/2015
 */

package fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Classe principale du programme
 * 
 * @version 1.0
 * 
 * @author DAUPRAT Quentin
 * @author VILLIERS Damien
 * @date 02/05/2015
 *
 */
public class Main {

	/**
	 * Scanner pour la saisie
	 */
	private static Scanner sc = new Scanner(System.in);

	/**
	 * Nombre de joueurs
	 */
	private static int nbJ;

	/**
	 * Joueur en cours
	 */
	private static int indexJoueur;

	/**
	 * Permet de naviguer dans le menu
	 */
	private static int choixMenu = 0;

	/**
	 * Permet de choisir si on sauvegarde apres chaque tour
	 */
	private static int choixSauvegarde;

	/**
	 * Liste de tortue
	 */
	private static LinkedList<Tortue> tortue;

	/**
	 * Liste de cartes
	 */
	private static Pioche pioche; 

	/**
	 * Liste de couleurs (pour les cartes, tuiles et tortues)
	 */
	private static LinkedList<String> color;

	/**
	 * Plateau de jeu
	 */
	private static Plateau plateau;

	/**
	 * Liste de joueurs
	 */
	private static LinkedList<Joueur> joueur;

	/**
	 * l'atribut qui gere la sauvegarde
	 */
	private static Sauvegarde save;

	/**
	 * Indice pour l'affichage des parties
	 */
	private static int indice;
	
	/**
	 * Boucle principale du programme
	 * 
	 * @param args
	 *            Argument
	 */
	public static void main(String[] args) {

		// Menu
		while (choixMenu != 4) {
			//initialisation 
			joueur = new LinkedList<Joueur>();
			plateau = new Plateau();
			color = new LinkedList<String>();
			pioche = new Pioche();
			tortue = new LinkedList<Tortue>();
			//menu
			System.out.println("#####  La Course des Tortues  #####");
			System.out.println("Bonjour bienvenue dans le menu du jeu ");
			System.out.println("veuillez choisir une option : ");
			System.out.println("1 : nouvelle partie");
			System.out.println("2 : charger partie");
			System.out.println("3 : historique");
			System.out.println("4 : quitter");

			do {
				while (!sc.hasNextInt()) {
					System.out.println("saisir un entier entre 1 et 4");
					sc.next();
				}
				choixMenu = sc.nextInt();
				sc.nextLine();
			} while (choixMenu < 1 || choixMenu > 4);

			switch (choixMenu) {
			// Nouvelle partie
			case 1:
				// Initialisation attributs
				String line = "\r\n";
				String[] couleur = { "Jaune", "Verte", "Rouge", "Bleue ",
				"Violette " };
				String src = line
						+ "Bonjour et bienvenu dans le jeux de societe \"La Courses des Tortues\" (adapter en version numerique)"
						+ line;
				String inf_nbJ = line
						+ "Combien êtes vous à jouer (de 2 à 5) : ";
				int errNbJ;
				int errChoixJ;
				int errNomJ;
				String choix;
				char h = 'H';
				char o = 'O';
				String pseudo;
				String choixJ;
				int sortie;

				// Initialisation couleur
				for (int i = 0; i < couleur.length; i++) {
					color.add(couleur[i]);
				}
				Collections.shuffle(color);

				// Nombre de joueurs
				System.out.println(src);
				do {
					nbJ = 0;
					errNbJ = 0;
					choix = null;
					System.out.println(inf_nbJ);
					do {
						if (errNbJ != 0) {
							System.out
							.println("Erreur : veuillez saisir un nombre de joueur compris entre 2 et 5 : ");
							errNbJ = 0;
						}
						while (!sc.hasNextInt()) {
							System.out.println("saisir un entier entre 2 et 5");
							sc.next();
						}
						nbJ = (int) sc.nextInt();
						sc.nextLine();
						errNbJ++;
					} while (nbJ < 2 || nbJ > 5);
					System.out
					.println("Voues êtes donc "
							+ nbJ
							+ " à jouer ? (o pour valier / n pour resaisire) : ");
					choix = sc.nextLine();
					if (choix.length() < 1) {
						choix = "O";
					}
				} while (choix.toUpperCase().charAt(0) != o);

				// Creation des joueurs
				for (int i = 0; i < nbJ; i++) {
					errChoixJ = 0;
					System.out
					.println("Le joueur "
							+ (i + 1)
							+ " est-il Humain ou ordinateur (saisir 'h' pour humain ou 'o' pour ordinateur) : ");
					// Choix du type de joueur
					do {
						sortie = 0;
						choixJ = null;
						if (errChoixJ != 0) {
							System.out
							.println("Erreur : veuillez saisir des informaitons correcte : ");
							errChoixJ = 0;
						}
						choixJ = sc.nextLine();
						errChoixJ++;
						if (choixJ.length() < 1) {
							choixJ = "a";
						}
						if (choixJ.toUpperCase().charAt(0) == h
								^ choixJ.toUpperCase().charAt(0) == o) {
							sortie++;
						}
					} while (sortie == 0);
					// Ensuite on demande le pseudo
					System.out.println("Veulliez saisir un nom pour le joueur "
							+ (i + 1) + " comprit entre 3 et 50 caractères : ");
					errNomJ = 0;
					do {
						if (errNomJ != 0) {
							System.out
							.println("Erreur : veulliez saisir un nom pour comprit entre 3 et 50 caractères : ");
							errNomJ = 0;
						}
						pseudo = null;
						errNomJ++;
						pseudo = sc.nextLine();
					} while (pseudo.length() < 3 || pseudo.length() > 50);
					// Maintenant qu'on a le type de joueur et son nom, on peut le créer
					if (choixJ.toUpperCase().charAt(0) == "h".toUpperCase()
							.charAt(0)) {
						joueur.add(new JoueurH(pseudo));
					} 

					else {
						joueur.add(new JoueurO(pseudo));
					}
				}
				// Initialisation

				// Pioche
				for (int i = 0; i < color.size(); i++) {
					pioche.ajouterCouleur(color.get(i));
					tortue.add(new Tortue(color.get(i)));
				}
				pioche.ajouterNeutre();
				pioche.melanger();

				// On associe une couleur à chaque joueur
				for (int i = 0; i < nbJ; i++) {
					joueur.get(i).setTuile(new Tuile(color.get(i)));
				}

				// On distribue les cartes
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < nbJ; j++) {
						joueur.get(j).addCarte(pioche.enleverCarte());
					}
				}
				for (int i = 0; i < nbJ; i++) {
					joueur.get(i).melanger();
				}

				// Choix du premier joueur
				indexJoueur = (int) (Math.random() * (nbJ - 0) + 0); // Valeur
				// tableau (1er val = 0)

				// Preparation pour jeu
				Collections.shuffle(tortue);
				plateau.initialiseJeu(tortue);

				// Jeu
				jeu(null);
				// Fin du jeu
				if (!plateau.verifierFin())
					fin();

				break;			
			case 2:
				// Charger partie
				indice = 0;
				System.out.println("voici la liste des parties :");
				RecupererPartie partie = new RecupererPartie();
				try {
					partie.recupererFichier(); // Recupere les parties
					indice = partie.afficherFichier(indice); // Affiche les parties
					partie.choisirPartie(); // Choix d'une partie

					// Recupere attributs et initialise
					joueur = partie.getJoueur();
					plateau = partie.getPlateau();
					color = partie.getColor();
					indexJoueur = partie.getIndexJoueur();
					// lance jeu
					jeu(partie.getListeFichier()[partie.getIndex()].getName()
							.substring(
									0,
									partie.getListeFichier()[partie.getIndex()]
											.getName().length() - 4));
					// fin du jeu
					if (!plateau.verifierFin())
						fin();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

				// Historique
			case 3:
				indice = 0;
				HistoriqueRecuperer histo = new HistoriqueRecuperer();
				histo.recupererFichier(); // Recupere fichier historique
				indice = histo.afficherFichier(indice); // Affiche les fichiers
				try {
					histo.choisirPartie(); // Choix d'une partie
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	/**
	 * La methode qui gere la boucle du jeu
	 *  
	 * @param nom Nom de la sauvegarde
	 */
	public static void jeu(String nom) {
		boolean arreter = false;
		// Choix type sauvegarde
		if (nom != null) {
			// Si on charge partie
			save = new Sauvegarde();
			save.setNom(nom);
			choixSauvegarde = 1;
		} else {
			// Si on commence une  partie
		System.out.println("Pour sauvegarder la partie apres chaque tour tapez 1 ou sinon 0");
			do {
				while (!sc.hasNextInt()) {
					System.out.println("saisir un entier entre 0 et 1");
					sc.next();
				}
				choixSauvegarde = sc.nextInt();
				sc.nextLine();
			} while (choixSauvegarde < 0 || choixSauvegarde > 1);
			int indice = 0;
			save = new Sauvegarde();
			HistoriqueSauvegarde histo = new HistoriqueSauvegarde();
			histo.recupererFichier();
			indice += histo.afficherFichier(indice);
			save.recupererFichier();
			indice += save.afficherFichier(indice);
			save.choisirNom();
		}
		// Boucle du jeu
		while (plateau.verifierFin() && (!arreter)) {
			System.out.println(plateau.toString(5)); // On affiche le plateau de jeux
			Carte joue = joueur.get(indexJoueur).jouer(); // On affiche les cartes du joueur
			System.out.println("\n Carte jouée : " + joue);
			if (joueur.get(indexJoueur) instanceof fr.unicaen.iut_caen.dut_informatique.projet_java.tortue.jeu.JoueurO && joue.getCouleur().equals("neutre")) {
				LinkedList<String> choixcouleur = new LinkedList<String>();
				choixcouleur.add(color.get((int) (Math.random()
						* (5 - 0) + 0)));
				plateau.deplacerTortues(joue, choixcouleur);
			} 
			else plateau.deplacerTortues(joue, color);

			pioche.ajouterCarte(joue);
			joueur.get(indexJoueur).addCarte(pioche.enleverCarte());
			indexJoueur++;
			if (indexJoueur == joueur.size()) indexJoueur = 0;
			if (choixSauvegarde == 1) {
				try {
					save.sauvegarder(plateau, joueur, color, pioche,
							indexJoueur);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out
			.print("\nSi vous souhaitez arréter la partie, taper 1, sinon tapez sur entrer : ");
			if (sc.nextLine().equals("1"))
				arreter = true;
			System.out
			.println("\n\n##################################################################################################################################\n");
		}

	}

	/**
	 * Permet d'archiver la partie (la mettre dans l'historique)
	 * 
	 * @see HistoriqueSauvegarde
	 */
	public static void fin() {
		Joueur gagnant;
		System.out.println(plateau.toString(5));
		gagnant=plateau.getGagnant(joueur);
		System.out.println("le joueur gagnant :");
		System.out.println(gagnant);
		HistoriqueSauvegarde histo = new HistoriqueSauvegarde();
		if (choixSauvegarde == 1) histo.deplacerFichierPartie(save.getFichier());
				try {
					histo.sauvegarderFin(5, gagnant, plateau, save
							.getFichier().getName());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
