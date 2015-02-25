package tp.pr5.mv.ins.arithmeticsInstructions;

import tp.pr5.mv.ins.Instruction;


public class Mul extends Arithmetics{


	
	@Override
	protected Integer operacion(Integer operando1, Integer operando2) {
		return operando1 * operando2;
	}
	
	protected String getInstructionName(){
		return "MUL";
	}

	@Override
	protected Instruction getObject() {
		return new Mul();
	}
	

	
	
}
