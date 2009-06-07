// Copyright (c) 2003-2009, Jodd Team (jodd.org). All Rights Reserved.

package jodd.petite;

import jodd.petite.scope.Scope;
import jodd.petite.scope.DefaultScope;
import jodd.petite.scope.SingletonScope;

/**
 * Petite configuration.
 */
public class PetiteConfig {

	public PetiteConfig() {
		defaultScope = SingletonScope.class;
		defaultWiringMode = WiringMode.STRICT;
		detectDuplicatedBeanNames = false;
		defaultInitMethods = true;
	}

	protected Class<? extends Scope> defaultScope;
	/**
	 * Returns default scope type.
	 */
	public Class<? extends Scope> getDefaultScope() {
		return defaultScope;
	}
	/**
	 * Sets default scope type.
	 */
	public void setDefaultScope(Class<? extends Scope> defaultScope) {
		if (defaultScope == DefaultScope.class) {
			throw new PetiteException("Invalid default Petite scope: scope must be a concrete scope implementation.");
		}
		if (defaultScope == null) {
			throw new PetiteException("Invalid default Petite scope: null.");
		}
		this.defaultScope = defaultScope;
	}



	protected WiringMode defaultWiringMode;
	/**
	 * Returns default wiring mode.
	 */
	public WiringMode getDefaultWiringMode() {
		return defaultWiringMode;
	}
	/**
	 * Specifies default wiring mode.
	 */
	public void setDefaultWiringMode(WiringMode defaultWiringMode) {
		if ((defaultWiringMode == null) || (defaultWiringMode == WiringMode.DEFAULT)) {
			throw new PetiteException("Invalid default wiring mode: " + defaultWiringMode);
		}
		this.defaultWiringMode = defaultWiringMode;
	}
	/**
	 * Resolves wiring mode by checking if default and <code>null</code> values.
	 */
	protected WiringMode resolveWiringMode(WiringMode wiringMode) {
		if ((wiringMode == null) || (wiringMode == WiringMode.DEFAULT)) {
			wiringMode = defaultWiringMode;
		}
		return wiringMode;
	}



	protected boolean detectDuplicatedBeanNames;
	/**
	 * Returns <code>true</code> if container detects duplicated bean names.
	 */
	public boolean isDetectDuplicatedBeanNames() {
		return detectDuplicatedBeanNames;
	}
	/**
	 * Specifies if an exception should be thrown if two beans with same exception are registered with this container.
	 */
	public void setDetectDuplicatedBeanNames(boolean detectDuplicatedBeanNames) {
		this.detectDuplicatedBeanNames = detectDuplicatedBeanNames;
	}


	protected boolean defaultInitMethods;
	/**
	 * Returns <code>true</code> if init methods should be invoked on explicit wiring, adding and creating.
	 */
	public boolean isDefaultInitMethods() {
		return defaultInitMethods;
	}

	/**
	 * Specifies is init method should be invoked on expliciti wiring, adding and creating.
	 */
	public void setDefaultInitMethods(boolean defaultInitMethods) {
		this.defaultInitMethods = defaultInitMethods;
	}
}
