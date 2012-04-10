package org.jnario.spec.tests.unit.parsing

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.jnario.jnario.test.util.AbstractParserTest
import org.jnario.spec.SpecInjectorProvider
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(SpecInjectorProvider))
class ParserTest extends AbstractParserTest{
	
	override context(){
		typeof(ParserTest)
	}
}