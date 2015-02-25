package tp.pr5.mv.exceptions;

import tp.pr5.mv.cpu.Constantes;
@SuppressWarnings("serial")
public class CommandInvalidException extends Exception{

	public CommandInvalidException() {
		super("Commando no valido" + Constantes.SALTO());
	}
}
