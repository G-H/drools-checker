package de.jss.drools.compiler;

/**
 * Thrown to indicate that an error occurred while generating code.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class CodeGeneratorException extends Exception {

	private static final long serialVersionUID = -1221482285467087L;

	/**
	 * Please refer to {@link java.lang.Exception#Exception()}.
	 *
	 * @see java.lang.Exception#Exception()
	 */
	public CodeGeneratorException() {
		super();
	}

	/**
	 * Please refer to {@link java.lang.Exception#Exception(String message)}.
	 *
	 * @see java.lang.Exception#Exception(String message)
	 */
	public CodeGeneratorException(final String message) {
		super(message);
	}

	/**
	 * Please refer to
	 * {@link java.lang.Exception#Exception(String message, Throwable cause)}.
	 *
	 * @see java.lang.Exception#Exception(String message, Throwable cause)
	 */
	public CodeGeneratorException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Please refer to {@link java.lang.Exception#Exception(Throwable cause)}.
	 *
	 * @see java.lang.Exception#Exception(Throwable cause)
	 */
	public CodeGeneratorException(final Throwable cause) {
		super(cause);
	}
}
