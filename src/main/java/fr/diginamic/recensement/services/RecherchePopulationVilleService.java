package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.exemple.exceptions.ClasseException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de la population d'une ville
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationVilleService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ClasseException {

		List<Ville> villes = rec.getVilles();

		System.out.println("Quel est le nom de la ville recherchée ? ");
		String choix = scanner.nextLine();
		
		// Test si ce que l'utilisateur saisie est un nom de ville inconnu
		for (Ville ville : villes) {
			if (! (ville.getNom().equalsIgnoreCase(choix))) {
				throw new ClasseException("Le nom de ville que vous avez saisie est incorrect ou n'existe pas");
			}
			
		}
		

		for (Ville ville : villes) {
			if (ville.getNom().equalsIgnoreCase(choix)
					|| ville.getNom().toLowerCase().startsWith(choix.toLowerCase())) {
				System.out.println(ville);
			}
		}
	}

}
