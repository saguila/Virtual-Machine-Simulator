package tp.pr5.mv.ins.comparisionInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Eq extends Comparation{

	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor, Instrategy in,Outstrategy out) throws EmpyStackException{
	super.execute(pila, memoria, gestor,in,out);
	
	}
	@Override
	protected Integer operacion(Integer operando1, Integer operando2) {
	if(operando1 == operando2){
		return 1;
	}
	else{
		return 0;
	}
	}
	
	@Override
	protected String getInstructionName(){
	return "EQ";
	}

	@Override
	public Instruction parse(String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("EQ")){
			i = new Eq();
		}
		return i;
	}
}
