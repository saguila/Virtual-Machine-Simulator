package tp.pr5.mv.ins.secuencialInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public abstract class Secuencial implements Instruction{

	protected Integer _parameter;
	
	public abstract void execute(OperandStack<Integer> pila,Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws NegativeMemoryException, EmpyStackException ;

	protected abstract String getInstructionName();
	
	public String toString(){
		return getInstructionName() + " " + _parameter;
	}
	
}
