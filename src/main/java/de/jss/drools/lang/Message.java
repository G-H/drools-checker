package de.jss.drools.lang;

/**
 * Represents a message which does not change the working memory.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class Message implements Cloneable, Consequence {

	private final String value;

	/**
	 * Initializes a new instance of the <code>Message</code> class with the
	 * specified value.
	 *
	 * @param value
	 *            The value of the new message.
	 */
	public Message(String value) {
		this.value = value;
	}

	/**
	 * Creates and returns a deep copy of the message.
	 *
	 * @return A deep copy of the message.
	 */
	@Override
	public Message clone() {
		return new Message(value);
	}

	/**
	 * Gets the value of the message.
	 *
	 * @return The value of the message.
	 */
	public String getValue() {
		return value;
	}
}
