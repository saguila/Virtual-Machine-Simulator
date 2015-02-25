package tp.pr5.mv.cpu;

import tp.pr5.mv.ins.Instruction;

/** Interfaz que incluye la definicion de los avisos y la informacion que vamos a pasar a los oyentes con cada aviso  */
public interface CPUObserver{
	
	
	// para avisar que ha empezado la ejecuci�n de una instrucci�n 
	//(al principio del m�todo step del CPU por ejemplo). Pasamos 
	//la instrucci�n actual porque en el modo interactive necesitamos 
	//escribir un mensaje que indica que instrucci�n vamos a ejecutar, etc. 
	public void onStartInstrExecution(Instruction instr);
	
	
	// para avisar que ha terminado la ejecuci�n de una instrucci�n 
	//(al final del m�todo step por ejemplo). Pasamos el valor del PC 
	//porque lo necesitamos para actualizar las vistas. Se puede pasar 
	//m�s informaci�n como la Pila y la Memoria para escribirlas, etc.
	void onEndInstrExecution(int pc, Memory<Integer> memoria,OperandStack<Integer> pila);
	
	
	// para avisar que ha empezado la ejecuci�n de m�todo run del CPU. 
	//No necesitamos pasar par�metros en este caso -- se usa para desactivar
	//lo botones en la vista cuando empieza la ejecuci�n, etc. 
	public void onStartRun();
	
	
	//para avisar que ha terminado la ejecuci�n del m�todo run del CPU. 
	//Se puede pasar m�s par�metros (en la parte opcional) para indicar 
	//si la ejecuci�n ha terminado o la hemos parado -- ver la parte opcional.
	//public void onEndRun(...)
	public void onEndRun();
	
	//para avisar a los oyentes que ha ocurrido alg�n error durante 
	//la ejecuci�n de cualquier m�todo del CPU. El par�metro msg es 
	//el mensaje adecuado (normalmente obtenemos el mensaje de la excepci�n
	//que corresponde, usando getMessage() por ejemplo). 
	 public void onError(String msg);
	 
	 
	 // para avisar que la ejecuci�n del programa ha terminado --
	 //se puede avisar al final del m�todo step por ejemplo.
	 public void onHalt();

	 
	 // para avisar a los oyentes cuando cargamos un programa nuevo
	 //(en loadProgram o reset del CPU por ejemplo) No es obligatorio 
	 //usar onReset, pero es muy recomendable porque as� pod�is a�adir
	 //por ejemplo la posibilidad de cambiar el programa en swing,
	 //o restaurar la maquina virtual, etc.
	 public void onReset(ProgramMV program); // OPCIONAL


	
}
