/*******************************************************************************
 * Copyright (c) 2012 BMW Car IT and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.jnario.feature.tests.integration;

import org.jnario.feature.tests.integration.ReferencesForStepsFeatureDefiningAStepAndUsingItInTheSameScenario;
import org.jnario.feature.tests.integration.ReferencesForStepsFeatureReferencingStepsWithDifferentKeyword;
import org.jnario.feature.tests.integration.ReferencesForStepsFeatureStepsWithShortNames;
import org.jnario.feature.tests.integration.ReferencesForStepsFeatureUsingFieldsFromOtherSteps;
import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

/**
 * @author Birgit Engelmann - Initial contribution and API
 */
@RunWith(FeatureRunner.class)
@Contains({ ReferencesForStepsFeatureDefiningAStepAndUsingItInTheSameScenario.class, ReferencesForStepsFeatureReferencingStepsWithDifferentKeyword.class, ReferencesForStepsFeatureUsingFieldsFromOtherSteps.class, ReferencesForStepsFeatureStepsWithShortNames.class })
@Named("References for steps")
@SuppressWarnings("all")
public class ReferencesForStepsFeature {
}