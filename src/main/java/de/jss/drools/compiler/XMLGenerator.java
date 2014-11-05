package de.jss.drools.compiler;

import java.io.OutputStream;

import javanet.staxutils.IndentingXMLStreamWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import de.jss.drools.lang.Action;
import de.jss.drools.lang.Assignment;
import de.jss.drools.lang.Attribute;
import de.jss.drools.lang.AttributeConstraint;
import de.jss.drools.lang.Binding;
import de.jss.drools.lang.Condition;
import de.jss.drools.lang.ConditionConnective;
import de.jss.drools.lang.Consequence;
import de.jss.drools.lang.Constraint;
import de.jss.drools.lang.ConstraintConnective;
import de.jss.drools.lang.Global;
import de.jss.drools.lang.Message;
import de.jss.drools.lang.Package;
import de.jss.drools.lang.Pattern;
import de.jss.drools.lang.Rule;
import de.jss.drools.lang.Type;

/**
 * Generates XML for <code>Package</code> representations.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class XMLGenerator extends CodeGenerator {

	/**
	 * Generates XML for the specified <code>Package</code> and writes it to the
	 * specified <code>OutputStream</code>.
	 *
	 * @param outputStream
	 *            The <code>OutputStream</code> to write XML to.
	 * @param pkg
	 *            The <code>Package</code> to generate XML for.
	 * @throws CodeGeneratorException
	 *             Indicates that an error occurred while generating XML.
	 */
	@Override
	public void generate(OutputStream outputStream, Package pkg)
			throws CodeGeneratorException {
		try {
			final XMLOutputFactory factory = XMLOutputFactory.newInstance();
			final XMLStreamWriter writer = factory
					.createXMLStreamWriter(outputStream);
			final IndentingXMLStreamWriter identingWriter = new IndentingXMLStreamWriter(
					writer);
			identingWriter.setIndent("\t");
			identingWriter.writeStartDocument();
			generate(identingWriter, pkg);
			identingWriter.writeEndDocument();
			identingWriter.close();
		} catch (final XMLStreamException e) {
			throw new CodeGeneratorException(e);
		}
	}

	private void generate(XMLStreamWriter writer, Action action)
			throws XMLStreamException {
		writer.writeStartElement("action");
		writer.writeAttribute("factType", action.getFactTypeName());
		if (action.getPatternName() != null) {
			writer.writeAttribute("pattern", action.getPatternName());
		}
		writer.writeAttribute("type", action.getType().toString());
		for (final Assignment a : action.getAssignments()) {
			generate(writer, a);
		}
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Assignment assignment)
			throws XMLStreamException {
		writer.writeStartElement("assignment");
		writer.writeAttribute("attribute", assignment.getAttributeName());
		writer.writeAttribute("expression", assignment.getExpression());
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Attribute attribute)
			throws XMLStreamException {
		writer.writeStartElement("attribute");
		writer.writeAttribute("name", attribute.getName());
		writer.writeAttribute("type", attribute.getType());
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, AttributeConstraint constraint)
			throws XMLStreamException {
		writer.writeStartElement("constraint");
		writer.writeAttribute("attribute", constraint.getAttributeName());
		writer.writeAttribute("expression", constraint.getExpression());
		writer.writeAttribute("relation", constraint.getRelation());
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Binding binding)
			throws XMLStreamException {
		writer.writeStartElement("binding");
		writer.writeAttribute("expression", binding.getValue());
		writer.writeAttribute("name", binding.getName());
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Condition condition)
			throws XMLStreamException {
		if (condition instanceof ConditionConnective) {
			generate(writer, (ConditionConnective) condition);
		} else if (condition instanceof Pattern) {
			generate(writer, (Pattern) condition);
		}
	}

	private void generate(XMLStreamWriter writer,
			ConditionConnective conditionConnective) throws XMLStreamException {
		writer.writeStartElement("connective");
		writer.writeAttribute("type", conditionConnective.getType().toString());
		for (final Condition c : conditionConnective.getConditions()) {
			generate(writer, c);
		}
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Consequence consequence)
			throws XMLStreamException {
		if (consequence instanceof Action) {
			generate(writer, (Action) consequence);
		} else if (consequence instanceof Message) {
			generate(writer, (Message) consequence);
		}
	}

	private void generate(XMLStreamWriter writer, Constraint constraint)
			throws XMLStreamException {
		if (constraint instanceof ConstraintConnective) {
			generate(writer, (ConstraintConnective) constraint);
		} else if (constraint instanceof AttributeConstraint) {
			generate(writer, (AttributeConstraint) constraint);
		}
	}

	private void generate(XMLStreamWriter writer,
			ConstraintConnective constraintConnective)
					throws XMLStreamException {
		writer.writeStartElement("connective");
		writer.writeAttribute("type", constraintConnective.getType().toString());
		for (final Constraint c : constraintConnective.getConstraints()) {
			generate(writer, c);
		}
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Global global)
			throws XMLStreamException {
		writer.writeStartElement("global");
		writer.writeAttribute("name", global.getName());
		writer.writeAttribute("type", global.getType());
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Message message)
			throws XMLStreamException {
		writer.writeStartElement("message");
		writer.writeAttribute("value", message.getValue());
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Package pkg)
			throws XMLStreamException {
		writer.writeStartElement("package");
		writer.writeAttribute("name", pkg.getName());
		for (final Global g : pkg.getGlobals()) {
			generate(writer, g);
		}
		for (final Type t : pkg.getFactTypes()) {
			generate(writer, t);
		}
		for (final Rule r : pkg.getRules()) {
			generate(writer, r);
		}
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Pattern pattern)
			throws XMLStreamException {
		writer.writeStartElement("pattern");
		writer.writeAttribute("type", pattern.getTypeName());
		for (final Binding b : pattern.getBindings()) {
			generate(writer, b);
		}
		for (final Constraint c : pattern.getConstraints()) {
			generate(writer, c);
		}
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Rule rule)
			throws XMLStreamException {
		writer.writeStartElement("rule");
		writer.writeAttribute("name", rule.getName());
		writer.writeStartElement("conditions");
		for (final Condition c : rule.getConditions()) {
			generate(writer, c);
		}
		writer.writeEndElement();
		writer.writeStartElement("consequences");
		for (final Consequence c : rule.getConsequences()) {
			generate(writer, c);
		}
		writer.writeEndElement();
		writer.writeEndElement();
	}

	private void generate(XMLStreamWriter writer, Type type)
			throws XMLStreamException {
		writer.writeStartElement("type");
		writer.writeAttribute("name", type.getName());
		for (final Attribute a : type.getAttributes()) {
			generate(writer, a);
		}
		writer.writeEndElement();
	}
}
