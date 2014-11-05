package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTTMultiplePatterns1.drl" and generates termination report
 * "XTTMultiplePatterns1.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-25
 */
public class ReportTestXTTMultiplePatterns1 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTTMultiplePatterns1.drl", new INTTRSReporter(),
				"XTTMultiplePatterns1.txt");
	}
}
