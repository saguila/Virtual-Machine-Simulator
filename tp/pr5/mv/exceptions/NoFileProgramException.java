package tp.pr5.mv.exceptions;

import tp.pr5.mv.cpu.Constantes;

@SuppressWarnings("serial")
public class NoFileProgramException extends Exception{

	public NoFileProgramException(String message) {
		super(" No se puede continuar,falta el archivo que contiene el programa, " + message + Constantes.SALTO());
	}

	
	


}
