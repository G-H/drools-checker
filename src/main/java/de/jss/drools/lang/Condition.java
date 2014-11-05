package de.jss.drools.lang;

/**
 * Provides a marker interface for conditions.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public interface Condition {

	/**
	 * Creates and returns a deep copy of the condition.
	 *
	 * @return A deep copy of the condition.
	 */
	public Condition clone();
}
