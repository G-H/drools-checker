package de.jss.drools.test;

import org.junit.Test;

import de.jss.drools.compiler.DRLParser;
import de.jss.drools.compiler.XMLGenerator;

/**
 * DRL parser to XML generator challenge 3.
 *
 * @author Johannes Schramm
 * @version 2014-09-24
 */
public class DRL2XMLTestChallenge3 extends CodeParseGenerateTest {

	@Test
	public void run() {
		run(new DRLParser(), "ParserChallenge3.drl", new XMLGenerator(),
				"ParserChallenge3.xml");
	}
}
