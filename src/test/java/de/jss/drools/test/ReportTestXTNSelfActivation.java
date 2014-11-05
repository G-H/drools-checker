package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "XTNSelfActivation.drl" and generates termination report
 * "XTNSelfActivation.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestXTNSelfActivation extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "XTNSelfActivation.drl", new INTTRSReporter(),
				"XTNSelfActivation.txt");
	}
}
