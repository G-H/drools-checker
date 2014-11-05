package de.jss.drools.lang;

/**
 * Represents the definition of an attribute of a type.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Attribute implements Cloneable {

	private final String name;
	private final String type;

	/**
	 * Initializes a new instance of the <code>Attribute</code> class using the
	 * specified data.
	 *
	 * @param name
	 *            The name of the new attribute.
	 * @param type
	 *            The type of the new attribute.
	 */
	public Attribute(String name, String type) {
		this.name = name;
		this.type = type;
	}

	/**
	 * Creates and returns a deep copy of the attribute.
	 *
	 * @return A deep copy of the attribute.
	 */
	@Override
	public Attribute clone() {
		return new Attribute(name, type);
	}

	/**
	 * Gets the name of the attribute.
	 *
	 * @return The name of the attribute.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the type of the attribute.
	 *
	 * @return The type of the attribute.
	 */
	public String getType() {
		return type;
	}
}
