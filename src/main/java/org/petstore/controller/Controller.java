package org.petstore.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.petstore.model.Pet;
import org.petstore.model.PetCategory;
import org.petstore.model.PetSpecies;

/**
 * Stateless class which just returns data. It's meant to emulate a real
 * singleton controller, which receives work from each server thread and returns
 * desired results.
 * 
 * @author Aritz
 * 
 */
public abstract class Controller {

	static Map<PetCategory, List<Pet>> petsByCategory = new HashMap<PetCategory, List<Pet>>();

	static Map<PetSpecies, Pet> petsBySpecies = new HashMap<PetSpecies, Pet>();

	static Map<String, List<String>> provincesByCountry = new HashMap<String, List<String>>();

	static {

		// Create fishes
		Pet mojarra = new Pet(PetCategory.FISH, PetSpecies.MOJARRA,
				"Japanish fish", "mojarra.jpg");
		Pet puffer = new Pet(PetCategory.FISH, PetSpecies.PUFFER_FISH,
				"Fat fish", "puffer.jpg");
		Pet redLionFish = new Pet(PetCategory.FISH, PetSpecies.RED_LIONFISH,
				"Very rare and curious fish", "red-lionfish.jpg");
		petsBySpecies.put(PetSpecies.MOJARRA, mojarra);
		petsBySpecies.put(PetSpecies.PUFFER_FISH, puffer);
		petsBySpecies.put(PetSpecies.RED_LIONFISH, redLionFish);
		petsByCategory.put(PetCategory.FISH,
				Arrays.asList(mojarra, puffer, redLionFish));

		// Create monkeys
		Pet bandar = new Pet(PetCategory.MONKEY, PetSpecies.BANDAR,
				"Nice small monkey", "bandar.jpg");
		Pet squirrelMonkey = new Pet(PetCategory.MONKEY,
				PetSpecies.SQUIRREL_MONKEY, "Looks like a squirrel, don't it?",
				"squirrel-monkey.jpg");
		Pet emperorTamarin = new Pet(PetCategory.MONKEY,
				PetSpecies.EMPEROR_TAMARIN, "Great mustache!",
				"emperor-tamarin.jpg");
		petsBySpecies.put(PetSpecies.BANDAR, bandar);
		petsBySpecies.put(PetSpecies.SQUIRREL_MONKEY, squirrelMonkey);
		petsBySpecies.put(PetSpecies.EMPEROR_TAMARIN, emperorTamarin);
		petsByCategory.put(PetCategory.MONKEY,
				Arrays.asList(bandar, squirrelMonkey, emperorTamarin));

		// Provinces by country
		provincesByCountry.put("USA",
				Arrays.asList("Arizona", "Nevada", "California"));
		provincesByCountry.put("Spain",
				Arrays.asList("Navarra", "Madrid", "Barcelona"));
	}

	public static Map<String, List<String>> getProvincesByCountry() {
		// This operation would be considered as a hit to a persistence layer in
		// a real application
		return provincesByCountry;
	}

	public static List<Pet> listPets(PetCategory category) {
		// This operation would be considered as a hit to a persistence layer in
		// a real application
		System.out.println("Listing pets for " + category);
		return petsByCategory.get(category);
	}

	public static Pet petBySpecies(PetSpecies species) {
		// This operation would be considered as a hit to a persistence layer in
		// a real application
		System.out.println("Obtaining pet for " + species);
		return petsBySpecies.get(species);
	}

}
