package tp.pr5.mv.ins.secuencialInstructions;

import tp.pr5.mv.cpu.ExecuteManager;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.ins.Instruction;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

public class LoadInd implements Instruction{

	public LoadInd() {
	}

	@Override
	public String toString() {
		return "LOADIND";
	}

	@Override
	public Instruction parse(String[] ins) {
		Instruction i = null;
		if(ins[0].equalsIgnoreCase("LOADIND")){
			i = new LoadInd();
		}
		return i;
	}

	@Override
	public void execute(OperandStack<Integer> pila, Memory<Integer> memoria,
			ExecuteManager gestor, Instrategy in, Outstrategy out) throws EmpyStackException {
		
		int cima;
		if(pila.numElem() > 0){ 
			cima = pila.getCima();
			pila.desapila();
			if(memoria.compruebaPosicion(cima)){
				pila.apila((Integer) memoria.getCelda(memoria.damePosicion(cima)).getDato());
			}
			else{ //no se encuentra la posicion
				pila.apila(0);
			}
		}
		
	
	}

}
