package de.jss.drools.lang;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a connective of conditions of a rule.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class ConditionConnective implements Cloneable, Condition {

	private final List<Condition> conditions;
	private final ConditionConnectiveType type;

	/**
	 * Initializes a new instance of the <code>ConditionConnective</code> class
	 * with the specified type.
	 *
	 * @param type
	 *            The type of the new connective.
	 */
	public ConditionConnective(ConditionConnectiveType type) {
		conditions = new LinkedList<Condition>();
		this.type = type;
	}

	/**
	 * Creates and returns a deep copy of the connective.
	 *
	 * @return A deep copy of the connective.
	 */
	@Override
	public ConditionConnective clone() {
		final ConditionConnective clone = new ConditionConnective(type);
		for (final Condition c : conditions) {
			clone.conditions.add(c.clone());
		}
		return clone;
	}

	/**
	 * Gets the connected conditions.
	 *
	 * @return The connected conditions.
	 */
	public List<Condition> getConditions() {
		return conditions;
	}

	/**
	 * Gets the type of the connective.
	 *
	 * @return The type of the connective.
	 */
	public ConditionConnectiveType getType() {
		return type;
	}
}
