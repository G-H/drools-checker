package de.jss.drools.compiler;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.drools.compiler.builder.impl.KnowledgeBuilderConfigurationImpl;
import org.drools.compiler.builder.impl.KnowledgeBuilderImpl;
import org.drools.compiler.compiler.DrlExprParser;
import org.drools.compiler.compiler.DrlParser;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.lang.descr.AtomicExprDescr;
import org.drools.compiler.lang.descr.BaseDescr;
import org.drools.compiler.lang.descr.ConstraintConnectiveDescr;
import org.drools.compiler.lang.descr.PackageDescr;
import org.drools.compiler.lang.descr.RelationalExprDescr;
import org.drools.compiler.lang.descr.RuleDescr;
import org.drools.core.base.ClassFieldReader;
import org.drools.core.base.ClassObjectType;
import org.drools.core.definitions.InternalKnowledgePackage;
import org.drools.core.definitions.rule.impl.RuleImpl;
import org.drools.core.factmodel.ClassDefinition;
import org.drools.core.factmodel.FieldDefinition;
import org.drools.core.rule.ConsequenceMetaData;
import org.drools.core.rule.Declaration;
import org.drools.core.rule.GroupElement;
import org.drools.core.rule.PredicateConstraint;
import org.drools.core.rule.RuleConditionElement;
import org.drools.core.rule.TypeDeclaration;
import org.drools.core.rule.constraint.MvelConstraint;
import org.drools.core.spi.PatternExtractor;
import org.kie.internal.builder.conf.LanguageLevelOption;

import de.jss.drools.lang.Action;
import de.jss.drools.lang.ActionType;
import de.jss.drools.lang.Assignment;
import de.jss.drools.lang.Attribute;
import de.jss.drools.lang.AttributeConstraint;
import de.jss.drools.lang.Binding;
import de.jss.drools.lang.Condition;
import de.jss.drools.lang.ConditionConnective;
import de.jss.drools.lang.ConditionConnectiveType;
import de.jss.drools.lang.Consequence;
import de.jss.drools.lang.Constraint;
import de.jss.drools.lang.ConstraintConnective;
import de.jss.drools.lang.ConstraintConnectiveType;
import de.jss.drools.lang.Global;
import de.jss.drools.lang.Message;
import de.jss.drools.lang.Package;
import de.jss.drools.lang.Pattern;
import de.jss.drools.lang.Rule;
import de.jss.drools.lang.Type;
import de.jss.drools.lang.UnknownConstraint;

