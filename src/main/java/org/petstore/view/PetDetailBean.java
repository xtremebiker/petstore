package org.petstore.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.petstore.controller.Controller;
import org.petstore.model.Pet;
import org.petstore.model.PetSpecies;

@ManagedBean
@ViewScoped
public class PetDetailBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PetSpecies species;

	private Pet pet;

	private Integer orderNum = 1;

	@ManagedProperty(value = "#{sessionBean}")
	SessionBean sessionBean;

	private List<Integer> orderNums = Arrays.asList(1, 2, 3, 4, 5);

	public Integer getOrderNum() {
		return orderNum;
	}

	public List<Integer> getOrderNums() {
		return orderNums;
	}

	public Pet getPet() {
		return pet;
	}

	public PetSpecies getSpecies() {
		return species;
	}

	public void loadData() {
		// Load the pet object based into the species given
		pet = Controller.petBySpecies(species);
	}

	public String makeAnOrder() {
		sessionBean.makeAnOrder(pet, orderNum);
		FacesMessage message = new FacesMessage(
				"Your order has been successfully added to the chart!");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
		return "/main?faces-redirect=true";
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public void setSpecies(PetSpecies species) {
		this.species = species;
	}

}
