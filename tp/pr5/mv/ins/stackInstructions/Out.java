package tp.pr5.mv.ins.stackInstructions;

import java.io.IOException;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class Out extends StackInstructions {

	
@Override
public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws IOException, EmpyStackException{
	
	if(pila.numElem() > 0){
	out.write(pila.getCima());
	pila.desapila();
	}
	
}

@Override
protected String getInstructionName() {
	return "OUT";
}

@Override
public Instruction getObject() {
	return new Out();
}

}