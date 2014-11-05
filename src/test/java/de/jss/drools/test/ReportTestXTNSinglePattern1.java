package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTNSinglePattern1.drl" and generates termination report
 * "XTNSinglePattern1.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTNSinglePattern1 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTNSinglePattern1.drl", new INTTRSReporter(),
				"XTNSinglePattern1.txt");
	}
}
