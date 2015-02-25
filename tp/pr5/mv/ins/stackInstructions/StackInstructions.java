package tp.pr5.mv.ins.stackInstructions;

import java.io.IOException;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public  abstract class StackInstructions implements Instruction{

	@Override
	public abstract void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException, IOException;
	protected abstract String getInstructionName();
	
	public String toString(){
		return getInstructionName();
	}
	
	@Override
	public Instruction parse(String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase(getInstructionName())){
			i = getObject();
		}
		return i;
	}

	public abstract Instruction getObject();
}