/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.project.resources;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.junit.Ignore;
import org.junit.Test;

import de.dlr.sc.virsat.model.dvlm.Repository;
import de.dlr.sc.virsat.model.dvlm.roles.Discipline;
import de.dlr.sc.virsat.model.dvlm.roles.RoleManagement;
import de.dlr.sc.virsat.model.dvlm.roles.RolesFactory;
import de.dlr.sc.virsat.model.dvlm.roles.RolesPackage;
import de.dlr.sc.virsat.model.dvlm.roles.UserRegistry;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralElement;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralElementInstance;
import de.dlr.sc.virsat.model.dvlm.structural.StructuralFactory;
import de.dlr.sc.virsat.model.dvlm.units.UnitManagement;
import de.dlr.sc.virsat.project.editingDomain.VirSatEditingDomainRegistry;
import de.dlr.sc.virsat.project.editingDomain.VirSatTransactionalEditingDomain;
import de.dlr.sc.virsat.project.editingDomain.commands.VirSatEditingDomainClipBoard;
import de.dlr.sc.virsat.project.editingDomain.commands.VirSatEditingDomainClipBoard.ClipboardState;
import de.dlr.sc.virsat.project.structure.VirSatProjectCommons;
import de.dlr.sc.virsat.project.structure.command.CreateAddSeiWithFileStructureCommand;
import de.dlr.sc.virsat.project.test.AProjectTestCase;

/**
 * This class tests all the capabilities of the VirSat Resource Set.
 * Special capabilities are that it automatically adds a Transactional
 * editing domain for example  and provides some convenience methods
 * to get access to specific resources of the set.
 * @author fisc_ph
 *
 */
public class VirSatResourceSetTest extends AProjectTestCase {

	private VirSatProjectCommons projectCommons;
	private StructuralElementInstance sei1;
	private StructuralElementInstance sei2;
	private StructuralElementInstance sei3;
	
	@Override
	public void setUp() throws CoreException {
		super.setUp();
		UserRegistry.getInstance().setSuperUser(true);
		
		projectCommons = new VirSatProjectCommons(testProject);
		projectCommons.createProjectStructure(null);
		
		StructuralElement se = StructuralFactory.eINSTANCE.createStructuralElement();
		se.setIsRootStructuralElement(true);

		sei1 = StructuralFactory.eINSTANCE.createStructuralElementInstance();
		sei1.setType(se);
		sei2 = StructuralFactory.eINSTANCE.createStructuralElementInstance();
		sei2.setType(se);
		sei3 = StructuralFactory.eINSTANCE.createStructuralElementInstance();
		sei3.setType(se);
		
		projectCommons.createFolderStructure(sei1, null);
		projectCommons.createFolderStructure(sei2, null);
	}
	
	@Override
	public void tearDown() throws CoreException {
		super.tearDown();
		
		VirSatResourceSet.clear();
		VirSatTransactionalEditingDomain.clearResourceEventListener();
		VirSatEditingDomainRegistry.INSTANCE.clear();
		UserRegistry.getInstance().setSuperUser(false);
	}
	
	@Test
	public void testGetResourceSet() throws CoreException {
		// First check that the transactional editing domain is well
		// added to the resource set. Which means that the project
		// registered itself to the editing domain factory
		ResourceSet rs1 = VirSatResourceSet.getResourceSet(testProject, false);
		EditingDomain rs1Ed = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
				
		assertNotNull("ResourceSet got well created", rs1);
		assertNotNull("EditingDomain got well registered", rs1Ed);
		
		
		// For a given project we should get the same resource set always
		// there has to be one resource set for each project
		ResourceSet rs2 = VirSatResourceSet.getResourceSet(testProject, false);
		EditingDomain rs2Ed = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		
		assertEquals("The ResourceSet should not change", rs1, rs2);
		assertEquals("The EditingDomain should not change", rs1Ed, rs2Ed);
		
		// Now check that a different project hands back a new ResourceSet
		// as well as a new TransactionalEditingDomain
		IProject testProject2 = createTestProject("testProject2");
		VirSatProjectCommons projectCommons2 = new VirSatProjectCommons(testProject2);
		projectCommons2.createProjectStructure(null);
		
		ResourceSet rs3 = VirSatResourceSet.getResourceSet(testProject2, false);
		EditingDomain rs3Ed = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject2);
		
