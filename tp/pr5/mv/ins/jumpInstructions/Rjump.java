package tp.pr5.mv.ins.jumpInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Rjump implements Instruction{

	Integer _parameter;
	public Rjump(){
	}
	
	public Rjump(Integer parameter){
	_parameter = parameter;
	}
	
	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) {
		gestor.incrementPc(_parameter + gestor.currentPc());
	}

	public Instruction parse(String[] ins) {
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("RJUMP")){
			i = new Rjump(Integer.parseInt(ins[1]));
		}
		return i;
	}
	

	@Override
	public String toString() {
		return "RJUMP " + _parameter;
	}
}
