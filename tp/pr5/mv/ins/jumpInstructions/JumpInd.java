package tp.pr5.mv.ins.jumpInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class JumpInd extends Jump{

	Integer _param;
	
	public JumpInd(){
	
}

	public JumpInd(Integer parameter){
		_param = parameter;
}
	
	@Override
	protected String getInstructionName() {
		return "JUMPIND " + _param;
	}

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException {
	
		gestor.incrementPc(pila.getCima());
		pila.desapila();
	
	
	}

	
	@Override
	public Instruction parse(String[] ins) {
		
			Instruction i = null;
			if(ins[0].equalsIgnoreCase("JUMPIND")){
				i = new InconditionalJump(Integer.parseInt(ins[1]));
			}
			return i;
		}
	

}