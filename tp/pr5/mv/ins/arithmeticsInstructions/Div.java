package tp.pr5.mv.ins.arithmeticsInstructions;

import tp.pr5.mv.ins.Instruction;


public class Div extends Arithmetics{
 
	
	
	@Override
	protected Integer operacion(Integer operando1, Integer operando2){
		// Si el resto es 0 y ninguno de los elementos es 0 devolvemos la division.
		if(operando2 != 0){ 
		return operando1 / operando2;
	}
	else{
		return null;
	}
	}

	protected String getInstructionName(){
		return "DIV";
	}


	@Override
	protected Instruction getObject() {
		return new Div();
	}
	



	



	
	
	
}
