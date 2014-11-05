package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XTNMultiplePatterns1.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXTNMultiplePatterns1 extends FireRulesTest {

	@Test
	public void run() {
		run("XTNMultiplePatterns1.drl");
	}
}
