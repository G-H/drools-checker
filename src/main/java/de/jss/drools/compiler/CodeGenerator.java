package de.jss.drools.compiler;

import java.io.OutputStream;

import de.jss.drools.lang.Package;

/**
 * <code>CodeGenerator</code> is the abstract base class for all code
 * generators.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public abstract class CodeGenerator {

	/**
	 * Generates code for the specified <code>Package</code> and writes it to
	 * the specified <code>OutputStream</code>.
	 *
	 * @param outputStream
	 *            The <code>OutputStream</code> to write code to.
	 * @param pkg
	 *            The <code>Package</code> to generate code for.
	 * @throws CodeGeneratorException
	 *             Indicates that an error occurred while generating code.
	 */
	public abstract void generate(OutputStream outputStream, Package pkg)
			throws CodeGeneratorException;
}
