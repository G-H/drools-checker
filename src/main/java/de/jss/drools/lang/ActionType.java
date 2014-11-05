package de.jss.drools.lang;

/**
 * Specifies the type of action in the associated
 * {@link de.jss.drools.lang.Action} instance.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public enum ActionType {

	/**
	 * Inserts a new fact into the working memory.
	 */
	Insertion,

	/**
	 * Modifies a fact in the working memory.
	 */
	Modification,

	/**
	 * Retracts a fact from the working memory.
	 */
	Retraction
}
