package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XTTSinglePattern3.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXTTSinglePattern3 extends FireRulesTest {

	@Test
	public void run() {
		run("XTTSinglePattern3.drl");
	}
}
