package tp.pr5.mv.ins.arithmeticsInstructions;

import tp.pr5.mv.ins.Instruction;

public class Sub extends Arithmetics{
	
	@Override
	protected Integer operacion(Integer operando1, Integer operando2) {
		return operando1 - operando2;
	}

	@Override
	protected String getInstructionName(){
		return "SUB";
	}

	@Override
	protected Instruction getObject() {
		// TODO Auto-generated method stub
		return new Sub();
	}
	


}
