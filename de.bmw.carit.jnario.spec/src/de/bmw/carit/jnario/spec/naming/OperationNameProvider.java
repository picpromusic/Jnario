package de.bmw.carit.jnario.spec.naming;

import static com.google.common.base.Joiner.on;
import static com.google.common.collect.Iterables.transform;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.base.Function;

public class OperationNameProvider implements Function<JvmOperation, QualifiedName>{

	public QualifiedName apply(JvmOperation from) {
		StringBuilder sb = new StringBuilder();
		sb.append(from.getSimpleName());
		appendParameters(sb, from.getParameters());
		return QualifiedName.create(sb.toString());
	}

	private void appendParameters(StringBuilder sb,	List<JvmFormalParameter> parameters) {
		if(parameters.isEmpty()){
			return;
		}
		sb.append("(");
		sb.append(on(", ").join(transform(parameters, new Function<JvmFormalParameter, String>(){

			public String apply(JvmFormalParameter from) {
				JvmTypeReference type = from.getParameterType();
				return type.getSimpleName();
			}
			
		})));
				
		sb.append(")");
	}

}