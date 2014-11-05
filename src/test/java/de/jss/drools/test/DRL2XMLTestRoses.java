package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.compiler.DRLParser;
import de.jss.drools.compiler.XMLGenerator;

/**
 * DRL parser to XML generator challenge 1.
 *
 * @author Johannes Schramm
 * @version 2014-09-24
 */
public class DRL2XMLTestRoses extends CodeParseGenerateTest {

	@Test
	public void run() {
		run(new DRLParser(), "XCRoses.drl", new XMLGenerator(), "XCRoses.xml");
	}
}
