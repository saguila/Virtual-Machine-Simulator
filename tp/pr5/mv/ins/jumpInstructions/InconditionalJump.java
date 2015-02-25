package tp.pr5.mv.ins.jumpInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class InconditionalJump extends Jump{

	Integer _param;
	
	public InconditionalJump(){
	
}

	public InconditionalJump(Integer parameter){
		_param = parameter;
}
	
	@Override
	protected String getInstructionName() {
		return "JUMP " + _param;
	}

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) {
	gestor.incrementPc(_param);
	}

	
	@Override
	public Instruction parse(String[] ins) {
		
			Instruction i = null;
			if(ins[0].equalsIgnoreCase("JUMP")){
				i = new InconditionalJump(Integer.parseInt(ins[1]));
			}
			return i;
		}
	

}
