package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XCRoses.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXCRoses extends FireRulesTest {

	@Test
	public void run() {
		run("XCRoses.drl");
	}
}
