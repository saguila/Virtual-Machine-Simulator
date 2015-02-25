package tp.pr5.mv.command;

import tp.pr5.mv.exceptions.EmpyStackException;

public class CommandPop extends CommandInterpreter {

	public CommandPop() {

	}

	@Override
	protected CommandInterpreter parseComm(String commandLine) {
		CommandInterpreter comm = null;
		String[] tokenLine = commandLine.split(" ");
		if (tokenLine.length == 1) {
			if (tokenLine[0].equalsIgnoreCase("POP")) {

				comm = new CommandPop();
			}
		}
		return comm;
	}

	@Override
	public void executeCommand() throws EmpyStackException {
		_cpu.pop();
	}
}
