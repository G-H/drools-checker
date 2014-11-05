package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTTSinglePattern4.drl" and generates termination report
 * "XTTSinglePattern4.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTTSinglePattern4 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTTSinglePattern4.drl", new INTTRSReporter(),
				"XTTSinglePattern4.txt");
	}
}
