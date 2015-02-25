package tp.pr5.mv.command;

import tp.pr5.mv.exceptions.NegativeMemoryException;


public class Write extends CommandInterpreter{

	private Integer _parameter1;
	private Integer _parameter2;
	public Write(){
		
	}
public Write(Integer param1,Integer param2){
	_parameter1 = param1;
	_parameter2 = param2;
}
	
	@Override
	protected CommandInterpreter parseComm(String commandLine) {
		CommandInterpreter comm = null;
		String[] tokenLine = commandLine.split(" ");
		if(tokenLine.length == 3 ){
		if(tokenLine[0].equalsIgnoreCase("WRITE")){
			
			comm = new Write(Integer.parseInt(tokenLine[1]),Integer.parseInt(tokenLine[2]));
		}
		}
		return comm;
	}

	@Override
	public void executeCommand() throws NegativeMemoryException {
		_cpu.setMem(_parameter1,_parameter2);

	}

}


