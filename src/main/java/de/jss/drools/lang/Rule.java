package de.jss.drools.lang;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a rule.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Rule implements Cloneable {

	private final List<Condition> conditions;
	private final List<Consequence> consequences;
	private final String name;

	/**
	 * Initializes a new instance of the <code>Rule</code> class with the
	 * specified name.
	 *
	 * @param name
	 *            The name of the new rule.
	 */
	public Rule(String name) {
		conditions = new LinkedList<Condition>();
		consequences = new LinkedList<Consequence>();
		this.name = name;
	}

	/**
	 * Creates and returns a deep copy of the rule.
	 *
	 * @return A deep copy of the rule.
	 */
	@Override
	public Rule clone() {
		final Rule clone = new Rule(name);
		for (final Condition c : conditions) {
			clone.conditions.add(c.clone());
		}
		for (final Consequence c : consequences) {
			clone.consequences.add(c.clone());
		}
		return clone;
	}

	/**
	 * Gets the conditions of the rule.
	 *
	 * @return The conditions of the rule.
	 */
	public List<Condition> getConditions() {
		return conditions;
	}

	/**
	 * Gets the consequences of the rule.
	 *
	 * @return The consequences of the rule.
	 */
	public List<Consequence> getConsequences() {
		return consequences;
	}

	/**
	 * Gets the name of the rule.
	 *
	 * @return The name of the rule.
	 */
	public String getName() {
		return name;
	}
}
