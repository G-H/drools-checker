package de.jss.drools.test;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import de.jss.drools.analysis.PackageReporter;
import de.jss.drools.compiler.CodeParser;

/**
 * Abstract base class for tests, which generate reports about packages.
 *
 * @author Johannes Schramm
 * @version 2014-09-24
 */
public abstract class ReportTest {

	private static String inputPath = "/home/user/workspaces/jss-drools-checker/jss-drools-checker/test/input/";
	private static String outputPath = "/home/user/workspaces/jss-drools-checker/jss-drools-checker/test/output/reports/";

	protected void run(CodeParser parser, String input,
			PackageReporter reporter, String output) {
		try {
			final FileInputStream inputStream = new FileInputStream(new File(
					inputPath + input));
			final FileOutputStream outputStream = new FileOutputStream(
					new File(outputPath + output));
			reporter.report(outputStream, parser.parse(inputStream));
			inputStream.close();
			outputStream.close();
		} catch (final Exception e) {
			fail(e.getMessage());
		}
	}
}
