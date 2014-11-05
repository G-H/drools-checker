package de.jss.drools.lang;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an action which changes the working memory.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Action implements Cloneable, Consequence {

	private final List<Assignment> assignments;
	private final String factTypeName;
	private final String patternName;
	private final ActionType type;

	/**
	 * Initializes a new instance of the <code>Action</code> class using the
	 * specified data.
	 *
	 * @param factTypeName
	 *            The name of the fact type to which the new action refers to.
	 * @param patternName
	 *            The name of the pattern to which the new action refers to.
	 * @param type
	 *            The type of the new action.
	 */
	public Action(String factTypeName, String patternName, ActionType type) {
		assignments = new LinkedList<Assignment>();
		this.factTypeName = factTypeName;
		this.patternName = patternName;
		this.type = type;
	}

	/**
	 * Creates and returns a deep copy of the action.
	 *
	 * @return A deep copy of the action.
	 */
	@Override
	public Action clone() {
		final Action clone = new Action(factTypeName, patternName, type);
		for (final Assignment a : assignments) {
			clone.assignments.add(a.clone());
		}
		return clone;
	}

	/**
	 * Gets the assignments of the action.
	 *
	 * @return The assignments of the action.
	 */
	public List<Assignment> getAssignments() {
		return assignments;
	}

	/**
	 * Gets the name of the fact type to which the action refers to.
	 *
	 * @return The name of the fact type to which the action refers to.
	 */
	public String getFactTypeName() {
		return factTypeName;
	}

	/**
	 * Gets the name of the pattern to which the action refers to.
	 *
	 * @return The name of the pattern to which the action refers to.
	 */
	public String getPatternName() {
		return patternName;
	}

	/**
	 * Gets the type of the action.
	 *
	 * @return The type of the action.
	 */
	public ActionType getType() {
		return type;
	}
}
