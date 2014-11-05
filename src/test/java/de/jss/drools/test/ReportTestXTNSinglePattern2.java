package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTNSinglePattern2.drl" and generates termination report
 * "XTNSinglePattern2.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTNSinglePattern2 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTNSinglePattern2.drl", new INTTRSReporter(),
				"XTNSinglePattern2.txt");
	}
}
