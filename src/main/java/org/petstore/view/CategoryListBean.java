package org.petstore.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
@RequestScoped
public class CategoryListBean {

	/**
	 * Loads the pet list for the given category from the controller
	 * 
	 * @param cat
	 * @return
	 */
	public List<Pet> listPets(PetCategory cat) {
		return Controller.listPets(cat);
	}

}
