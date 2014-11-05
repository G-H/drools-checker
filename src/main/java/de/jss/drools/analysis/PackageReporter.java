package de.jss.drools.analysis;

import java.io.OutputStream;

import de.jss.drools.lang.Package;

/**
 * <code>PackageReporter</code> is the abstract base class for all package
 * reporters.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public abstract class PackageReporter {

	/**
	 * Analyzes the specified <code>Package</code> and writes a report to the
	 * specified <code>OutputStream</code>.
	 *
	 * @param outputStream
	 *            The <code>OutputStream</code> to write the report to.
	 * @param pkg
	 *            The <code>Package</code> to analyze.
	 */
	public abstract void report(OutputStream outputStream, Package pkg);
}
