package tp.pr5.mv.command;

import java.io.IOException;

import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.HaltedCPUException;
import tp.pr5.mv.exceptions.NegativeMemoryException;

public class Run extends Step{
	public Run(){
		super();
	}
	
	public CommandInterpreter parseComm (String commandLine){
		CommandInterpreter comm = null;
		String[] TokenLine = commandLine.split(" ");
		if(TokenLine.length == 1 ){
		if(TokenLine[0].equalsIgnoreCase("RUN")){
			comm = new Run();
	
		}
	}
		return comm;
	}
	
	public void executeCommand() throws EmpyStackException, IOException, DivZeroException, NegativeMemoryException, HaltedCPUException{
	_cpu.run();
	}
}
