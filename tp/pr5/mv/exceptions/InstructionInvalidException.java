package tp.pr5.mv.exceptions;

import tp.pr5.mv.command.CommandInterpreter;
import tp.pr5.mv.cpu.Constantes;

@SuppressWarnings("serial")
public class InstructionInvalidException extends Exception{

	public InstructionInvalidException(String message) {
		super("Instruccion no valida: " + message + Constantes.SALTO());
		CommandInterpreter.setQuit();
	}
}