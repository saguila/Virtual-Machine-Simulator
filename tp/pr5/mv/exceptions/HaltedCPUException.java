package tp.pr5.mv.exceptions;

import tp.pr5.mv.cpu.Constantes;

@SuppressWarnings("serial")
public class HaltedCPUException extends Exception{
public HaltedCPUException() { super(" La maquina ya ha terminado la ejecucion " + Constantes.SALTO());}
}