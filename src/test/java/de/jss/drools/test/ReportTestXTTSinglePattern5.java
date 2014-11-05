package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTTSinglePattern5.drl" and generates termination report
 * "XTTSinglePattern5.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTTSinglePattern5 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTTSinglePattern5.drl", new INTTRSReporter(),
				"XTTSinglePattern5.txt");
	}
}
