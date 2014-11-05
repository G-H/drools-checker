package de.jss.drools.compiler;

import java.io.InputStream;

import de.jss.drools.lang.Package;

/**
 * <code>CodeParser</code> is the abstract base class for all code parsers.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public abstract class CodeParser {

	/**
	 * Parses the code from the specified <code>InputStream</code> into a
	 * <code>Package</code>.
	 *
	 * @param inputStream
	 *            The <code>InputStream</code> to read code from.
	 * @return The <code>Package</code> parsed from the code.
	 * @throws CodeParserException
	 *             Indicates that an error occurred while parsing code.
	 */
	public abstract Package parse(InputStream inputStream)
			throws CodeParserException;
}
