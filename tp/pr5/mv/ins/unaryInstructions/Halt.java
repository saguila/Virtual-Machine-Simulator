package tp.pr5.mv.ins.unaryInstructions;

import tp.pr5.mv.command.CommandInterpreter;
import tp.pr5.mv.cpu.*;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Halt implements Instruction {

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,
			ExecuteManager gestor,Instrategy in,Outstrategy out) {
gestor.set_halt(true);
CommandInterpreter.setQuit();
	}

	@Override
	public Instruction parse(String[] ins) {
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("HALT")){
			i = new Halt();
		}
		return i;
	}

	@Override
	public String toString() {
		return "HALT";
	}

}
