package tp.pr5.mv.ins;

import java.io.IOException;

import tp.pr5.mv.cpu.*;
import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.strategy.*;

public interface Instruction{
	
	public abstract String toString();
	public abstract void execute(OperandStack<Integer> pila,Memory<Integer> memoria,ExecuteManager gestor,Instrategy in,Outstrategy out) throws EmpyStackException, IOException, DivZeroException, NegativeMemoryException;
	public abstract Instruction parse(String [] ins);
	// intentar ponerlo protegido
	
}
