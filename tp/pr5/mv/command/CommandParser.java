package tp.pr5.mv.command;


public class CommandParser {

	private static CommandInterpreter [] commands = {
		new Step(), new Run(), new Steps(), new Quit() ,new CommandPush(),new CommandPop(),new Write()};
	
	
	public static CommandInterpreter parseCommand(String line){
		CommandInterpreter com = null;
		for (CommandInterpreter in : commands){
			if((com = in.parseComm(line)) != null) return com;
			
		}
		return com;
	}
		
}