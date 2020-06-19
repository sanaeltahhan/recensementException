package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.exemple.exceptions.ClasseException;
import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

/**
 * Recherche et affichage de toutes les villes d'un département dont la population est comprise
 * entre une valeur min et une valeur max renseignées par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ClasseException {
		

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		
		List<Ville> villes = rec.getVilles();
		boolean trouve = false;
		// Test si ce que l'utilisateur saisie est un departement inconnu
		for (Ville ville : villes) {

			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				trouve = true;
				break;
			}
		}
		if (! trouve) {
			throw new ClasseException("Le numero de département que vous avez saisie est incorrect");
		}

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();

		// Test si ce que l'utilisateur saisie est un chiffre
		if (! NumberUtils.isDigits(saisieMin)) {
			throw new ClasseException("Veuillez renseigner un chiffre.");	
		}
		
		// Test si ce que l'utilisateur saisie est un chiffre inferieur à 0
		if (NumberUtils.createInteger(saisieMin) < 0) {
			throw new ClasseException("Le min ne peux pas être inférieur à 0.");	
		}
		
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		
		// Test si ce que l'utilisateur saisie est un chiffre
		if (! NumberUtils.isDigits(saisieMax)) {
			throw new ClasseException("Veuillez renseigner un chiffre.");	
		}
		
		// Test si ce que l'utilisateur saisie est un chiffre inferieur à 0
		if (NumberUtils.createInteger(saisieMin) < 0) {
			throw new ClasseException("Le max ne peux pas être inférieur à 0.");	
		}
		
		// Test si ce que l'utilisateur saisie est un chiffre inferieur à 0
		if (NumberUtils.createInteger(saisieMax) < NumberUtils.createInteger(saisieMin)) {
			throw new ClasseException("Le max ne peux pas être inférieur à min.");	
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;
				

		//List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}

}
