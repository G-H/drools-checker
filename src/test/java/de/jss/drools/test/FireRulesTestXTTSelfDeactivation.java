package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XTTSelfDeactivation.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXTTSelfDeactivation extends FireRulesTest {

	@Test
	public void run() {
		run("XTTSelfDeactivation.drl");
	}
}
