package tp.pr5.mv.command;

public class Quit extends CommandInterpreter{

	@Override
	public void executeCommand() {
		_quit = true;
	}

	public CommandInterpreter parseComm (String commandLine){
		CommandInterpreter comm = null;
		String[] TokenLine = commandLine.split(" ");
		if(TokenLine.length == 1 ){
		if(TokenLine[0].equalsIgnoreCase("QUIT")){
			comm = new Quit();
	
		}
	}
		return comm;
	}
	
}
