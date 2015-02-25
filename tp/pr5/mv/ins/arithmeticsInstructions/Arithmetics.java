package tp.pr5.mv.ins.arithmeticsInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.*;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public abstract class Arithmetics implements Instruction {

	public Arithmetics() {

	}

	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,
			ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException, DivZeroException {
	
		if (pila.numElem() > 1){
			Integer cima = pila.getCima();
			pila.desapila();
			Integer subcima = pila.getCima();
			pila.desapila();
			Integer resultado = operacion(subcima, cima);
			if (resultado != null){ // Si la operacion da un resultado valido						
				pila.apila(resultado);
			} else{ // Si la operacion da null recuperamos nuestra pila.
				pila.apila(subcima);
				pila.apila(cima);
				throw new DivZeroException(this.getInstructionName() + " uno de los operandos es 0");
			}
		} 
		else{
			
			throw new EmpyStackException(this.getInstructionName() + " la pila contiene menos de dos elementos");
		}
		
	}

	public Instruction parse(String[] ins) {
		Instruction i = null;
		if (ins[0].equalsIgnoreCase(this.getInstructionName())) {
			i = getObject();
		}
		return i;
	}
	
	public String toString(){
	return this.getInstructionName();
	}
	
	protected abstract String getInstructionName();
	
	protected abstract Instruction getObject();

	protected abstract Integer operacion(Integer operando1, Integer operando2);

}