		assertNotSame("The ResourceSet should not change", rs1, rs3);
		assertNotSame("The EditingDomain should not change", rs1Ed, rs3Ed);
	}

	@Test
	public void testGetProject() {
		VirSatResourceSet rs1 = VirSatResourceSet.getResourceSet(testProject, false);
		IProject project = rs1.getProject();
		assertEquals("Handed back the correct project", testProject, project);
	}

	@Test
	public void testGetRepositoryResource() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		
		// This call either gets or creates the resource in case it does not yet exist
		// Calling it multiple times should always hand back the same resource
		Resource resource1 = rs.getRepositoryResource();
		Resource resource2 = rs.getRepositoryResource();
		
		assertEquals("Got the same resource", resource1, resource2);
		
		// Make sure the resource is different to some other resource
		Resource resourceO = rs.getUnitManagementResource();
		assertNotSame("Resources are different", resource1, resourceO);
	}

	@Test
	public void testGetRoleManagementResource() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		
		// This call either gets or creates the resource in case it does not yet exist
		// Calling it multiple times should always hand back the same resource
		Resource resource1 = rs.getRoleManagementResource();
		Resource resource2 = rs.getRoleManagementResource();
		
		assertEquals("Got the same resource", resource1, resource2);
		
		// Make sure the resource is different to some other resource
		Resource resourceO = rs.getUnitManagementResource();
		assertNotSame("Resources are different", resource1, resourceO);
	}

	@Test
	public void testGetUnitManagementResource() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		
		// This call either gets or creates the resource in case it does not yet exist
		// Calling it multiple times should always hand back the same resource
		Resource resource1 = rs.getUnitManagementResource();
		Resource resource2 = rs.getUnitManagementResource();
		
		assertEquals("Got the same resource", resource1, resource2);
		
		// Make sure the resource is different to some other resource
		Resource resourceO = rs.getRoleManagementResource();
		assertNotSame("Resources are different", resource1, resourceO);
	}

	@Test
	public void testGetStructuralElementResource() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		
		// This call either gets or creates the resource in case it does not yet exist
		// Calling it multiple times should always hand back the same resource
		Resource resource1 = rs.getStructuralElementInstanceResource(sei1);
		Resource resource2 = rs.getStructuralElementInstanceResource(sei1);
		
		IFile file = projectCommons.getStructuralElementInstanceFile(sei1);
		IFolder folder = projectCommons.getStructuralElemntInstanceFolder(sei1);
		
		assertTrue("File got correctly created", file.exists());
		assertTrue("Folder got correctly creatred", folder.exists());

		assertEquals("Got the same resource", resource1, resource2);
		assertTrue("Resource does not contain SEI", resource1.getContents().isEmpty());
		assertTrue("Resource does not contain SEI", resource2.getContents().isEmpty());

		// Make sure the resource is different to some other resource
		Resource resourceO = rs.getStructuralElementInstanceResource(sei2);
		assertNotSame("Resources are different", resource1, resourceO);
	}
	
	@Test
	public void testGetAndAddStructuralElementResource() {
		VirSatResourceSet rs = VirSatResourceSet.createUnmanagedResourceSet(testProject);
		
		// This call either gets or creates the resource in case it does not yet exist
		// Calling it multiple times should always hand back the same resource
		Resource resource1 = rs.getAndAddStructuralElementInstanceResource(sei1);
		
		assertTrue("Resource does contain SEI", resource1.getContents().contains(sei1));
	}
	
	@Test
	public void testRemoveStructuralElementResource() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);

		// This call either gets or creates the resource in case it does not yet exist
		// Calling it multiple times should always hand back the same resource
		Resource resource1 = rs.getStructuralElementInstanceResource(sei1);
		
		IFile file = projectCommons.getStructuralElementInstanceFile(sei1);
		IFolder folder = projectCommons.getStructuralElemntInstanceFolder(sei1);
		
		assertTrue("File got correctly created", file.exists());
		assertTrue("Folder got correctly creatred", folder.exists());
		
		assertEquals("ResourceSet contains exactly one resource", 1, rs.getResources().size());		
		assertThat("ResourceSet contains the correct Resource", rs.getResources(), hasItems(resource1));
		
		rs.removeStructuralElementInstanceResource(sei1);
		assertNull("Resource got unloaded", resource1.getResourceSet());
		assertEquals("ResourceSet contains no resource", 0, rs.getResources().size());
		
		assertFalse("File got correctly removed", file.exists());
		assertFalse("Folder got correctly removed", folder.exists());
	}

	@Test
	public void testGetRepository() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		TransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		
		Command cmd = rs.initializeModelsAndResourceSet(null, rsEd);
		rsEd.getCommandStack().execute(cmd);
		Repository modelExists = rs.getRepository();

		assertNotNull("Model is now well initialized", modelExists);
	}

	@Test
	public void testGetRoleManagement() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		TransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		
		Command cmd = rs.initializeModelsAndResourceSet(null, rsEd);
		rsEd.getCommandStack().execute(cmd);
		RoleManagement modelExists = rs.getRoleManagement();
		
		assertNotNull("Model is now well initialized", modelExists);
	}

	@Test
	public void testGetUnitManagement() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		TransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		
		Command cmd = rs.initializeModelsAndResourceSet(null, rsEd);
		rsEd.getCommandStack().execute(cmd);
		UnitManagement modelExists = rs.getUnitManagement();
		
		assertNotNull("Model is now well initialized", modelExists);
	}

	@Test
	public void testInitializeModelsAndResourceSet() {
		testGetRepository();
		testGetRoleManagement();
		testGetUnitManagement();
	}

	@Test
	public void testInitializeStructuralElement() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		TransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		
		Command cmd = rs.initializeModelsAndResourceSet(null, rsEd);
		rsEd.getCommandStack().execute(cmd);

		Resource resourceIse1 = rs.getStructuralElementInstanceResource(sei1);
		
		assertNotNull("Model is now well initialized", resourceIse1);
	}

	@Test
	public void testReloadResource() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		VirSatTransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		Command cmd = rs.initializeModelsAndResourceSet(null, rsEd);
		rsEd.getCommandStack().execute(cmd);
		rsEd.saveAll();
		
		Resource resource1 = rs.getRoleManagementResource();
		RoleManagement rmOld = rs.getRoleManagement();
		
		Resource resource2 = rs.reloadResource(resource1);
		RoleManagement rmNew = rs.getRoleManagement();
		
		assertEquals("The resource itself actually stays the same", resource1, resource2);
		assertNotSame("The model objects are different", rmOld, rmNew);
	}

	@Test
	public void testGetVirSatResourceSet() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		TransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		Command cmd = rs.initializeModelsAndResourceSet(null, rsEd);
		rsEd.getCommandStack().execute(cmd);
		
		RoleManagement rm = rs.getRoleManagement();
		Discipline newDiscipline = RolesFactory.eINSTANCE.createDiscipline();
		
		// discipline does not yet have a ResourceSet since it is not assigned to one
		ResourceSet rsNewDispline = VirSatResourceSet.getVirSatResourceSet(newDiscipline);
		assertNull("ResourceSet does not yet exist", rsNewDispline);

		// The existing object in the managed resourceSet does have a resource set
		Discipline existingDiscipline = rm.getDisciplines().get(0);
		ResourceSet rsExsistingDispline = VirSatResourceSet.getVirSatResourceSet(existingDiscipline);
		assertNotNull("ResourceSet does exist", rsExsistingDispline);
	}
	
	@Ignore
	@Test
	public void testReloadResourceWithCommand() {
		UserRegistry.getInstance().setSuperUser(true);
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		VirSatTransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		Command cmd = rs.initializeModelsAndResourceSet(null, rsEd);
		rsEd.getCommandStack().execute(cmd);
		
		Resource resource1 = rs.getRoleManagementResource();
		RoleManagement rmOld = rs.getRoleManagement();
		
		Discipline discipline = RolesFactory.eINSTANCE.createDiscipline();
		Command addCmd = AddCommand.create(rsEd, rmOld, RolesPackage.ROLE_MANAGEMENT__DISCIPLINES, discipline);
		rsEd.getCommandStack().execute(addCmd);

		assertThat("New discipline has been added to role management", rmOld.getDisciplines(), hasItems(discipline));
		
		Command removeCmd = RemoveCommand.create(rsEd, rmOld, RolesPackage.ROLE_MANAGEMENT__DISCIPLINES, discipline);
		rsEd.getCommandStack().execute(removeCmd);
		rsEd.saveAll();
		
		assertThat("New discipline has been removed from role management", rmOld.getDisciplines(), not(hasItems(discipline)));

		List<Object> testList = new ArrayList<>();
		VirSatEditingDomainClipBoard.INSTANCE.copyClipboard(rsEd, testList);
		
		// Trigger the external reload of resources which will invalidate the command stack and also flush the ClipBoard
		assertTrue("Remove Command can Undo", removeCmd.canUndo());
		rsEd.reloadAll();

		// Now anew role management is actually loaded
		Resource resource2 = rs.reloadResource(resource1);
		RoleManagement rmNew = rs.getRoleManagement();
		
		assertEquals("The resource itself actually stays the same", resource1, resource2);
		assertNotSame("The model objects are different", rmOld, rmNew);

		assertNull("Clipboard is flushed", rsEd.getClipboard());
		assertEquals("State reveretd to empty", ClipboardState.EMPTY, VirSatEditingDomainClipBoard.INSTANCE.getClipboardState(rsEd));
		
		assertTrue("The command itself could be undone", removeCmd.canUndo());
		assertFalse("The Command Stack has been flushed", rsEd.getCommandStack().canUndo());
	}
	
	@Test
	public void testDispose() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		TransactionalEditingDomain rsEdByRs = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		TransactionalEditingDomain rsEdByProject = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		
		assertNotNull("Here the resourceSet is well registered", rsEdByRs);
		assertNotNull("Here the resourceSet is well registered", rsEdByProject);
		
		rs.dispose();

		rsEdByRs = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		rsEdByProject = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);

		assertNull("Here the resourceSet is not registered anymore", rsEdByRs);
		assertNull("Here the resourceSet is not registered anymore", rsEdByProject);

		// Getting a new ResourceSet for the project now hands back a complete new ResourceSet;
		VirSatResourceSet rs2 = VirSatResourceSet.getResourceSet(testProject, false);
		
		assertNotSame("ResourceSets for the same project are now different", rs, rs2);
	}

	private static final String MY_USER_NAME = "my_user_name";
	
	/**
	 * adds one discipline (mine)
	 * adds three seis to repository - with my discipline, system discipline (not mine) and without discipline
	 */
	private void createThreeSeisWithDifferentDisciplines() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		VirSatTransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		RoleManagement rm = rs.getRoleManagement();
		Discipline myDiscipline = RolesFactory.eINSTANCE.createDiscipline();
		myDiscipline.setName("MyDiscipline");
		myDiscipline.setUser(MY_USER_NAME);
		
		rsEd.getCommandStack().execute(AddCommand.create(rsEd, rm, RolesPackage.Literals.ROLE_MANAGEMENT__DISCIPLINES, myDiscipline));
		
		Discipline systemDiscipline = rm.getDisciplines().get(0);
		
		sei1.setAssignedDiscipline(myDiscipline);
		sei2.setAssignedDiscipline(systemDiscipline);
		
		Repository repo = rs.getRepository();
		rsEd.getCommandStack().execute(CreateAddSeiWithFileStructureCommand.create(rsEd, repo, sei1));
		rsEd.saveAll();
		rsEd.getCommandStack().execute(CreateAddSeiWithFileStructureCommand.create(rsEd, repo, sei2));
		rsEd.saveAll();
		rsEd.getCommandStack().execute(CreateAddSeiWithFileStructureCommand.create(rsEd, repo, sei3));
	}
	
	/**
	 * sets current user super user
	 */
	private void setSuperUser() {
		UserRegistry ur = UserRegistry.getInstance();
		ur.setSuperUser(true);
		ur.setUser(MY_USER_NAME, 0);
	}
	
	/**
	 * sets current user normal (not super user)
	 */
	private void setNormalUser() {
		UserRegistry ur = UserRegistry.getInstance();
		ur.setSuperUser(false);
		ur.setUser(MY_USER_NAME, 0);
	}
	
	@Test
	public void testHasWritePermissionNormalUser() {
		VirSatResourceSet rs = VirSatResourceSet.getResourceSet(testProject, false);
		VirSatTransactionalEditingDomain rsEd = VirSatEditingDomainRegistry.INSTANCE.getEd(testProject);
		Command cmd = rs.initializeModelsAndResourceSet(null, rsEd);
		rsEd.getCommandStack().execute(cmd);
		rsEd.saveAll();

		createThreeSeisWithDifferentDisciplines();
		setNormalUser();
		
		Resource resource1 = rs.getStructuralElementInstanceResource(sei1);
		Resource resource2 = rs.getStructuralElementInstanceResource(sei2);
		Resource resource3 = rs.getStructuralElementInstanceResource(sei3);
		
		assertTrue("I have right permission for resource with mine SEI", rs.hasWritePermission(resource1));
		assertFalse("I don't have right permission for resource with not mine SEI", rs.hasWritePermission(resource2));
		assertFalse("I don't have right permission for resource with SEI without discipline", rs.hasWritePermission(resource3));

		setSuperUser();
		
		assertTrue("SuperUser has right permission for resource with mine SEI", rs.hasWritePermission(resource1));
		assertTrue("SuperUser has right permission for resource with not mine SEI", rs.hasWritePermission(resource2));
		assertTrue("SuperUser has right permission for resource with SEI without discipline", rs.hasWritePermission(resource3));
	}
	
	@Test
	public void testLoadAllResources() {
		VirSatResourceSet resSet = VirSatResourceSet.createUnmanagedResourceSet(testProject);
		resSet.initializeModelsAndResourceSet();
		
		Repository repo = resSet.getRepository();
		
		StructuralElement se = StructuralFactory.eINSTANCE.createStructuralElement();
		se.setIsApplicableForAll(true);
		
		//CHECKSTYLE:OFF
		StructuralElementInstance sei1 = StructuralFactory.eINSTANCE.createStructuralElementInstance();
		StructuralElementInstance sei2 = StructuralFactory.eINSTANCE.createStructuralElementInstance();
		StructuralElementInstance sei2_1 = StructuralFactory.eINSTANCE.createStructuralElementInstance();
		StructuralElementInstance sei2_1_1 = StructuralFactory.eINSTANCE.createStructuralElementInstance();
		sei1.setType(se);
		sei2.setType(se);
		sei2_1.setType(se);
		sei2_1_1.setType(se);
		
		Resource resSei1 = resSet.getAndAddStructuralElementInstanceResource(sei1);
		Resource resSei2 = resSet.getAndAddStructuralElementInstanceResource(sei2);
		Resource resSei2_1 = resSet.getAndAddStructuralElementInstanceResource(sei2_1);
		Resource resSei2_1_1 = resSet.getAndAddStructuralElementInstanceResource(sei2_1_1);
		//CHECKSTYLE:ON
		
		repo.getRootEntities().add(sei1);
		repo.getRootEntities().add(sei2);

		sei2.getChildren().add(sei2_1);
		sei2_1.getChildren().add(sei2_1_1);
		
		resSet.saveAllResources(new NullProgressMonitor());
		
		resSei1.unload();
		resSei2.unload();
		resSei2_1.unload();
		resSei2_1_1.unload();
		
		resSet.loadAllResources();
		
		assertTrue("Resource got deserialized from persistant storage", resSei1.isLoaded());
		assertTrue("Resource got deserialized from persistant storage", resSei2.isLoaded());
		assertTrue("Resource got deserialized from persistant storage", resSei2_1.isLoaded());
		assertTrue("Resource got deserialized from persistant storage", resSei2_1_1.isLoaded());
		
		// now the final test case, unloading all data and then see if they get properly reloaded
		resSet.getResources().forEach((res) -> res.unload());
		
		resSet.loadAllResources();
		
		assertTrue("Resource got deserialized from persistant storage", resSei1.isLoaded());
		assertTrue("Resource got deserialized from persistant storage", resSei2.isLoaded());
		assertTrue("Resource got deserialized from persistant storage", resSei2_1.isLoaded());
		assertTrue("Resource got deserialized from persistant storage", resSei2_1_1.isLoaded());
	}
}
