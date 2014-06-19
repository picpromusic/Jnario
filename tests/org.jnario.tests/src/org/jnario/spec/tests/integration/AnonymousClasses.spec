/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.spec.tests.integration

import com.google.inject.Inject
import org.jnario.jnario.test.util.BehaviorExecutor
import org.jnario.jnario.test.util.SpecTestCreator
import org.jnario.runner.CreateWith

import static org.jnario.jnario.test.util.ResultMatchers.*
import static org.junit.Assert.*

@CreateWith(typeof(SpecTestCreator))
describe "Anonymous classes" {

	@Inject extension BehaviorExecutor
	fact "supports anonymous class declaration"{
		val spec = '''
			package bootstrap
			
			import org.eclipse.text.xbase.lib.Functions.Function0

      describe 'Anonymous classes' {
        fact {
          val example = new Function0<String>(){
            override apply() {
              "Hello World"
            }
          }
          example.apply => "Hello World"
        }
      }
		'''
		assertThat(execute(spec), successful)
	} 
	
}
	