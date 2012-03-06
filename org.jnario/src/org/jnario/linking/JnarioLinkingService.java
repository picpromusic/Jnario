package org.jnario.linking;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.jnario.CollectionLiteral;

public class JnarioLinkingService extends DefaultLinkingService {

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref,
			INode node) throws IllegalNodeException {
		if (context instanceof CollectionLiteral) {
			final IScope scope = getScope(context, ref);
			CollectionLiteral collectionLiteral = (CollectionLiteral)context;
			QualifiedName qualifiedLinkName =  QualifiedName.create(collectionLiteral.operationName());
			IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedLinkName);
			if (eObjectDescription != null){
				return singletonList(eObjectDescription.getEObjectOrProxy());
			}
			else{
				return emptyList();
			}
		}else{
			return super.getLinkedObjects(context, ref, node);
		}
	}
	
}
