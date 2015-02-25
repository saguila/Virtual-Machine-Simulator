package tp.pr5.mv.ins.booleanInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public abstract class Booleans implements Instruction{

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException{
		
		if(pila.numElem() > 1){
		Integer cima = pila.getCima();
		pila.desapila();
		Integer subcima = pila.getCima();
		pila.desapila();
		pila.apila(operacion(subcima,cima));
		}
		else{
			throw new EmpyStackException(this.getInstructionName() + " la pila esta vacia.");
		}

	}
	
	public String toString(){
		return this.getInstructionName();
	}
	
	protected abstract String getInstructionName();
	public abstract Instruction parse(String [] ins);
	protected abstract Integer operacion(Integer operando1, Integer operando2);
}
