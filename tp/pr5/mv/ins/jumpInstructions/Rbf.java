package tp.pr5.mv.ins.jumpInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Rbf implements Instruction{
	
	Integer _parameter;
	
	public Rbf(){
	}
	
	public Rbf(Integer parameter){
	_parameter = parameter;
	}
	
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException {
	
		Integer cima = pila.getCima();
	pila.desapila();
		if(cima == 0){
			gestor.incrementPc(_parameter + gestor.currentPc());
		
			
		}
			
	}
	@Override
	public Instruction parse(String[] ins) {
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("RBF")){
			i = new Rbf(Integer.parseInt(ins[1]));
		}
		return i;
	}
	

	@Override
	public String toString() {
		return "RBF " + _parameter;
	}
}
