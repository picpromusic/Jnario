/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.feature.tests.unit.naming;

import java.util.List;
import org.jnario.lib.ExampleTableRow;

public class FeatureClassNameProviderGetClassNameBackgroundSpecExamples extends ExampleTableRow {
  public FeatureClassNameProviderGetClassNameBackgroundSpecExamples(final List<String> cellNames, final String name, final String feature, final String expectedClassName) {
    super(cellNames);
    this.name = name;
    this.feature = feature;
    this.expectedClassName = expectedClassName;
  }
  
  public String name;
  
  public String getName() {
    return name;
  }
  
  public String feature;
  
  public String getFeature() {
    return feature;
  }
  
  public String expectedClassName;
  
  public String getExpectedClassName() {
    return expectedClassName;
  }
  
  public List<String> getCells() {
    return java.util.Arrays.asList(String.valueOf(name) , String.valueOf(feature) , String.valueOf(expectedClassName));
  }
}