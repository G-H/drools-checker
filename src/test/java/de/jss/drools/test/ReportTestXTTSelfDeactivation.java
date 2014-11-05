package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTTSelfDeactivation.drl" and generates termination report
 * "XTNSelfDeactivation.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTTSelfDeactivation extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTTSelfDeactivation.drl", new INTTRSReporter(),
				"XTTSelfDeactivation.txt");
	}
}
