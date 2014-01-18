package org.petstore.view.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Checks the given value is a non-digit String
 * 
 * @author Aritz
 * 
 */
@FacesValidator
public class StringValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (!value.toString().matches("\\D*")) {
			FacesMessage msg = new FacesMessage("Parameter validation failed.",
					"The given parameter for the page title can't be considered as an string.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
}
