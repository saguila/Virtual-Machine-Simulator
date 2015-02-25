package tp.pr5.mv.ins.unaryInstructions;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;


public class Neg implements Instruction{

	public void execute(OperandStack<Integer> pila,Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException{
		
		if(pila.numElem() > 0){
		int cima = pila.getCima();
		pila.desapila();
		pila.apila(cima * -1);
		}
		throw new EmpyStackException(this.toString() + " no hay elementos en la pila");
	}
	
	public String toString(){
		return "NEG";
	}
		

	@Override
	public Instruction parse(String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("NEG")){
			i = new Neg();
		}
		return i;
	}

	

}
