package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XTTSinglePattern1.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXTTSinglePattern1 extends FireRulesTest {

	@Test
	public void run() {
		run("XTTSinglePattern1.drl");
	}
}
