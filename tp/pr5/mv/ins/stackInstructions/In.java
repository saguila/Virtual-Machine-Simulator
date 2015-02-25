package tp.pr5.mv.ins.stackInstructions;

import java.io.IOException;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class In extends StackInstructions {

	
@Override
public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws IOException{
	pila.apila((int)in.read());
}

@Override
protected String getInstructionName() {
	return "IN";
}

@Override
public Instruction getObject() {
	return new In();
}

}
