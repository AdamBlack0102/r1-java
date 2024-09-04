/*
package edu.nju;

import org.apache.commons.cli.*;

public class CommandLineUtil {

    private static CommandLine commandLine;
    private static Options options = new Options();
    private static boolean sideEffect = false;

    public static final String WRONG_MESSAGE = "Invalid input.";

    */
/**
     * you can define options here
     * or you can create a func such as [static void defineOptions()] and call it before parse input
     *//*

    static {
        defineOptions();
    }

    static void defineOptions() {
        Option help = new Option("h", "help", true, "Print this message.");
        Option print = Option.builder("p")
                .argName("arg")
                .hasArg()
                .desc("Print arg")
                .build();
        Option set = new Option("s", "set", false, "set sideEffect in CommandlineUtil true");
        options.addOption(help);
        options.addOption(print);
        options.addOption(set);
    }

    public void main(String[] args) {
        if(args == null || args.length == 0) {
            System.out.println(WRONG_MESSAGE);
            return;
        }
        parseInput(args);
        if(commandLine.getOptions().length == 0) {
            System.out.println(WRONG_MESSAGE);
            return;
        }
        handleOptions();
    }

    */
/**
     * Print the usage of all options
     *//*

    private static void printHelpMessage() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("CommandLineUtil", options);
    }

    */
/**
     * Parse the input and handle exception
     *
     * @param args origin args form input
     *//*

    public static void parseInput(String[] args) {
        CommandLineParser parser = new DefaultParser();
        try {
            commandLine = parser.parse(options, args);
            handleOptions();
        } catch (ParseException exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
            System.exit(-1);
        }
    }

    */
/**
     * You can handle options here or create your own func
     *//*

    public static void handleOptions() {
        if (commandLine.hasOption("h")) {
            printHelpMessage();
            System.exit(0);
        } else {
            String[] Args = commandLine.getArgs();
            if (Args.length == 0) {
                System.out.println("No command line arguments.");
                System.exit(-1);
            }

            if (commandLine.hasOption("p")) {
                String arg = commandLine.getOptionValue("p");
                System.out.println(arg);
            }

            if (commandLine.hasOption("s")) {
                sideEffect = !sideEffect;
            }
        }
    }
    public boolean getSideEffectFlag() {
        return sideEffect;
    }
}
*/
package edu.nju;

import org.apache.commons.cli.*;

public class CommandLineUtil {
    private static CommandLine commandLine;
    private static CommandLineParser parser = new DefaultParser();
    private static Options options = new Options();
    private boolean sideEffect;
    public static final String WRONG_MESSAGE = "Invalid input.";

    /**
     * you can define options here
     * or you can create a func such as [static void defineOptions()] and call it before parse input
     */
    static {
        options.addOption("h", "help", false, "Print help messages");
        options.addOption("p", "print",true, "Print the Arguments");
        options.addOption("s", false, "Set the boolean value of @param sideEffect");
    }

    public void main(String[] args){
        if(args == null || args.length == 0){
            System.out.println(WRONG_MESSAGE);
            return;
        }
        parseInput(args);
        if(commandLine.getOptions().length == 0){
            System.out.println(WRONG_MESSAGE);
            return;
        }
        handleOptions();
    }

    /**
     * Print the usage of all options
     */
    private static void printHelpMessage() {
        System.out.println("help");
    }

    /**
     * Parse the input and handle exception
     * @param args origin args form input
     */
    public void parseInput(String[] args) {
        try {
            // parse the command line arguments
            commandLine = parser.parse( options, args);
        }
        catch( ParseException exp ) {
            // oops, something went wrong
            System.err.println( exp.getMessage() );
            System.exit(-1);
        }
    }

    /**
     * You can handle options here or create your own func
     */
    public void handleOptions() {
        //parseInput();
        if (commandLine.hasOption("h")){
            printHelpMessage();
        }
        else if(commandLine.hasOption("s")){
            sideEffect = !sideEffect;
        }
        else if(commandLine.hasOption("p") || commandLine.hasOption("print")){
            if(commandLine.getArgs().length != 0 )
                System.out.println(commandLine.getOptionValue("p"));
            else System.out.println(WRONG_MESSAGE);
        }
    }

    public boolean getSideEffectFlag(){
        return this.sideEffect;
    }

}

