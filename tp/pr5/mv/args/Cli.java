package tp.pr5.mv.args;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.ParseException;

import tp.pr5.mv.TPMV;


public class Cli{
	
	public static void parseOption(String args[]) throws ParseException{
		
		Options opt = new Options();
		Option help = new Option("h","help", false, "Ayuda");
		Option prog = new Option("a", "prog",true, "Fichero con el codigo del programa a ejecutar. Obligatorio en modo batch.");
		prog.setArgName("programfile");
		Option in = new Option("i", "in", true, "Entrada del programa");
		in.setArgName("infile");
		Option out = new Option("o","out", true, "Fichero donde se guarda la salida del programa de la maquina.");
		out.setArgName("outfile");
		Option mode = new Option("m","mode", true, "Modo de funcionamiento (batch , interactive, window).");
		mode.setArgName("mode");
		
		
		
		opt.addOption(help);
		opt.addOption(prog);
		opt.addOption(in);
		opt.addOption(out);
		opt.addOption(mode);

        BasicParser parser = new BasicParser();
        CommandLine cl = parser.parse(opt,args);
        
        if (cl.hasOption("h")){
            HelpFormatter f = new HelpFormatter();
            f.printHelp("[-a <programfile>] [-h] [-i <infile>] [-m <mode>] [-o <outfile>]", opt);
            System.exit(1);
        }
       
        else{
        	 if (cl.hasOption("m")){
        	 if (cl.getOptionValue("mode").toLowerCase().equals("batch")) TPMV.set_executionMode(0);
        	 if (cl.getOptionValue("mode").toLowerCase().equals("interactive")) TPMV.set_executionMode(1);
        	 if (cl.getOptionValue("mode").toLowerCase().equals("window")) TPMV.set_executionMode(2);
        	
        if (cl.hasOption("a"))
	TPMV.set_programFileName(cl.getOptionValue("a"));
        
        if (cl.hasOption("i"))
       TPMV.set_inStreamFileName(cl.getOptionValue("i"));
        
        if (cl.hasOption("o"))
	TPMV.set_outStreamFileName(cl.getOptionValue("o"));
        
        	 }
        }
        
   
       
		
        
}

	
	 
}
