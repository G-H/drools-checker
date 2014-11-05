package de.jss.drools.analysis;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

import de.jss.drools.lang.Action;
import de.jss.drools.lang.ActionType;
import de.jss.drools.lang.Assignment;
import de.jss.drools.lang.AttributeConstraint;
import de.jss.drools.lang.Binding;
import de.jss.drools.lang.Condition;
import de.jss.drools.lang.Consequence;
import de.jss.drools.lang.Constraint;
import de.jss.drools.lang.Package;
import de.jss.drools.lang.Pattern;
import de.jss.drools.lang.Rule;
import de.jss.drools.lang.Type;

/**
 * Analyzes the provided <code>Package</code> and generates an INTTRS.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-03
 */
public class INTTRSReporter extends PackageReporter {

	/**
	 * Generates the INTTRS for the specified <code>Package</code> and writes it
	 * to the specified <code>OutputStream</code>.
	 *
	 * @param outputStream
	 *            The <code>OutputStream</code> to write the INTTRS to.
	 * @param pkg
	 *            The <code>Package</code> to generate the INTTRS for.
	 */
	@Override
	public void report(OutputStream outputStream, Package pkg) {
		final OutputStreamWriter writer = new OutputStreamWriter(outputStream);
		try {
			for (final Rule r : pkg.getRules()) {
				for (final Consequence c : r.getConsequences()) {
					if (c instanceof Action) {
						final Action a = (Action) c;
						if (a.getType() == ActionType.Modification) {
							for (final Condition d : r.getConditions()) {
								if (d instanceof Pattern) {
									final Pattern p = (Pattern) d;
									if (a.getPatternName().equals(
											p.getOuterBinding())) {

										final Type t = pkg.getFactType(a
												.getFactTypeName());
										String s = makeCondition(t) + " -> "
												+ makeConsequence(t, a) + " "
												+ makeConstraints(t, p) + "\n";
										for (final Binding b : p.getBindings()) {
											s = s.replace(b.getName(),
													b.getValue());
										}
										final LinkedList<String> ss = new LinkedList<String>();
										ss.add(s);
										boolean b = true;
										while (b) {
											b = false;
											for (int i = 0; i < ss.size(); i++) {
												final String x = ss.get(i);
												if (x.contains("!=")) {
													b = true;
													ss.remove(i);
													ss.add(x.replaceFirst("!=",
															">"));
													ss.add(x.replaceFirst("!=",
															"<"));
													break;
												}
											}
										}
										for (final String q : ss) {
											writer.write(q);
										}
									}
								}
							}
						}
					}
				}
			}
			writer.close();
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String makeCondition(Type t) {
		String s = t.getName().replace(".", "_");
		s += "(";
		for (int i = 0; i < t.getAttributes().size(); i++) {
			if (i != 0) {
				s += ", ";
			}
			s += t.getAttributes().get(i).getName();
		}
		s += ")";
		return s;
	}

	private String makeConsequence(Type t, Action a) {
		String s = t.getName().replace(".", "_");
		s += "(";
		for (int i = 0; i < t.getAttributes().size(); i++) {
			if (i != 0) {
				s += ", ";
			}
			boolean f = false;
			for (final Assignment b : a.getAssignments()) {
				if (b.getAttributeName().equals(
						t.getAttributes().get(i).getName())) {
					s += b.getExpression();
					f = true;
					break;
				}
			}
			if (!f) {
				s += t.getAttributes().get(i).getName();
			}
		}
		s += ")";
		return s;
	}

	private String makeConstraints(Type t, Pattern p) {
		String s = "[";
		boolean f = false;
		for (final Constraint c : p.getConstraints()) {
			if (f) {
				s += " && ";
			}
			if (c instanceof AttributeConstraint) {
				final AttributeConstraint a = (AttributeConstraint) c;
				if (a.getRelation().equals("==")) {
					s += a.getAttributeName();
					s += " >= ";
					s += a.getExpression();
					s += " && ";
					s += a.getAttributeName();
					s += " <= ";
					s += a.getExpression();
				} else {
					s += a.getAttributeName();
					s += " ";
					s += a.getRelation();
					s += " ";
					s += a.getExpression();
				}
				f = true;
			}
		}
		s += "]";
		return s;
	}
}
