package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;

/**
 * Parses DRL "CRB.drl" and generates termination report "CRB.txt".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class ReportTestCRB extends ReportTest {

	@Test
	public void run() {
		run(new DRLParser(), "CRB.drl", new INTTRSReporter(), "CRB.txt");
	}
}
