package de.jss.drools.lang;

/**
 * Represents a relation.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class AttributeConstraint implements Cloneable, Constraint {

	private final String attributeName;
	private final String expression;
	private final String relation;

	/**
	 * Initializes a new instance of the <code>Relation</code> class using the
	 * specified data.
	 *
	 * @param type
	 *            The type of the new relation.
	 * @param value1
	 *            The left value of the new relation.
	 * @param value2
	 *            The right value of the new relation.
	 */
	public AttributeConstraint(String attributeName, String relation,
			String expression) {
		this.attributeName = attributeName;
		this.expression = expression;
		this.relation = relation;
	}

	/**
	 * Creates and returns a deep copy of the relation.
	 *
	 * @return A deep copy of the relation.
	 */
	@Override
	public AttributeConstraint clone() {
		return new AttributeConstraint(attributeName, relation, expression);
	}

	/**
	 * Gets the attributeName of the AttributeConstraint.
	 *
	 * @return The attributeName of the AttributeConstraint.
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * Gets the expression of the AttributeConstraint.
	 *
	 * @return The expression of the AttributeConstraint.
	 */
	public String getExpression() {
		return expression;
	}

	/**
	 * Gets the type of the relation.
	 *
	 * @return The type of the relation.
	 */
	public String getRelation() {
		return relation;
	}
}
