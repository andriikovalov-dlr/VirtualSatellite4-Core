/*******************************************************************************
 * Copyright (c) 2008-2019 German Aerospace Center (DLR), Simulation and Software Technology, Germany.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
/*
 * generated by Xtext
 */
package de.dlr.sc.virsat.model.concept.formatting

import com.google.inject.Inject
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import de.dlr.sc.virsat.model.concept.services.ConceptLanguageGrammarAccess

/**
 * This class contains custom formatting declarations.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class ConceptLanguageFormatter extends AbstractDeclarativeFormatter {
	
	@Inject extension ConceptLanguageGrammarAccess
	
	override protected configureFormatting(FormattingConfig c) {
		for(pair: findKeywordPairs('{', '}')) {
			c.setIndentation(pair.first, pair.second)
			c.setLinewrap(1).after(pair.first)
			c.setLinewrap(1).before(pair.second)
			c.setLinewrap(1).after(pair.second)
		}
		for(comma: findKeywords(',')) {
			c.setNoLinewrap().before(comma)
			c.setNoSpace().before(comma)
			c.setLinewrap().after(comma)
		}
		c.setLinewrap(0, 1, 2).before(SL_COMMENTRule)
		c.setLinewrap(0, 1, 2).before(ML_COMMENTRule)
		c.setLinewrap(0, 1, 1).after(ML_COMMENTRule)
	}
}
