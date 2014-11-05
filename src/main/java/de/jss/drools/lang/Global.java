package de.jss.drools.lang;

/**
 * Represents the definition of a global.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Global implements Cloneable {

	private final String name;
	private final String type;

	/**
	 * Initializes a new instance of the <code>Global</code> class using the
	 * specified data.
	 *
	 * @param name
	 *            The name of the new global.
	 * @param type
	 *            The type of the new global.
	 */
	public Global(String name, String type) {
		this.name = name;
		this.type = type;
	}

	/**
	 * Creates and returns a deep copy of the global.
	 *
	 * @return A deep copy of the global.
	 */
	@Override
	public Global clone() {
		return new Global(name, type);
	}

	/**
	 * Gets the name of the global.
	 *
	 * @return The name of the global.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the type of the global.
	 *
	 * @return The type of the global.
	 */
	public String getType() {
		return type;
	}
}
