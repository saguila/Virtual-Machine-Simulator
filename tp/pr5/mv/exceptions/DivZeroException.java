package tp.pr5.mv.exceptions;

import tp.pr5.mv.cpu.Constantes;

@SuppressWarnings("serial")
public class DivZeroException extends Exception{

	public DivZeroException(String message) {
		super("Ha habido un error de la instruccion " + message + Constantes.SALTO());
	}
}
