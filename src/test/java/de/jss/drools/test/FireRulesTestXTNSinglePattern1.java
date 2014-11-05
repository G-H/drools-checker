package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XTNSinglePattern1.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXTNSinglePattern1 extends FireRulesTest {

	@Test
	public void run() {
		run("XTNSinglePattern1.drl");
	}
}
