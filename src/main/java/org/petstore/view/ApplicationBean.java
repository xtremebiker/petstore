package org.petstore.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * A managed bean which is built only once for the whole application. Keeps
 * global data. eager=true means the bean will be created by the context when
 * application starts, without having to reference it.
 * 
 * @author Aritz
 * 
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class ApplicationBean {

	private static final int LAST_DELIVERY_NUM = 5;

	/**
	 * Keeps a list of the countries where the clients have bofught from
	 */
	private List<String> lastCountriesForDeliveries = new ArrayList<String>();

	public ApplicationBean() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public void addCountryForDelivery(String country) {
		if (lastCountriesForDeliveries.size() == LAST_DELIVERY_NUM) {
			lastCountriesForDeliveries.remove(LAST_DELIVERY_NUM-1);
		}
		lastCountriesForDeliveries.add(0, country);
	}

	/**
	 * 
	 * @return the minor JSF implementation version (2.1.x)
	 */
	public String getJsfVersion() {
		try {
			return Package.getPackage("com.sun.faces")
					.getImplementationVersion();
		} catch (Exception e) {
			return "";
		}
	}

	public List<String> getLastCountriesForDeliveries() {
		return lastCountriesForDeliveries;
	}

}
