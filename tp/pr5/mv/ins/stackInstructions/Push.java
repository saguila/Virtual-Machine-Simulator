package tp.pr5.mv.ins.stackInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.ins.secuencialInstructions.Secuencial;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Push extends Secuencial{

	public Push(){
	
}
	
	public Push(Integer parameter){
	_parameter = parameter;
}
	
	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) {
		pila.apila(_parameter);
	}

	public Instruction parse (String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("PUSH")){
			i = new Push(Integer.parseInt(ins[1]));
		}
		return i;
	}
	
	@Override
	protected String getInstructionName() {
		return "PUSH";
	}	
	
}
