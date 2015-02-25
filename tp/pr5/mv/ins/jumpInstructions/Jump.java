package tp.pr5.mv.ins.jumpInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public abstract class Jump implements Instruction{

	@Override
	public abstract void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException;

	public String toString(){
		return getInstructionName();
	}
	
	@Override
	public abstract Instruction parse(String[] instruccion);
	protected abstract String getInstructionName();


}
