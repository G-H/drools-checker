package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XTTSinglePattern2.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXTTSinglePattern2 extends FireRulesTest {

	@Test
	public void run() {
		run("XTTSinglePattern2.drl");
	}
}
