package de.jss.drools.lang;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a connective of constraints of a pattern.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class ConstraintConnective implements Cloneable, Constraint {

	private final List<Constraint> constraints;
	private final ConstraintConnectiveType type;

	/**
	 * Initializes a new instance of the <code>ConstraintConnective</code> class
	 * with the specified type.
	 *
	 * @param type
	 *            The type of the new connective.
	 */
	public ConstraintConnective(ConstraintConnectiveType type) {
		constraints = new LinkedList<Constraint>();
		this.type = type;
	}

	/**
	 * Creates and returns a deep copy of the connective.
	 *
	 * @return A deep copy of the connective.
	 */
	@Override
	public ConstraintConnective clone() {
		final ConstraintConnective clone = new ConstraintConnective(type);
		for (final Constraint c : constraints) {
			clone.constraints.add(c.clone());
		}
		return clone;
	}

	/**
	 * Gets the connected constraints.
	 *
	 * @return The connected constraints.
	 */
	public List<Constraint> getConstraints() {
		return constraints;
	}

	/**
	 * Gets the type of the connective.
	 *
	 * @return The type of the connective.
	 */
	public ConstraintConnectiveType getType() {
		return type;
	}
}
