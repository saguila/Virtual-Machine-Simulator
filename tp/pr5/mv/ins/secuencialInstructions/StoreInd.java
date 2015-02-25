package tp.pr5.mv.ins.secuencialInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class StoreInd implements Instruction {

	public StoreInd(){	
	}
	
	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException, NegativeMemoryException {
	int top = 0;
	if(pila.numElem() >= 1){
		top = pila.getCima();
		pila.desapila();
		memoria.insertarCelda(pila.getCima(),top);
	}
	else throw new EmpyStackException(this.toString() + " la pila contiene menos de dos elementos");

	}	
	
	public Instruction parse (String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("STOREIND")){
			i = new StoreInd();
		}
		return i;
	}

	@Override
	public String toString() {
		return "STOREIND ";
	}

}