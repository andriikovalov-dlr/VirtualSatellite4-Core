/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.project.test;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import de.dlr.sc.virsat.model.dvlm.Repository;
import de.dlr.sc.virsat.project.Activator;
import de.dlr.sc.virsat.project.editingDomain.VirSatEditingDomainRegistry;
import de.dlr.sc.virsat.project.editingDomain.VirSatTransactionalEditingDomain;
import de.dlr.sc.virsat.project.resources.VirSatResourceSet;

/**
 * Abstract test case which creates a project for further testing
 * @author fisc_ph
 *
 */
public abstract class AProjectTestCase {

	protected static final String TEST_PROJECT_NAME = "testProject";
	private static final String JUNIT_DEBUG_PROJECT_TEST_CASE = "JUNIT_DEBUG_PROJECT_TEST_CASE";
	private static final String JUNIT_DEBUG_PROJECT_TEST_CASE_TRUE = "true"; 
	protected IProject testProject;
	protected VirSatTransactionalEditingDomain editingDomain;
	protected Repository repository;
	
	
	private List<IProject> testProjects = new ArrayList<>();
	
	/**
	 * Use this method to create a new test project and to remember it for the test case.
	 * Remembering it means that it will be removed by the tear down method.
	 * @param projectName The name of the Test Project
	 * @return The instance of the Test Project in the Workspace as IProject
	 * @throws CoreException May throw an exception which can be handled by the test case itself
	 */
	protected IProject createTestProject(String projectName) throws CoreException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		testProjects.add(project);
		if (!project.exists()) {
			project.create(null);
			project.open(null);
			Activator.getDefault().getLog().log(new Status(Status.INFO, Activator.getPluginId(), "Created new test project " +  project.getName()));
		}
		return project;
	}
	
	@Rule 
	public TestName testMethodName = new TestName();
	
	@Before
	public void setUp() throws CoreException {
		if (JUNIT_DEBUG_PROJECT_TEST_CASE_TRUE.equalsIgnoreCase(System.getenv(JUNIT_DEBUG_PROJECT_TEST_CASE))) {
			System.out.println("AProjectTestCase-Debug: " + this.getClass().getSimpleName() + "." + testMethodName.getMethodName() + " - setUp()");
		}

		testProject = createTestProject(TEST_PROJECT_NAME + "_" + this.getClass().getSimpleName());
		
		//addEditingDomain();
	}
	
	@After
	public void tearDown() throws CoreException {
		if (JUNIT_DEBUG_PROJECT_TEST_CASE_TRUE.equalsIgnoreCase(System.getenv(JUNIT_DEBUG_PROJECT_TEST_CASE))) {
			System.out.println("AProjectTestCase-Debug: " + this.getClass().getSimpleName() + "." + testMethodName.getMethodName() + " - tearDown()");
		}

		if (editingDomain != null) {
			VirSatTransactionalEditingDomain.stopResourceChangeEventThread();
			editingDomain.dispose();
		}
		
		// Make sure all projects that were created get removed again
		for (IProject project : testProjects) {
			project.delete(true, null);
			Activator.getDefault().getLog().log(new Status(Status.INFO, Activator.getPluginId(), "Deleted test project " +  project.getName()));
		}
	}
	/**
	 * Creates the editing domain
	 * 
	 */
	protected void addEditingDomainAndRepository() {
		VirSatResourceSet resSetRepositoryTarget = VirSatResourceSet.getResourceSet(testProject, false);
		editingDomain = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		Command cmd = resSetRepositoryTarget.initializeModelsAndResourceSet(null, editingDomain);
		editingDomain.getCommandStack().execute(cmd);
		editingDomain.saveAll();

		repository = resSetRepositoryTarget.getRepository();
	}
}
