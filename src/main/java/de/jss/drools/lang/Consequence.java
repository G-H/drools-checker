package de.jss.drools.lang;

/**
 * Provides a marker interface for consequences.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public interface Consequence extends Cloneable {

	/**
	 * Creates and returns a deep copy of the consequence.
	 *
	 * @return A deep copy of the consequence.
	 */
	public Consequence clone();
}
