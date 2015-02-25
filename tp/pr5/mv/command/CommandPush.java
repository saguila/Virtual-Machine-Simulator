package tp.pr5.mv.command;

public class CommandPush extends CommandInterpreter {

	private Integer _parameter;

	public CommandPush() {

	}

	public CommandPush(Integer param) {
		_parameter = param;
	}

	@Override
	protected CommandInterpreter parseComm(String commandLine) {
		CommandInterpreter comm = null;
		String[] tokenLine = commandLine.split(" ");
		if (tokenLine.length > 1) {
			if (tokenLine[0].equalsIgnoreCase("PUSH")) {

				comm = new CommandPush(Integer.parseInt(tokenLine[1]));
			}
		}
		return comm;
	}

	@Override
	public void executeCommand() {
	 _cpu.push(_parameter);
	}

}
