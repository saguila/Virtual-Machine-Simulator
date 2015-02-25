package tp.pr5.mv.exceptions;

import tp.pr5.mv.cpu.Constantes;

@SuppressWarnings("serial")
public class EmpyStackException extends Exception{

	public EmpyStackException(String message) {
		super("Ha habido un error de la instruccion " + message + Constantes.SALTO());
	}

	
	
}
