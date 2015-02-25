package tp.pr5.mv.ins.arithmeticsInstructions;


import tp.pr5.mv.ins.Instruction;



public class Add extends Arithmetics {


protected Integer operacion(Integer operando1,Integer operando2) {
	return operando1 + operando2;
}

protected String getInstructionName(){
	return "ADD";
}


@Override
protected Instruction getObject() {
	return new Add();
}














}
