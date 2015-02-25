package tp.pr5.mv.ins.stackInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;
public class Dup extends StackInstructions{

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException {
		if(pila.numElem() > 0){
		pila.apila(pila.getCima());
				}
		}

	@Override
	protected String getInstructionName() {
		return "DUP";
	}

	@Override
	public Instruction getObject() {
		return new Dup();
	}
	


}
