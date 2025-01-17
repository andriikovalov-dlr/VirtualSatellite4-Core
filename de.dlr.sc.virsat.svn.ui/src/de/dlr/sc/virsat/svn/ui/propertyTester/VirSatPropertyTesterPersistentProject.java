/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package de.dlr.sc.virsat.svn.ui.propertyTester;

import org.eclipse.core.internal.propertytester.ResourcePropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import de.dlr.sc.virsat.project.ui.navigator.util.VirSatSelectionHelper;

/**
 * a class to define property tester to check if project is connected to svn or not
 * @author desh_me
 *
 */

@SuppressWarnings("restriction")
public class VirSatPropertyTesterPersistentProject extends ResourcePropertyTester {

	/**
	 * The constructor
	 */
	public VirSatPropertyTesterPersistentProject() {
		super();
	}
	
	@Override
	public boolean test(Object receiver, String method, Object[] args, Object expectedValue) {
		IStructuredSelection structuredSelection = new StructuredSelection(receiver);
		VirSatSelectionHelper virSatSelectionHelper = new VirSatSelectionHelper(structuredSelection);
		IProject iProject = virSatSelectionHelper.getProjectResource();

		if (iProject != null) {
			return super.test(iProject, method, args, expectedValue);
		} else {
			return false;
		}
	}
}
