package de.jss.drools.compiler;

/**
 * Thrown to indicate that an error occurred while parsing code.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class CodeParserException extends Exception {

	private static final long serialVersionUID = -4716977365434703042L;

	/**
	 * Please refer to {@link java.lang.Exception#Exception()}.
	 *
	 * @see java.lang.Exception#Exception()
	 */
	public CodeParserException() {
		super();
	}

	/**
	 * Please refer to {@link java.lang.Exception#Exception(String message)}.
	 *
	 * @see java.lang.Exception#Exception(String message)
	 */
	public CodeParserException(final String message) {
		super(message);
	}

	/**
	 * Please refer to
	 * {@link java.lang.Exception#Exception(String message, Throwable cause)}.
	 *
	 * @see java.lang.Exception#Exception(String message, Throwable cause)
	 */
	public CodeParserException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Please refer to {@link java.lang.Exception#Exception(Throwable cause)}.
	 *
	 * @see java.lang.Exception#Exception(Throwable cause)
	 */
	public CodeParserException(final Throwable cause) {
		super(cause);
	}
}
