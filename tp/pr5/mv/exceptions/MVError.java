package tp.pr5.mv.exceptions;

import tp.pr5.mv.command.CommandInterpreter;
import tp.pr5.mv.cpu.Constantes;



@SuppressWarnings("serial")
public class MVError extends Exception {

	public MVError(String message) {
		super("Instruccion no valida: " + message + Constantes.SALTO());
		CommandInterpreter.setQuit();
	}
}