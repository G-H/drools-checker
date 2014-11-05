package de.jss.drools.test;

import static org.junit.Assert.fail;

import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

/**
 * Abstract base class for tests, which fire all rules of a given DRL.
 *
 * @author Johannes Schramm
 * @version 2014-09-23
 */
@SuppressWarnings("deprecation")
public abstract class FireRulesTest {

	private static String inputPath = "/home/user/workspaces/jss-drools-checker/jss-drools-checker/test/input/";

	protected void run(String input) {
		final KnowledgeBuilder builder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		final Resource resource = ResourceFactory.newFileResource(inputPath
				+ input);
		builder.add(resource, ResourceType.DRL);
		if (builder.hasErrors()) {
			fail(builder.getErrors().toString());
		}
		final KnowledgeBase base = KnowledgeBaseFactory.newKnowledgeBase();
		base.addKnowledgePackages(builder.getKnowledgePackages());
		final KieSession session = base.newKieSession();
		session.fireAllRules();
		session.dispose();
	}
}