/**
 * Parses DRL into <code>Package</code> representation.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class DRLParser extends CodeParser {

	private final List<String> bindingsG;
	private final List<String> bindingsR;
	private final DrlExprParser drlExprParser;
	private final DrlParser drlParser;
	private final KnowledgeBuilderImpl knowledgeBuilder;

	/**
	 * Initializes a new instance of the <code>DRLParser</code> class.
	 */
	public DRLParser() {
		this(new KnowledgeBuilderConfigurationImpl());
	}

	/**
	 * Initializes a new instance of the <code>DRLParser</code> class using the
	 * specified class loaders.
	 *
	 * @param classLoaders
	 *            The class loaders to use.
	 *
	 */
	public DRLParser(ClassLoader[] classLoaders) {
		this(new KnowledgeBuilderConfigurationImpl(classLoaders));
	}

	/**
	 * Initializes a new instance of the <code>DRLParser</code> class using the
	 * specified configuration.
	 *
	 * @param configuration
	 *            The configuration to use.
	 *
	 */
	public DRLParser(KnowledgeBuilderConfigurationImpl configuration) {
		bindingsG = new LinkedList<String>();
		bindingsR = new LinkedList<String>();
		knowledgeBuilder = new KnowledgeBuilderImpl(configuration);
		drlExprParser = new DrlExprParser(LanguageLevelOption.DRL6);
		drlParser = new DrlParser();
	}

	/**
	 * Parses the DRL from the specified <code>InputStream</code> into a
	 * <code>Package</code>.
	 *
	 * @param inputStream
	 *            The <code>InputStream</code> to read DRL from.
	 * @return The <code>Package</code> parsed from the DRL.
	 * @throws CodeParserException
	 *             Indicates that an error occurred while parsing DRL.
	 */
	@Override
	public Package parse(InputStream inputStream) throws CodeParserException {
		return parse(new InputStreamReader(inputStream));
	}

	/**
	 * Parses the DRL from the specified <code>PackageDescr</code> into a
	 * <code>Package</code>.
	 *
	 * @param descr
	 *            The <code>PackageDescr</code> to read DRL from.
	 * @return The <code>Package</code> parsed from the DRL.
	 * @throws CodeParserException
	 *             Indicates that an error occurred while parsing DRL.
	 */
	public Package parse(PackageDescr descr) throws CodeParserException {
		knowledgeBuilder.addPackage(descr);
		if (knowledgeBuilder.hasErrors()) {
			throw new CodeParserException(knowledgeBuilder.getErrors()
					.toString());
		}
		return parseP(descr, knowledgeBuilder.getPackage());
	}

	/**
	 * Parses the DRL from the specified <code>Reader</code> into a
	 * <code>Package</code>.
	 *
	 * @param reader
	 *            The <code>Reader</code> to read DRL from.
	 * @return The <code>Package</code> parsed from the DRL.
	 * @throws CodeParserException
	 *             Indicates that an error occurred while parsing DRL.
	 */
	public Package parse(Reader reader) throws CodeParserException {
		try {
			final PackageDescr descr = drlParser.parse(reader);
			if (drlParser.hasErrors()) {
				throw new CodeParserException(drlParser.getErrors().toString());
			}
			return parse(descr);
		} catch (final DroolsParserException e) {
			throw new CodeParserException(e);
		}
	}

	private Package parseP(PackageDescr descr,
			InternalKnowledgePackage knowledgePackage) {
		bindingsG.clear();
		final Package pkg = new Package(descr.getName());
		for (final Map.Entry<String, String> e : knowledgePackage.getGlobals()
				.entrySet()) {
			pkg.getGlobals().add(new Global(e.getKey(), e.getValue()));
			bindingsG.add(e.getKey());
		}
		for (final TypeDeclaration d : knowledgePackage.getTypeDeclarations()
				.values()) {
			pkg.getFactTypes().add(parsePT(d.getTypeClassDef()));
		}
		int i = 0;
		for (final org.kie.api.definition.rule.Rule r : knowledgePackage
				.getRules()) {
			pkg.getRules().add(parsePR(descr.getRules().get(i), (RuleImpl) r));
			i++;
		}
		return pkg;
	}

	private Rule parsePR(RuleDescr descr, RuleImpl impl) {
		bindingsR.clear();
		final Rule rule = new Rule(impl.getName());
		for (final RuleConditionElement e : impl.getLhs().getChildren()) {
			rule.getConditions().add(parsePRL(e));
		}
		final String[] consequences = descr.getConsequence().toString()
				.split(";");
		int i = 0;
		for (String s : consequences) {
			s = s.trim();
			if (s.startsWith("insert")) {
				rule.getConsequences().add(
						parsePRR(impl.getConsequenceMetaData().getStatements()
								.get(i), null));
				i++;
			} else if (s.startsWith("modify")) {
				rule.getConsequences().add(
						parsePRR(impl.getConsequenceMetaData().getStatements()
								.get(i),
								s.substring(s.indexOf("(") + 1, s.indexOf(")"))
										.trim()));
				i++;
			} else if (s.startsWith("delete")) {
				rule.getConsequences().add(
						parsePRR(impl.getConsequenceMetaData().getStatements()
								.get(i),
								s.substring(s.indexOf("(") + 1, s.indexOf(")"))
										.trim()));
				i++;
			} else if (!s.isEmpty()) {
				rule.getConsequences().add(new Message(s));
			}
		}
		return rule;
	}

	private Condition parsePRL(RuleConditionElement element) {
		if (element instanceof GroupElement) {
			return parsePRLC((GroupElement) element);
		} else if (element instanceof org.drools.core.rule.Pattern) {
			return parsePRLP((org.drools.core.rule.Pattern) element);
		} else {
			throw new RuntimeException();
		}
	}

	private Condition parsePRLC(GroupElement element) {
		ConditionConnectiveType type;
		switch (element.getType()) {
		case AND:
			type = ConditionConnectiveType.Conjunction;
			break;
		case OR:
			type = ConditionConnectiveType.Disjunction;
			break;
		case EXISTS:
		case NOT:
			type = ConditionConnectiveType.Negation;
			break;
		default:
			throw new RuntimeException();
		}
		final ConditionConnective connective = new ConditionConnective(type);
		for (final RuleConditionElement e : element.getChildren()) {
			connective.getConditions().add(parsePRL(e));
		}
		return connective;
	}

	private Pattern parsePRLP(org.drools.core.rule.Pattern rulePattern) {
		String name;
		if (rulePattern.getDeclaration() != null) {
			name = rulePattern.getDeclaration().getIdentifier();
		} else {
			name = "Pattern" + String.valueOf(rulePattern.getIndex());
		}
		final Pattern pattern = new Pattern(
				((ClassObjectType) rulePattern.getObjectType()).getClassName());
		for (final Map.Entry<String, Declaration> e : rulePattern
				.getInnerDeclarations().entrySet()) {
			if (e.getValue().getExtractor() instanceof ClassFieldReader) {
				final ClassFieldReader accessor = (ClassFieldReader) e
						.getValue().getExtractor();
				pattern.getBindings().add(
						new Binding(e.getKey(), accessor.getFieldName()));
			} else if (e.getValue().getExtractor() instanceof PatternExtractor) {
				pattern.setOuterBinding(e.getKey());
			}
			bindingsR.add(e.getKey());
		}
		for (final org.drools.core.spi.Constraint c : rulePattern
				.getConstraints()) {
			pattern.getConstraints().add(parsePRLPC(c, name));
		}
		return pattern;
	}

	private Constraint parsePRLPC(org.drools.core.spi.Constraint constraint,
			String bind) {
		if (constraint instanceof MvelConstraint) {
			return parsePRLPCM((MvelConstraint) constraint, bind);
		} else if (constraint instanceof PredicateConstraint) {
			return parsePRLPCP((PredicateConstraint) constraint, bind);
		} else {
			throw new RuntimeException("Constraint not supported");
		}
	}

	private Constraint parsePRLPCM(MvelConstraint constraint, String bind) {
		return parsePRLPCME(drlExprParser.parse(constraint.getExpression())
				.getDescrs().get(0), bind);
	}

	private Constraint parsePRLPCME(BaseDescr descr, String bind) {
		if (descr instanceof ConstraintConnectiveDescr) {
			return parsePRLPCMEC((ConstraintConnectiveDescr) descr, bind);
		} else if (descr instanceof RelationalExprDescr) {
			return parsePRLPCMER((RelationalExprDescr) descr, bind);
		}
		throw new RuntimeException();
	}

	private Constraint parsePRLPCMEC(ConstraintConnectiveDescr descr,
			String bind) {
		ConstraintConnectiveType type;
		switch (descr.getConnective()) {
		case AND:
			type = ConstraintConnectiveType.Conjunction;
			break;
		case OR:
			type = ConstraintConnectiveType.Disjunction;
			break;
		default:
			throw new RuntimeException();
		}
		final ConstraintConnective constraint = new ConstraintConnective(type);
		for (final BaseDescr d : descr.getDescrs()) {
			constraint.getConstraints().add(parsePRLPCME(d, bind));
		}
		return constraint;
	}

	private Constraint parsePRLPCMER(RelationalExprDescr descr, String bind) {
		final String left = ((AtomicExprDescr) descr.getLeft()).getExpression();
		final String right = ((AtomicExprDescr) descr.getRight())
				.getExpression();
		final AttributeConstraint p = new AttributeConstraint(left,
				descr.getOperator(), right);
		return p;
	}

	private Constraint parsePRLPCP(PredicateConstraint constraint, String bind) {
		return new UnknownConstraint();
	}

	private Consequence parsePRR(ConsequenceMetaData.Statement statement,
			String patternName) {
		final ActionType type;
		switch (statement.getType()) {
		case INSERT:
			type = ActionType.Insertion;
			break;
		case MODIFY:
			type = ActionType.Modification;
			break;
		case RETRACT:
			type = ActionType.Retraction;
			break;
		default:
			throw new RuntimeException();
		}
		final Action action = new Action(statement.getFactClassName(),
				patternName, type);
		if (statement.getFields() != null) {
			for (final ConsequenceMetaData.Field f : statement.getFields()) {
				action.getAssignments().add(
						new Assignment(f.getName(), f.getValue()));
			}
		}
		return action;
	}

	private Type parsePT(ClassDefinition definition) {
		final Type type = new Type(definition.getName());
		for (final FieldDefinition d : definition.getFieldsDefinitions()) {
			type.getAttributes().add(parsePTA(d));
		}
		return type;
	}

	private Attribute parsePTA(FieldDefinition definition) {
		return new Attribute(definition.getName(), definition.getTypeName());
	}
}
