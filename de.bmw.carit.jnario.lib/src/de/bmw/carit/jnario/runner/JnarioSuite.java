package de.bmw.carit.jnario.runner;

import static java.util.Arrays.asList;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;

import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

import com.google.common.collect.Iterables;

public class JnarioSuite extends Suite
{
	/**
	 * Called reflectively on classes annotated with <code>@RunWith(Suite.class)</code>
	 * 
	 * @param klass the root class
	 * @param builder builds runners for classes in the suite
	 * @throws InitializationError
	 */
	public JnarioSuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
		super(klass, builder);
	}

	/**
	 * Call this when there is no single root class (for example, multiple class names
	 * passed on the command line to {@link org.junit.runner.JUnitCore}
	 * 
	 * @param builder builds runners for classes in the suite
	 * @param classes the classes in the suite
	 * @throws InitializationError 
	 */
	public JnarioSuite(RunnerBuilder builder, Class<?>[] classes) throws InitializationError {
		super(builder, classes);
	}
	
	/**
	 * Call this when the default builder is good enough. Left in for compatibility with JUnit 4.4.
	 * @param klass the root of the suite
	 * @param suiteClasses the classes in the suite
	 * @throws InitializationError
	 */
	protected JnarioSuite(Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(klass, suiteClasses);
	}
	
	/**
	 * Called by this class and subclasses once the classes making up the suite have been determined
	 * 
	 * @param builder builds runners for classes in the suite
	 * @param klass the root of the suite
	 * @param suiteClasses the classes in the suite
	 * @throws InitializationError
	 */
	protected JnarioSuite(RunnerBuilder builder, Class<?> klass, Class<?>[] suiteClasses) throws InitializationError {
		super(builder, klass, suiteClasses);
	}
	
	/**
	 * Called by this class and subclasses once the runners making up the suite have been determined
	 * 
	 * @param klass root of the suite
	 * @param runners for each class in the suite, a {@link Runner}
	 * @throws InitializationError 
	 */
	protected JnarioSuite(Class<?> klass, List<Runner> runners) throws InitializationError {
		super(klass, runners);
	}
	
	@Override
	protected String getName() {
		return nameOf(getTestClass().getJavaClass());
	}

	protected String nameOf(Class<?> klass) {
		Annotation[] annotations = klass.getAnnotations();
		Iterator<Named> names = Iterables.filter(asList(annotations), Named.class).iterator();
		return names.hasNext() ? names.next().value() : super.getName();
	}
}
