package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTNSinglePattern3.drl" and generates termination report
 * "XTNSinglePattern3.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTNSinglePattern3 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTNSinglePattern3.drl", new INTTRSReporter(),
				"XTNSinglePattern3.txt");
	}
}
