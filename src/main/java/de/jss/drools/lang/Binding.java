package de.jss.drools.lang;

/**
 * Represents the definition of a binding.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Binding implements Cloneable {

	private final String name;
	private final String value;

	/**
	 * Initializes a new instance of the <code>Binding</code> class using the
	 * specified data.
	 *
	 * @param name
	 *            The name of the new binding.
	 * @param value
	 *            The value of the new binding.
	 */
	public Binding(String name, String value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Creates and returns a deep copy of the binding.
	 *
	 * @return A deep copy of the binding.
	 */
	@Override
	public Binding clone() {
		return new Binding(name, value);
	}

	/**
	 * Gets the name of the binding.
	 *
	 * @return The name of the binding.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the value of the binding.
	 *
	 * @return The value of the binding.
	 */
	public String getValue() {
		return value;
	}
}
