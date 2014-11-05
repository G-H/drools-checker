package de.jss.drools.lang;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents the definition of a fact type.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Type implements Cloneable {

	private final List<Attribute> attributes;
	private final String name;

	/**
	 * Initializes a new instance of the <code>FactType</code> class with the
	 * specified name.
	 *
	 * @param name
	 *            The name of the new fact type.
	 */
	public Type(String name) {
		attributes = new LinkedList<Attribute>();
		this.name = name;
	}

	/**
	 * Creates and returns a deep copy of the fact type.
	 *
	 * @return A deep copy of the fact type.
	 */
	@Override
	public Type clone() {
		final Type clone = new Type(name);
		for (final Attribute a : attributes) {
			clone.attributes.add(a.clone());
		}
		return clone;
	}

	/**
	 * Gets the attribute with the specified name.
	 *
	 * @param name
	 *            The name to search for.
	 * @return The attribute with the specified name.
	 */
	public Attribute getAttribute(String name) {
		for (final Attribute a : attributes) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		throw new IndexOutOfBoundsException();
	}

	/**
	 * Gets the attributes of the fact type.
	 *
	 * @return The attributes of the fact type.
	 */
	public List<Attribute> getAttributes() {
		return attributes;
	}

	/**
	 * Gets the name of the fact type.
	 *
	 * @return The name of the fact type.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Checks whether the fact type contains an attribute with the specified
	 * name.
	 *
	 * @param name
	 *            The name to search for.
	 * @return true if an attribute with the specified name was found; otherwise
	 *         false.
	 */
	public boolean hasAttribute(String name) {
		for (final Attribute a : attributes) {
			if (a.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
