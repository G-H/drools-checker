package de.jss.drools.lang;

/**
 * Provides a marker interface for constraints.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public interface Constraint extends Cloneable {

	/**
	 * Creates and returns a deep copy of the constraint.
	 *
	 * @return A deep copy of the constraint.
	 */
	public Constraint clone();
}
