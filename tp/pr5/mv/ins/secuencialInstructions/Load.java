package tp.pr5.mv.ins.secuencialInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Load extends Secuencial {

	public Load(){
	}
	public Load(Integer parameter){
		_parameter = parameter;
	}
	
	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws NegativeMemoryException{
		
if(_parameter >= 0){
		if(memoria.compruebaPosicion(_parameter)){
			pila.apila(memoria.getCelda(memoria.damePosicion(_parameter)).getDato());
		}
		else{ //no se encuentra la posicion
			pila.apila(0);
			}
		
	}else{
		throw new NegativeMemoryException(getInstructionName() + " posicion negativa:"+ _parameter +".");
	}
	
	}
	
	public Instruction parse (String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("LOAD")){
			i = new Load(Integer.parseInt(ins[1]));
		}
		return i;
	}
	
	
	@Override
	protected String getInstructionName() {
		return "LOAD";
	}

}
