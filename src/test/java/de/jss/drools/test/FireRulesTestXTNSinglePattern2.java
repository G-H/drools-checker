package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XTNSinglePattern2.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXTNSinglePattern2 extends FireRulesTest {

	@Test
	public void run() {
		run("XTNSinglePattern2.drl");
	}
}
