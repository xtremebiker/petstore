package org.petstore.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.petstore.controller.Controller;

/**
 * Performs a delivery with the pets that are currently in the chart
 * 
 * @author Aritz
 * 
 */
@ManagedBean
@ViewScoped
public class DeliveryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, List<String>> provincesByCountry;

	private String country;

	private String province;

	private List<String> countries;

	private List<String> provinces;

	private String name;

	private String email;

	private String phoneNumber;

	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;

	@ManagedProperty(value = "#{sessionBean}")
	private SessionBean sessionBean;

	public DeliveryBean() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public void countryChanged() {
		province = null;
		provinces = provincesByCountry.get(country);
	}

	/**
	 * Performs a new delivery. Here it adds a new message confirming the
	 * delivery and clears the chart. In a real system it should take care of
	 * persist it.
	 * 
	 * @return
	 */
	public String deliverIt() {
		FacesMessage message = new FacesMessage("Your package with "
				+ sessionBean.getPetNumInChart()
				+ " pets is going to be delivered to " + this.name
				+ " in few hours, enjoy them!");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, message);
		sessionBean.clearOrders();
		applicationBean.addCountryForDelivery(country);
		return "/main";
	}

	public List<String> getCountries() {
		return countries;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getProvince() {
		return province;
	}

	public List<String> getProvinces() {
		return provinces;
	}

	public void loadData() {
		// Loads the country stuff
		provincesByCountry = Controller.getProvincesByCountry();
		countries = new ArrayList<String>(provincesByCountry.keySet());
		country = provincesByCountry.keySet().iterator().next();
		provinces = provincesByCountry.get(country);
	}

	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
