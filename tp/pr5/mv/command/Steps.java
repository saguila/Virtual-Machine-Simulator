package tp.pr5.mv.command;

import java.io.IOException;

import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.HaltedCPUException;
import tp.pr5.mv.exceptions.NegativeMemoryException;

public class Steps extends Step{

		private Integer _param;
		
		public Steps() {
		
		}


		public Steps(Integer parametro){
			_param = parametro;
		}
		
		
		public Step parseComm (String commandLine){
			Step comm = null;
			String [] tokenLine = commandLine.split(" ");
			if(tokenLine.length == 2){
			if(tokenLine[0].equalsIgnoreCase("STEP")){
				Integer _param = Integer.parseInt(tokenLine[1]);
				if (_param <= 0){
					comm = null;
				}
				else{
					comm = new Steps(_param);
				}
			}
			}
			return comm;
		}
		
		public void executeCommand() throws EmpyStackException, IOException, DivZeroException, NegativeMemoryException, HaltedCPUException{
			for(int i = 0 ; i < _param & !_cpu.isHalted(); i++)_cpu.step();
		}
}