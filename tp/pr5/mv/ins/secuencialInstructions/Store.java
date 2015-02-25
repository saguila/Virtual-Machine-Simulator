package tp.pr5.mv.ins.secuencialInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;


public class Store extends Secuencial {

	public Store(){
		
	}
	
	public Store(Integer parameter){
		_parameter = parameter;
	}
	
	

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException, NegativeMemoryException {
		
		if(_parameter >= 0){
		 // Si hay operandos se hace.
			memoria.insertarCelda(_parameter, pila.getCima());
			pila.desapila();	
	}
		else{
			gestor.set_halt(true);
			throw new NegativeMemoryException(getInstructionName() + " posicion negativa:"+ _parameter +".");}
	
	}	
	
	public Instruction parse (String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("STORE")){
			i = new Store(Integer.parseInt(ins[1]));
		}
		
		return i;
	}

	@Override
	protected String getInstructionName() {
		return "STORE";
	}

}
