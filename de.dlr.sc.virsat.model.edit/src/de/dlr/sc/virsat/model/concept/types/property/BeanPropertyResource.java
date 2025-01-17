/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.concept.types.property;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import de.dlr.sc.virsat.model.concept.types.ABeanObject;
import de.dlr.sc.virsat.model.dvlm.categories.CategoryAssignment;
import de.dlr.sc.virsat.model.dvlm.categories.propertyinstances.PropertyinstancesPackage;
import de.dlr.sc.virsat.model.dvlm.categories.propertyinstances.ResourcePropertyInstance;

/**
 * Class to wrap Resource Property Instance
 * @author fisc_ph
 *
 */
public class BeanPropertyResource extends ABeanObject<ResourcePropertyInstance> implements IBeanProperty<ResourcePropertyInstance, URI> {

	/**
	 * this method set an specified value
	 * @param ed editing domain
	 * @param uri the specified value
	 * @return the creating command
	 */
	public Command setValue(EditingDomain ed, URI uri) {
		String uriString = uri != null ? uri.toPlatformString(false) : null;
		return SetCommand.create(ed, ti, PropertyinstancesPackage.Literals.RESOURCE_PROPERTY_INSTANCE__RESOURCE_URI, uriString);
	}
	
	/**
	 * this method set the specified value to the bean property string
	 * @param value the specified value
	 */
	public void setValue(URI value) {
		ti.setUri(value);
	}
	
	/**
	 * this method returns the bean property string value
	 * @return the bean property string value
	 */
	public URI getValue() {
		return ti.getUri();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ABeanObject) {
			ABeanObject<?> rhsBeanProperty = (ABeanObject<?>) obj;
			return ti.equals(rhsBeanProperty.getTypeInstance());
		} else if (obj instanceof CategoryAssignment) {
			return ti.equals(obj);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return ti.hashCode();
	}

	@Override
	public boolean isSet() {
		return ti.getUri() != null;
	}

	@Override
	public void unset() {
		ti.setUri(null);
	}
}
