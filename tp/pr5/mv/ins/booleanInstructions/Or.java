package tp.pr5.mv.ins.booleanInstructions;

import tp.pr5.mv.ins.Instruction;

public class Or extends Booleans{

	@Override
	protected Integer operacion(Integer operando1, Integer operando2) {
		if(operando1 == 0 && operando2 == 0){ // Si uno los dos son 0 devolvemos 0
			return 0;
		}
		else {
			return 1;
	}
	}
	
	@Override
	public Instruction parse(String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("OR")){
			i = new Or();
		}
		return i;
	}
	
	@Override
	protected String getInstructionName(){
		return "OR";
	}
}