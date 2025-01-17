/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.swtbot.test;

import static org.eclipse.swtbot.swt.finder.SWTBotAssert.assertText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.swt.SWT;
import org.eclipse.swtbot.swt.finder.utils.SWTUtils;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTable;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Before;
import org.junit.Test;

import de.dlr.sc.virsat.concept.unittest.util.ConceptXmiLoader;
import de.dlr.sc.virsat.model.dvlm.concepts.Concept;
import de.dlr.sc.virsat.model.extension.ps.model.ProductTree;
import de.dlr.sc.virsat.model.extension.ps.model.ProductTreeDomain;
import de.dlr.sc.virsat.model.extension.budget.mass.model.MassEquipment;
import de.dlr.sc.virsat.model.extension.budget.mass.model.MassSummary;

/**
 * This class tests the calculation mass equipment etc
 * @author bell_Er
 *
 */
public class CalculationTest extends ASwtBotTestCase {
	
	private static final int THREE = 3;
	private SWTBotTreeItem repositoryNavigatorItem;

	SWTBotTreeItem productTree;
	SWTBotTreeItem productTreeDomain;
	SWTBotTreeItem elementDefinition;
	
	SWTBotTreeItem massEquipment1;
	SWTBotTreeItem massEquipment2;
	SWTBotTreeItem massSummary;
	
	protected Concept conceptMass;
	
	@Before
	public void before() throws Exception {
		super.before();
		// create the necessary items for the test
		conceptMass = ConceptXmiLoader.loadConceptFromPlugin(de.dlr.sc.virsat.model.extension.budget.mass.Activator.getPluginId() + "/concept/concept.xmi");	
		repositoryNavigatorItem = bot.tree().expandNode(PROJECTNAME, "Repository");
		productTree = addElement(ProductTree.class, conceptPs, repositoryNavigatorItem);
		massEquipment1 = addElement(MassEquipment.class, conceptMass, productTree);
		openEditor(massEquipment1);
	}
	@Test
	public void calculationsForMassEquipmentTest() {
		// test margin calculation
		renameField(MassEquipment.PROPERTY_MASS, "45");
		save();
		waitCalculationBuilder(); 
		assertText("54.0", bot.textWithLabel(MassEquipment.PROPERTY_MASSWITHMARGIN));
		// add another mass equipment
		productTreeDomain = addElement(ProductTreeDomain.class, conceptPs, productTree);	
		massEquipment2 = addElement(MassEquipment.class, conceptMass, productTreeDomain);
		openEditor(massEquipment2);
		renameField(MassEquipment.PROPERTY_MASS, "55");
		waitCalculationBuilder(); 
		// add massSummary and test calculation
		massSummary = addElement(MassSummary.class, conceptMass, productTree);
		openEditor(massSummary);
		waitCalculationBuilder(); 
		assertText("100.0", bot.textWithLabel(MassEquipment.PROPERTY_MASS));
		assertText("120.0", bot.textWithLabel(MassEquipment.PROPERTY_MASSWITHMARGIN));
	}
	@Test
	public void addRemoveEquationTest() {
		bot.button("Add Equation").click();
		SWTBotTable allPropertyTable = getSWTBotTable(massEquipment1, "Table Section for: Equations");
		assertEquals(THREE, allPropertyTable.rowCount());
		allPropertyTable.click(0, 0);
		bot.button("Remove Equation").click();
		assertEquals(2, allPropertyTable.rowCount());	
	}
	@Test
	public void calculatedFieldsAreReadOnlyTest() {
		assertTrue(SWTUtils.hasStyle(bot.textWithLabel(MassEquipment.PROPERTY_MASSWITHMARGIN).widget, SWT.READ_ONLY));
	}
}
