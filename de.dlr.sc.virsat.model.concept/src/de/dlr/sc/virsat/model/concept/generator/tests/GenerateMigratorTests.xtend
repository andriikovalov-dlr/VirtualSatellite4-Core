/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package de.dlr.sc.virsat.model.concept.generator.tests

import de.dlr.sc.virsat.model.concept.generator.AGeneratorGapGenerator
import de.dlr.sc.virsat.model.concept.generator.ConceptOutputConfigurationProvider
import de.dlr.sc.virsat.model.concept.generator.ImportManager
import de.dlr.sc.virsat.model.concept.generator.migrator.GenerateMigrator
import de.dlr.sc.virsat.model.concept.generator.util.ConceptGeneratorUtil
import de.dlr.sc.virsat.model.dvlm.DVLMFactory
import de.dlr.sc.virsat.model.dvlm.Repository
import de.dlr.sc.virsat.model.dvlm.concepts.Concept
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.generator.IFileSystemAccess

/**
 * This class is the generator for the migrators test of our model extension.
 */
class GenerateMigratorTests extends AGeneratorGapGenerator<EObject> {
	
	static def getConcreteClassName(Concept concept) {
		"Migrator" + concept.version.replace(".", "v");
	}
	
	static def getAbstractClassName(Concept concept) {
		"AMigrator" + concept.version.replace(".", "v");
	}
	
	override createConcreteClassFileName(Concept concept, EObject eObject) {
		"../../" + concept.name + ".test/src/" + concept.packageFolder + "/" + concept.concreteClassName + "Test.java"
	}
	
	override createAbstractClassFileName(Concept concept, EObject eObject) {
		"../../" + concept.name + ".test/src-gen/" + concept.packageFolder + "/" + concept.abstractClassName + "Test.java"
	}
	
	override protected getPackage(Concept concept) {
		concept.name + "." + PACKAGE_FOLDER;
	}
	
	public static val PACKAGE_FOLDER = GenerateMigrator.PACKAGE_FOLDER;
	
	override serializeModel(Concept concept, IFileSystemAccess fsa) {
		// ************************************************************************************
		// Abstract Class
		// ************************************************************************************
		var fileOutputAClass = createAbstractClass(concept, concept);
		fsa.generateFile(createAbstractClassFileName(concept, concept), ConceptOutputConfigurationProvider.GENERATOR_OUTPUT_ID_SOURCE, fileOutputAClass);

		// ************************************************************************************
		// Concrete Class
		// ************************************************************************************
		var fileOutputClass = createConcreteClass(concept, concept);
		fsa.generateFile(createConcreteClassFileName(concept, concept), ConceptOutputConfigurationProvider.GENERATOR_OUTPUT_ID_GENERATE_ONCE, fileOutputClass);
	}

	/**
	 * Declare the package statement of the java file 
	 */
	override declarePackage(String pluginPackage) '''
	package «pluginPackage»;
	'''
	
	// *************************************************************************************
	// * generate imports
	// *************************************************************************************
	
	/**
	 * Write down all the import statements needed by this java file
	 */
	override declareImports(ImportManager importManager, Concept concept, EObject eObject, String conceptPackage) '''
	// *****************************************************************
	// * Import Statements
	// *****************************************************************

	
	«IF !importManager.importedClasses.empty»
		«FOR clazz : importManager.importedClasses»
			import «clazz»;
		«ENDFOR»
  	«ENDIF»
	'''

	// *************************************************************************************
	// * generate Abstract test Class that will always be regenerated by the generator
	// *************************************************************************************
	
	/**
	 *	Entry method to write the class body 
	 */
	override declareAClass(Concept concept, EObject eObject, ImportManager importManager) '''
	«importManager.register(Concept)»
	«importManager.register(EcoreUtil)»

	// *****************************************************************
	// * Class Declaration
	// *****************************************************************
	
	import org.junit.Before;
	
	«ConceptGeneratorUtil.generateAClassHeader(concept)»
	public abstract class «concept.abstractClassName»Test {
		protected Concept conceptMigrateTo;
		protected Concept conceptMigrateFromRepository;
		protected Concept conceptMigrateFrom;
		
		@Before
		public void setUp() throws Exception {
			«val currentVersion = concept.version»
			String conceptXmiPluginPathMigrateTo = "«concept.fullQualifiedName»/concept/concept_v«currentVersion.replaceAll("\\.", "_")».xmi";
			«val previousVersion = new AllMigratorsReader().init(concept.fullQualifiedName).getPreviousVersion(currentVersion)»
			String conceptXmiPluginPathMigrateFrom = "«concept.fullQualifiedName»/concept/concept_v«previousVersion.replaceAll("\\.", "_")».xmi";
			
			conceptMigrateTo = de.dlr.sc.virsat.concept.unittest.util.ConceptXmiLoader.loadConceptFromPlugin(conceptXmiPluginPathMigrateTo);
			conceptMigrateFromRepository = de.dlr.sc.virsat.concept.unittest.util.ConceptXmiLoader.loadConceptFromPlugin(conceptXmiPluginPathMigrateFrom);
			conceptMigrateFrom = EcoreUtil.copy(conceptMigrateFromRepository);
		}
	}
	'''
	
	override declareClass(Concept concept, EObject eObject, ImportManager importManager) '''
	// *****************************************************************
	// * Class Declaration
	// *****************************************************************
	
	import org.junit.Test;
	
	«ConceptGeneratorUtil.generateClassHeader(concept)»
	public class «concept.concreteClassName»Test extends «concept.abstractClassName»Test {		
		«declareTestStub(concept, importManager)»
	}
	'''

	// *************************************************************************************
	// * generate Constructor test Cases
	// *************************************************************************************

	/**
	 * Stub for a testing method
	 */		
	protected def declareTestStub(Concept concept, ImportManager importManager) '''
	«importManager.register(Repository)»
	«importManager.register(DVLMFactory)»

	@Test
	public void test«concept.concreteClassName»() {
		«concept.concreteClassName» test«concept.concreteClassName» = new «concept.concreteClassName»();
		
		Repository repository = DVLMFactory.eINSTANCE.createRepository();
		repository.getActiveConcepts().add(conceptMigrateFromRepository);
		
		//TODO: Setup test instances
		
		test«concept.concreteClassName».migrate(conceptMigrateFrom, conceptMigrateFromRepository, conceptMigrateTo);
		
		//TODO: Check for correct migration
	}

	'''
}

