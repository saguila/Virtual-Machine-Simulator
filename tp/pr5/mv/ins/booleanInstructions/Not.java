package tp.pr5.mv.ins.booleanInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;


public class Not extends Booleans{

//Solo se saca un elemento de la pila y no dos como en las otras operaciones.
	public boolean execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor) throws EmpyStackException{
		boolean EjecucionCorrecta = true;
		if(pila.numElem() > 0){
		int cima = pila.getCima();
		pila.desapila();
		if(cima == 0){
			pila.apila(1);
		}
		else if(cima == 1){
			pila.apila(0);
		}
		else{ // Si no es ni 0 ni 1,la ejecucion no es correcta y recuperamos nuestra pila.
			pila.apila(cima);
			EjecucionCorrecta = false;
		}
		}
		else{
			EjecucionCorrecta = false;
		}
		return EjecucionCorrecta;
	}
	@Override
	public Instruction parse(String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("NOT")){
			i = new Not();
		}
		return i;
	}
	protected Integer operacion(Integer operando1, Integer operando2) {
	return null;
	}
	
	@Override
	protected String getInstructionName(){
		return "NOT";
	}
}