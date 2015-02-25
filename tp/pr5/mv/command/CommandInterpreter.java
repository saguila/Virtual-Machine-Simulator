package tp.pr5.mv.command;

import java.io.IOException;

import tp.pr5.mv.cpu.CPU;
import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.HaltedCPUException;
import tp.pr5.mv.exceptions.NegativeMemoryException;

public abstract class CommandInterpreter {

		protected static CPU _cpu;
		protected static boolean _quit;
		
		
		public static void configureCommandInterpreter(CPU cpu){
			_cpu = cpu;
			_quit = false;
		}
	
		protected abstract CommandInterpreter parseComm(String commandLine);
		public abstract void executeCommand() throws EmpyStackException, IOException, DivZeroException, NegativeMemoryException, HaltedCPUException;
		
		public static boolean isQuit(){
			return _quit;
		}
	public static void setQuit(){
		_quit = true;
	}
}