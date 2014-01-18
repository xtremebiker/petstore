package org.petstore.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.petstore.controller.Controller;
import org.petstore.model.Pet;
import org.petstore.model.PetCategory;

/**
 * This bean just returns the list content for the pet galleries
 * 
 * @author Aritz
 * 
 */
@ManagedBean
@ViewScoped
public class CategoryListBean {

	List<Pet> petList;

	PetCategory category;

	public PetCategory getCategory() {
		return category;
	}

	public void setCategory(PetCategory category) {
		this.category = category;
	}

	public List<Pet> getPetList() {
		return petList;
	}

	/**
	 * Loads the pet list for the given category from the controller
	 * 
	 * @param cat
	 * @return
	 */
	public void loadData() {
		petList = Controller.listPets(category);
	}

}
