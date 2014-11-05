package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTNMultiplePatterns1.drl" and generates termination report
 * "XTNMultiplePatterns1.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTNMultiplePatterns1 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTNMultiplePatterns1.drl", new INTTRSReporter(),
				"XTNMultiplePatterns1.txt");
	}
}
