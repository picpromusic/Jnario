/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/*
* generated by Xtext
*/
package org.jnario.suite.ui.contentassist;

import static org.jnario.util.Strings.trim;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.common.types.xtext.ui.TypeMatchFilters;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.xbase.XbaseQualifiedNameConverter;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.conversion.XbaseQualifiedNameValueConverter;
import org.jnario.suite.suite.SuitePackage;
import org.jnario.ui.contentassist.ImportingTypesProposalProvider.FQNImporter;

@SuppressWarnings("restriction")
public class SuiteProposalProvider extends AbstractSuiteProposalProvider {

	@Override
	public void completeXAnnotation_AnnotationType(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, 
				TypeMatchFilters.all(IJavaSearchConstants.ANNOTATION_TYPE), acceptor);
	}
	
	@Override
	public void completeSpecReference_Spec(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		
		final IScope scope = getScopeProvider().getScope(model, SuitePackage.Literals.SPEC_REFERENCE__SPEC);
		XbaseQualifiedNameValueConverter qualifiedNameValueConverter = new XbaseQualifiedNameValueConverter(){
			@Override
			public String toString(String value) {
				int end = value.lastIndexOf('.');
				String result = value.substring(1, end) + ".*";
				return result;
			}
		};
		final IQualifiedNameConverter qualifiedNameConverter = new XbaseQualifiedNameConverter(){
			@Override
			public QualifiedName toQualifiedName(String qualifiedNameAsString) {
				return new QualifiedName(qualifiedNameAsString.split("\\.")){
					public String getLastSegment() {
						return "\"" + super.getLastSegment();
					};
				};
			}
		};
		final FQNImporter fqnImporter = new FQNImporter(context.getResource(), context.getViewer(), scope, qualifiedNameConverter, null, qualifiedNameValueConverter);
		final ICompletionProposalAcceptor scopeAware = new ICompletionProposalAcceptor.Delegate(acceptor) {
			@Override
			public void accept(ICompletionProposal proposal) {
				if (proposal instanceof ConfigurableCompletionProposal) {
					ConfigurableCompletionProposal configurableCompletionProposal = (ConfigurableCompletionProposal) proposal;
					String string = configurableCompletionProposal.getReplacementString();
					string = trim(string, '"');
					QualifiedName qualifiedName = qualifiedNameConverter.toQualifiedName(string);
					IEObjectDescription element = scope.getSingleElement(qualifiedName);
					if(element == null){
						return;
					}
					configurableCompletionProposal.setTextApplier(fqnImporter);
				}
				super.accept(proposal);
			}
		};
		super.completeSpecReference_Spec(model, assignment, context, scopeAware);
	}
	
}
