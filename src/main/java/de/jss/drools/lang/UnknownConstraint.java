package de.jss.drools.lang;

/**
 * Represents an unknown constraint.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class UnknownConstraint implements Constraint {

	/**
	 * Creates and returns a deep copy of the constraint.
	 *
	 * @return A deep copy of the constraint.
	 */
	@Override
	public Constraint clone() {
		return new UnknownConstraint();
	}
}
