package tp.pr5.mv.command;

import java.io.IOException;

import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.HaltedCPUException;
import tp.pr5.mv.exceptions.NegativeMemoryException;

public class Step extends CommandInterpreter{
	
	public CommandInterpreter parseComm (String commandLine){
		CommandInterpreter comm = null;
		String[] TokenLine = commandLine.split(" ");
		if(TokenLine.length == 1 ){
		if(TokenLine[0].equalsIgnoreCase("STEP")){
			comm = new Step();
	
		}
	}
		return comm;
	}

	@Override
	public void executeCommand() throws EmpyStackException, IOException, DivZeroException, NegativeMemoryException, HaltedCPUException {
	_cpu.step();}
	
}
