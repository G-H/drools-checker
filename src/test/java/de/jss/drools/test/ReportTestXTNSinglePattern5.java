package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTNSinglePattern5.drl" and generates termination report
 * "XTNSinglePattern5.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTNSinglePattern5 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTNSinglePattern5.drl", new INTTRSReporter(),
				"XTNSinglePattern5.txt");
	}
}
