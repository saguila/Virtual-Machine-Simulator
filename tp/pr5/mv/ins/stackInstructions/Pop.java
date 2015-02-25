package tp.pr5.mv.ins.stackInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Pop extends StackInstructions{

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException {
			pila.desapila();
	}


	@Override
	protected String getInstructionName() {
		return "POP";
	}


	@Override
	public Instruction getObject() {
		return new Pop();
	}



	
}
