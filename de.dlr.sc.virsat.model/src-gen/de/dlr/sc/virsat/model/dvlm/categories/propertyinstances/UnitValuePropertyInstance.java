/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.dvlm.categories.propertyinstances;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Value Property Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.dlr.sc.virsat.model.dvlm.categories.propertyinstances.PropertyinstancesPackage#getUnitValuePropertyInstance()
 * @model
 * @generated
 */
public interface UnitValuePropertyInstance extends APropertyInstance, ValuePropertyInstance, IUnitPropertyInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Convenience Method to directly convert the value to its base unit
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='double value = Double.parseDouble(getValue());\r\nAUnit unit = getUnit();\r\nif (unit != null) {\r\n\tvalue = de.dlr.sc.virsat.model.dvlm.qudv.util.QudvUnitHelper.getInstance().convertFromSourceUnitToBaseUnit(unit, value);\r\n}\r\n\t\t\r\nreturn value;'"
	 * @generated
	 */
	double getValueToBaseUnit();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Convenience Method to directly set a value in the frame of the base unit and convert it to the target unit as set in the current UnitValuePropertyInstance.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='AUnit unit = getUnit();\r\nif (unit != null) {\r\n\tdouble targetValue = de.dlr.sc.virsat.model.dvlm.qudv.util.QudvUnitHelper.getInstance().convertFromBaseUnitToTargetUnit(unit, value);\r\n\tString textualValue = Double.toString(targetValue);\r\n\tsetValue(textualValue);\r\n} else {\r\n\tsetValue(Double.toString(value));\r\n}'"
	 * @generated
	 */
	void setValueAsBaseUnit(double value);

} // UnitValuePropertyInstance
