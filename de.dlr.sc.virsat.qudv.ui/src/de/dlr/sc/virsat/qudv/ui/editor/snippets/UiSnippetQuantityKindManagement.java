/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.qudv.ui.editor.snippets;

import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import de.dlr.sc.virsat.model.dvlm.qudv.AQuantityKind;
import de.dlr.sc.virsat.model.dvlm.qudv.DerivedQuantityKind;
import de.dlr.sc.virsat.model.dvlm.qudv.QudvPackage;
import de.dlr.sc.virsat.model.dvlm.qudv.SimpleQuantityKind;
import de.dlr.sc.virsat.model.dvlm.qudv.SystemOfQuantities;
import de.dlr.sc.virsat.model.dvlm.units.UnitManagement;
import de.dlr.sc.virsat.project.resources.VirSatResourceSet;
import de.dlr.sc.virsat.project.ui.contentProvider.VirSatFilteredWrappedTreeContentProvider;
import de.dlr.sc.virsat.project.ui.labelProvider.VirSatTransactionalAdapterFactoryLabelProvider;
import de.dlr.sc.virsat.qudv.ui.wizards.DerivedQuantityKindWizard;
import de.dlr.sc.virsat.qudv.ui.wizards.QudvQuantityKindSetupWizard;
import de.dlr.sc.virsat.qudv.ui.wizards.SimpleQuantityKindWizard;
import de.dlr.sc.virsat.uiengine.ui.editor.snippets.AUiSnippetEStructuralFeatureTable;
import de.dlr.sc.virsat.uiengine.ui.editor.snippets.IUiSnippet;

/**
 * class ui snippet for quantity kind management implements the interface ui snippet
 * @author scha_vo
 *
 */
public class UiSnippetQuantityKindManagement extends AUiSnippetEStructuralFeatureTable implements IUiSnippet {
	
	private static final String SECTION_NAME = "Quantity Kind Management";

	private Button buttonAdd;
	private Button buttonRemove;
	private Button buttonEdit;
	
	private static final String BUTTON_ADD_TEXT = "Add Quantity Kind";
	private static final String BUTTON_REMOVE_TEXT = "Remove Quantity Kind";
	private static final String BUTTON_EDIT_TEXT = "Edit Quantity Kind";
	
	private static final String COLUMN_TEXT_QK_NAME = "Quantity Kind Name";
	private static final String COLUMN_TEXT_SYMBOL = "Symbol";
	
	/**
	 * Constructor for this class to instantiate a UI Snippet
	 */
	public UiSnippetQuantityKindManagement() {
		super(QudvPackage.Literals.SYSTEM_OF_UNITS__SYSTEM_OF_QUANTITIES);
	}
	
	@Override
	protected String getSectionHeading() {
		return super.getSectionHeading() + SECTION_NAME;
	}

	@Override
	protected IContentProvider getTableContentProvider() {
		//Get filtered content showing all AUnits 
		VirSatFilteredWrappedTreeContentProvider filteredContentProvider = new VirSatFilteredWrappedTreeContentProvider(adapterFactory);
		filteredContentProvider.addClassFilterToGetChildren(AQuantityKind.class);
		filteredContentProvider.addClassFilterToGetElement(AQuantityKind.class);
		return filteredContentProvider;
	}
	
	@Override
	protected ITableLabelProvider getTableLabelProvider() {
		VirSatTransactionalAdapterFactoryLabelProvider labelProvider;
		
		labelProvider = new VirSatTransactionalAdapterFactoryLabelProvider(adapterFactory) {
			@Override
			public String getColumnText(Object object, int columnIndex) {
				super.getColumnText(object, columnIndex);
				if (object instanceof AQuantityKind) {
					AQuantityKind unit = (AQuantityKind) object;
					
					switch (columnIndex) {
						case 0:
							return unit.getName();
						case 1:
							return unit.getSymbol();
						default:
							break;
					}
				}
				return super.getText(object);
			}
		};
		
		return labelProvider;		
	}
	
