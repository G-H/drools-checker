package de.jss.drools.lang;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a pattern.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Pattern implements Cloneable, Condition {

	private final List<Binding> bindings;
	private final List<Constraint> constraints;
	private String outerBinding;
	private final String typeName;

	/**
	 * Initializes a new instance of the <code>Pattern</code> class using the
	 * specified data.
	 *
	 * @param typeName
	 *            The name of the type to which the new pattern refers to.
	 */
	public Pattern(String typeName) {
		bindings = new LinkedList<Binding>();
		constraints = new LinkedList<Constraint>();
		this.typeName = typeName;
	}

	/**
	 * Creates and returns a deep copy of the pattern.
	 *
	 * @return A deep copy of the pattern.
	 */
	@Override
	public Pattern clone() {
		final Pattern clone = new Pattern(typeName);
		for (final Binding b : bindings) {
			clone.bindings.add(b.clone());
		}
		for (final Constraint c : constraints) {
			clone.constraints.add(c.clone());
		}
		return clone;
	}

	/**
	 * Gets the bindings of the pattern.
	 *
	 * @return The bindings of the pattern.
	 */
	public List<Binding> getBindings() {
		return bindings;
	}

	/**
	 * Gets the constraints of the pattern.
	 *
	 * @return The constraints of the pattern.
	 */
	public List<Constraint> getConstraints() {
		return constraints;
	}

	/**
	 * Gets the outerBinding of the Pattern.
	 *
	 * @return The outerBinding of the Pattern.
	 */
	public String getOuterBinding() {
		return outerBinding;
	}

	/**
	 * Gets the name of the fact type to which the pattern refers to.
	 *
	 * @return The name of the fact type to which the pattern refers to.
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * Sets the outerBinding of the Pattern.
	 *
	 * @param outerBinding
	 *            The new outerBinding of the Pattern.
	 */
	public void setOuterBinding(String outerBinding) {
		this.outerBinding = outerBinding;
	}
}
