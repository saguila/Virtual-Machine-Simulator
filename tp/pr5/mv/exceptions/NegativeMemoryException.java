package tp.pr5.mv.exceptions;

import tp.pr5.mv.command.CommandInterpreter;
import tp.pr5.mv.cpu.Constantes;

@SuppressWarnings("serial")
public class NegativeMemoryException extends Exception{

	public NegativeMemoryException(String message) {
		super("Ha habido un error de la instruccion " + message + Constantes.SALTO());
		CommandInterpreter.setQuit();
	}
}
