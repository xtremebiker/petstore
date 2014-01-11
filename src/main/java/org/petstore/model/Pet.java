package org.petstore.model;

import java.io.Serializable;

public class Pet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PetCategory category;

	PetSpecies species;

	String description;

	public PetCategory getCategory() {
		return category;
	}

	public PetSpecies getSpecies() {
		return species;
	}

	public String getDescription() {
		return description;
	}

	public String getImagePath() {
		return imagePath;
	}

	String imagePath;

	public Pet(PetCategory category, PetSpecies species, String description,
			String imagePath) {
		super();
		this.category = category;
		this.species = species;
		this.description = description;
		this.imagePath = imagePath;
	}

}
