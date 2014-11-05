package de.jss.drools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import de.jss.drools.analysis.INTTRSReporter;
import de.jss.drools.compiler.DRLParser;
import de.jss.drools.compiler.XMLGenerator;

/**
 * The command line interface for the application.
 *
 * @author Johannes Schramm
 * @version 0.9.1, 2014-11-04
 */
public class CLI {

	/**
	 * The main entry point for the application.
	 *
	 * @param args
	 *            The arguments for the command line interface.
	 */
	public static void main(String[] args) {
		final CommandLineParser clParser = new BasicParser();
		final Options options = new Options();
		options.addOption("H", "help", false, "display this help and exit");
		options.addOption("I", "input", true, "specify input file");
		options.addOption("O", "output", true, "specify output file");
		options.addOption("T", "type", true, "specify output type:"
				+ "\n\t\t\t INTTRS for integer term rewriting system"
				+ "\n\t\t\t XML for extensible markup language");
		options.addOption("V", "version", false,
				"output version information and exit");
		try {
			final CommandLine line = clParser.parse(options, args);
			if (line.hasOption("help")) {
				final HelpFormatter formatter = new HelpFormatter();
				formatter.printHelp("java -jar drools-checker-0.9.1.jar",
						options, true);
			} else if (line.hasOption("version")) {
				final Package pkg = Package.getPackage("de.jss.drools");
				System.out.print("Implementation: ");
				System.out.println(pkg.getImplementationTitle());
				System.out.print("Version: ");
				System.out.println(pkg.getImplementationVersion());
			} else if (!line.hasOption("input") || !line.hasOption("output")
					|| !line.hasOption("type")) {
				System.out.print("Required options: ");
				System.out.println("--input <arg> --output <arg> --type <arg>");
			} else if (!line.getOptionValue("type").equals("INTTRS")
					&& !line.getOptionValue("type").equals("XML")) {
				System.out
				.println("Option --type must be followed by INTTRS or XML");
			} else {
				final DRLParser drlParser = new DRLParser();
				final FileInputStream inputStream = new FileInputStream(
						new File(line.getOptionValue("input")));
				final de.jss.drools.lang.Package pkg = drlParser
						.parse(inputStream);
				final FileOutputStream outputStream = new FileOutputStream(
						new File(line.getOptionValue("output")));
				if (line.getOptionValue("type").equals("INTTRS")) {
					final INTTRSReporter reporter = new INTTRSReporter();
					reporter.report(outputStream, pkg);
				} else if (line.getOptionValue("type").equals("XML")) {
					final XMLGenerator generator = new XMLGenerator();
					generator.generate(outputStream, pkg);
				}
				inputStream.close();
				outputStream.close();
			}
		} catch (final Exception e) {
			System.out.println("The following exception occured:");
			System.out.println(e.getMessage());
		}
	}
}
