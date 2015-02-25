package tp.pr5.mv.ins.stackInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Flip extends StackInstructions{

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException {
		
		if(pila.numElem() > 1){ // no puedo intercambiar la cima con la subcima si no hay elementos.
		int cima = pila.getCima();
		pila.desapila();
		int subcima = pila.getCima();
		pila.desapila();
		pila.apila(cima);
		pila.apila(subcima);
		}
		else{
		
			throw new EmpyStackException(getInstructionName() + " no hay dos operandos en la pila.");
		}
	
	}

	@Override
	protected String getInstructionName() {
		return "FLIP";
	}

	@Override
	public Instruction getObject() {
		return new Flip();
	}
	

}
