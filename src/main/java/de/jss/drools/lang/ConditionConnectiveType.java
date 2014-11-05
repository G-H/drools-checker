package de.jss.drools.lang;

/**
 * Specifies the type of connective in the associated
 * {@link de.jss.drools.lang.ConditionConnective} instance.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public enum ConditionConnectiveType {

	/**
	 * Connects conditions by the means of '\bigwedge'.
	 */
	Conjunction,

	/**
	 * Connects conditions by the means of '\bigvee'.
	 */
	Disjunction,

	/**
	 * Connects conditions by the means of '\neg \exists'.
	 */
	Negation
}
