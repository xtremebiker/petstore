package org.petstore.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.petstore.controller.Order;
import org.petstore.model.Pet;

/**
 * Session scoped managed bean. Takes care about our shoping chart
 * 
 * @author Aritz
 * 
 */
@ManagedBean
@SessionScoped
public class SessionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3704856573588113038L;

	List<Order> orders = new ArrayList<Order>();

	public SessionBean() {
		System.out.println("Created " + this);
	}

	public void clearOrders() {
		orders.clear();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public int getPetNumInChart() {
		int total = 0;
		for (Order o : orders) {
			total += o.getNumber();
		}
		return total;
	}

	/**
	 * Logs out and invalidates Http session
	 * 
	 * @see http 
	 *      ://stackoverflow.com/questions/5619827/how-to-invalidate-session-
	 *      in-jsf-2-0
	 * @return
	 */
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext()
				.invalidateSession();
		return "/index?faces-redirect=true";
	}

	public void makeAnOrder(Pet pet, Integer num) {
		orders.add(new Order(pet, num));
	}

	public void removeOrder(Order order) {
		orders.remove(order);
	}

}
