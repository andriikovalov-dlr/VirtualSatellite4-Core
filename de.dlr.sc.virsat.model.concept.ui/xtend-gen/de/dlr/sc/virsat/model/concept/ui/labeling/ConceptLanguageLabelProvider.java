/**
 * generated by Xtext
 */
package de.dlr.sc.virsat.model.concept.ui.labeling;

import com.google.inject.Inject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
@SuppressWarnings("all")
public class ConceptLanguageLabelProvider extends DefaultEObjectLabelProvider {
  @Inject
  public ConceptLanguageLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
}
