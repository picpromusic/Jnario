/*
 * generated by Xtext
 */
package org.jnario.spec.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.jnario.spec.ui.internal.SpecActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class SpecExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return SpecActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return SpecActivator.getInstance().getInjector(SpecActivator.ORG_JNARIO_SPEC_SPEC);
	}
	
}
