package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTTSinglePattern1.drl" and generates termination report
 * "XTTSinglePattern1.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTTSinglePattern1 extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTTSinglePattern1.drl", new INTTRSReporter(),
				"XTTSinglePattern1.txt");
	}
}
