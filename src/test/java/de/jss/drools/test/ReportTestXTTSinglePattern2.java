package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTTSinglePattern2.drl" and generates termination report
 * "XTTSinglePattern2.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTTSinglePattern2 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTTSinglePattern2.drl", new INTTRSReporter(),
				"XTTSinglePattern2.txt");
	}
}
