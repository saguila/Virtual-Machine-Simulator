package tp.pr5.mv.ins.jumpInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Bt extends Jump{
Integer _param;
	
	public Bt(){
	
}

	public Bt(Integer parameter){
		_param = parameter;
}
	
	@Override
	protected String getInstructionName() {
		return "BT " + _param;
	}

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException {
	
	Integer cima = pila.getCima();
	pila.desapila();
		if(cima != 0){
			gestor.incrementPc(_param);
			
		}
	
	}

	
	@Override
	public Instruction parse(String[] ins) {
		
			Instruction i = null;
			if(ins[0].equalsIgnoreCase("BT")){
				i = new Bt(Integer.parseInt(ins[1]));
			}
			return i;
		}
}
