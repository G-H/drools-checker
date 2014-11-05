package de.jss.drools.lang;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a package.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Package implements Cloneable {

	private final List<Type> factTypes;
	private final List<Global> globals;
	private final String name;
	private final List<Rule> rules;

	/**
	 * Initializes a new instance of the <code>Package</code> class with the
	 * specified name.
	 *
	 * @param name
	 *            The name of the new package.
	 */
	public Package(String name) {
		factTypes = new LinkedList<Type>();
		globals = new LinkedList<Global>();
		this.name = name;
		rules = new LinkedList<Rule>();
	}

	/**
	 * Creates and returns a deep copy of the package.
	 *
	 * @return A deep copy of the package.
	 */
	@Override
	public Package clone() {
		final Package clone = new Package(name);
		for (final Type t : factTypes) {
			clone.factTypes.add(t.clone());
		}
		for (final Global g : globals) {
			clone.globals.add(g.clone());
		}
		for (final Rule r : rules) {
			clone.rules.add(r.clone());
		}
		return clone;
	}

	/**
	 * Gets the fact type with the specified name.
	 *
	 * @param name
	 *            The name to search for.
	 * @return The fact type with the specified name.
	 */
	public Type getFactType(String name) {
		for (final Type t : factTypes) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		throw new IndexOutOfBoundsException();
	}

	/**
	 * Gets the fact types of the package.
	 *
	 * @return The fact types of the package.
	 */
	public List<Type> getFactTypes() {
		return factTypes;
	}

	/**
	 * Gets the global with the specified name.
	 *
	 * @param name
	 *            The name to search for.
	 * @return The global with the specified name.
	 */
	public Global getGlobal(String name) {
		for (final Global g : globals) {
			if (g.getName().equals(name)) {
				return g;
			}
		}
		throw new IndexOutOfBoundsException();
	}

	/**
	 * Gets the globals of the package.
	 *
	 * @return The globals of the package.
	 */
	public List<Global> getGlobals() {
		return globals;
	}

	/**
	 * Gets the name of the package.
	 *
	 * @return The name of the package.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the rule with the specified name.
	 *
	 * @param name
	 *            The name to search for.
	 * @return The rule with the specified name.
	 */
	public Rule getRule(String name) {
		for (final Rule r : rules) {
			if (r.getName().equals(name)) {
				return r;
			}
		}
		throw new IndexOutOfBoundsException();
	}

	/**
	 * Gets the rules of the package.
	 *
	 * @return The rules of the package.
	 */
	public List<Rule> getRules() {
		return rules;
	}

	/**
	 * Checks whether the package contains a fact type with the specified name.
	 *
	 * @param name
	 *            The name to search for.
	 * @return true if a fact type with the specified name was found; otherwise
	 *         false.
	 */
	public boolean hasFactType(String name) {
		for (final Type t : factTypes) {
			if (t.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether the package contains a global with the specified name.
	 *
	 * @param name
	 *            The name to search for.
	 * @return true if a global with the specified name was found; otherwise
	 *         false.
	 */
	public boolean hasGlobal(String name) {
		for (final Global g : globals) {
			if (g.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether the package contains a rule with the specified name.
	 *
	 * @param name
	 *            The name to search for.
	 * @return true if a rule with the specified name was found; otherwise
	 *         false.
	 */
	public boolean hasRule(String name) {
		for (final Rule r : rules) {
			if (r.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
