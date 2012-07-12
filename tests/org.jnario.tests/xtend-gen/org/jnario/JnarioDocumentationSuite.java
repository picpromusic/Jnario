/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario;

import org.jnario.CommonConceptsSuite;
import org.jnario.FeaturesSuite;
import org.jnario.GettingStartedSuite;
import org.jnario.UnitSpecsSuite;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Jnario Documentation")
@Contains({ GettingStartedSuite.class, CommonConceptsSuite.class, FeaturesSuite.class, UnitSpecsSuite.class })
@SuppressWarnings("all")
public class JnarioDocumentationSuite {
}