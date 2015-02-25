package tp.pr5.mv.ins.booleanInstructions;

import tp.pr5.mv.ins.Instruction;

public class And extends Booleans{

	@Override
	protected Integer operacion(Integer operando1, Integer operando2) {
		if(operando1 == 0 || operando2 == 0){
			return 0;
		}
		else {
			return 1;
	}
	}
	

	protected String getInstructionName(){
		return "AND";
	}

	@Override
	public Instruction parse(String [] ins){
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("AND")){
			i = new And();
		}
		return i;
	}
}
