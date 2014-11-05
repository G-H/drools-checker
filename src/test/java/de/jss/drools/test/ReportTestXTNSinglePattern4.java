package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTNSinglePattern4.drl" and generates termination report
 * "XTNSinglePattern4.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTNSinglePattern4 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTNSinglePattern4.drl", new INTTRSReporter(),
				"XTNSinglePattern4.txt");
	}
}
