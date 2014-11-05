package de.jss.drools.test;

import org.junit.Test;

/**
 * Fires all rules of DRL "XTNSelfActivation.drl".
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
public class FireRulesTestXTNSelfActivation extends FireRulesTest {

	@Test
	public void run() {
		run("XTNSelfActivation.drl");
	}
}
