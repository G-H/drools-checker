package de.jss.drools.lang;

/**
 * Represents an assignment which changes the value of an attribute of a fact.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Assignment implements Cloneable {

	private final String attributeName;
	private final String expression;

	/**
	 * Initializes a new instance of the <code>Assignment</code> class using the
	 * specified data.
	 *
	 * @param attributeName
	 *            The name of the attribute to which the new assignment refers
	 *            to.
	 * @param expression
	 *            The expression of the new assignment.
	 */
	public Assignment(String attributeName, String expression) {
		this.attributeName = attributeName;
		this.expression = expression;
	}

	/**
	 * Creates and returns a deep copy of the assignment.
	 *
	 * @return A deep copy of the assignment.
	 */
	@Override
	public Assignment clone() {
		return new Assignment(attributeName, expression);
	}

	/**
	 * Gets the name of the attribute to which the assignment refers to.
	 *
	 * @return The name of the attribute to which the assignment refers to.
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * Gets the expression of the assignment.
	 *
	 * @return The expression of the assignment.
	 */
	public String getExpression() {
		return expression;
	}
}
