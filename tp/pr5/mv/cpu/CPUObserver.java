package tp.pr5.mv.cpu;

import tp.pr5.mv.ins.Instruction;

/** Interfaz que incluye la definicion de los avisos y la informacion que vamos a pasar a los oyentes con cada aviso  */
public interface CPUObserver{
	
	
	// para avisar que ha empezado la ejecución de una instrucción 
	//(al principio del método step del CPU por ejemplo). Pasamos 
	//la instrucción actual porque en el modo interactive necesitamos 
	//escribir un mensaje que indica que instrucción vamos a ejecutar, etc. 
	public void onStartInstrExecution(Instruction instr);
	
	
	// para avisar que ha terminado la ejecución de una instrucción 
	//(al final del método step por ejemplo). Pasamos el valor del PC 
	//porque lo necesitamos para actualizar las vistas. Se puede pasar 
	//más información como la Pila y la Memoria para escribirlas, etc.
	void onEndInstrExecution(int pc, Memory<Integer> memoria,OperandStack<Integer> pila);
	
	
	// para avisar que ha empezado la ejecución de método run del CPU. 
	//No necesitamos pasar parámetros en este caso -- se usa para desactivar
	//lo botones en la vista cuando empieza la ejecución, etc. 
	public void onStartRun();
	
	
	//para avisar que ha terminado la ejecución del método run del CPU. 
	//Se puede pasar más parámetros (en la parte opcional) para indicar 
	//si la ejecución ha terminado o la hemos parado -- ver la parte opcional.
	//public void onEndRun(...)
	public void onEndRun();
	
	//para avisar a los oyentes que ha ocurrido algún error durante 
	//la ejecución de cualquier método del CPU. El parámetro msg es 
	//el mensaje adecuado (normalmente obtenemos el mensaje de la excepción
	//que corresponde, usando getMessage() por ejemplo). 
	 public void onError(String msg);
	 
	 
	 // para avisar que la ejecución del programa ha terminado --
	 //se puede avisar al final del método step por ejemplo.
	 public void onHalt();

	 
	 // para avisar a los oyentes cuando cargamos un programa nuevo
	 //(en loadProgram o reset del CPU por ejemplo) No es obligatorio 
	 //usar onReset, pero es muy recomendable porque así podéis añadir
	 //por ejemplo la posibilidad de cambiar el programa en swing,
	 //o restaurar la maquina virtual, etc.
	 public void onReset(ProgramMV program); // OPCIONAL


	
}
