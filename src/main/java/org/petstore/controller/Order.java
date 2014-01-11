package org.petstore.controller;

import java.io.Serializable;

import org.petstore.model.Pet;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8786671633996867120L;

	Pet pet;

	int number;

	public Order(Pet pet, int number) {
		super();
		this.pet = pet;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public Pet getPet() {
		return pet;
	}

}
