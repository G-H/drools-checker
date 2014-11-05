package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTTSinglePattern3.drl" and generates termination report
 * "XTTSinglePattern3.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTTSinglePattern3 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTTSinglePattern3.drl", new INTTRSReporter(),
				"XTTSinglePattern3.txt");
	}
}