	@Override
	protected void createTableColumns(EditingDomain editingDomain) {
	    // Column Quantity Kind Name
		createDefaultColumn(tableViewer, COLUMN_TEXT_QK_NAME);
	
		//Column Symbol
		createDefaultColumn(tableViewer, COLUMN_TEXT_SYMBOL);
	}
	
	@Override
	protected void setTableViewerInput(EditingDomain editingDomain) {
		VirSatResourceSet virSatResourceSet = VirSatResourceSet.getVirSatResourceSet(model);
		SystemOfQuantities systemOfQuantities = virSatResourceSet.getUnitManagement().getSystemOfUnit().getSystemOfQuantities().get(0);
		tableViewer.setInput(systemOfQuantities);
	}
	
	@Override
	protected Composite createButtons(FormToolkit toolkit, Composite sectionBody) {
		Composite compositeButtons = super.createButtons(toolkit, sectionBody);
		
		buttonAdd = toolkit.createButton(compositeButtons, BUTTON_ADD_TEXT, SWT.PUSH);
		buttonRemove = toolkit.createButton(compositeButtons, BUTTON_REMOVE_TEXT, SWT.PUSH);
		buttonEdit = toolkit.createButton(compositeButtons, BUTTON_EDIT_TEXT, SWT.PUSH);
		
		// Mark the Controls which should be checked for write access
		checkWriteAccess(buttonAdd, buttonRemove, buttonEdit);
		
		return compositeButtons;
	}	

	@Override
	protected void addButtonSelectionListeners(Composite composite, EditingDomain editingDomain) {
		
		buttonAdd.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// some code to create a unit via our QudvWizard 
				
				new WizardDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), new QudvQuantityKindSetupWizard((UnitManagement) model)).open();
				// the wizard guides the user through the possible steps to add a unit
				// at the end, on the performFinish() method it executes a cmd over the commandStack which ends the new unit in the proper way.
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});

		buttonRemove.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<?> selection = tableViewer.getStructuredSelection().toList();
				if (!selection.isEmpty()) {
					Command cmd = DeleteCommand.create(editingDomain, selection);
					editingDomain.getCommandStack().execute(cmd);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				List<?> selection = tableViewer.getStructuredSelection().toList();
				Command cmd = DeleteCommand.create(editingDomain, selection);
				boolean canExecute = !selection.isEmpty() && cmd.canExecute();
				buttonRemove.setEnabled(canExecute);
			}
		});
		
		buttonEdit.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AQuantityKind quantityKind = getFirstSelectedQuantityKind();
				if (quantityKind instanceof SimpleQuantityKind) {
					SimpleQuantityKind simpleQK = (SimpleQuantityKind) quantityKind;
					new WizardDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), new SimpleQuantityKindWizard((UnitManagement) model, simpleQK)).open();
				} else if (quantityKind instanceof DerivedQuantityKind) {
					DerivedQuantityKind derivedQK = (DerivedQuantityKind) quantityKind;
					new WizardDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), new DerivedQuantityKindWizard((UnitManagement) model, derivedQK)).open();
			
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
	}
	
	@Override
	public boolean isActive(EObject model) {
		return model instanceof UnitManagement;
	}
	
	/**
	 * Returns the first selected Mode in the table
	 * @return null if selection is not a Mode
	 */
	private AQuantityKind getFirstSelectedQuantityKind() {
		IStructuredSelection selection = (IStructuredSelection) getSelection();
		
		// Don't work on an empty selection
		if (selection.isEmpty()) {
			return null;
		}
		
		Object obj = selection.toList().get(0);
		if (obj instanceof AQuantityKind) {
			return (AQuantityKind) obj;
		}
		return null;
	}
	
	@Override
	public void updateState(boolean state) {
		super.updateState(state);
		
		if (tableViewer.getStructuredSelection().isEmpty()) {
			buttonRemove.setEnabled(false);
		}
	}
}
