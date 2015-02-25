package tp.pr5.mv.cpu;

import java.io.IOException;
import java.util.ArrayList;

import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.HaltedCPUException;
import tp.pr5.mv.exceptions.MVError;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.ins.*;
import tp.pr5.mv.strategy.*;

/**
 * Clase que implementa una CPU y sus componentes su memoria,su pila,su conjunto de instrucciones y comportamientos.
 * 
 * @author Sebastian Aguila Grupo 7.
 * 
 */

public class CPU implements Observable<CPUObserver>{
private ArrayList<CPUObserver> _observers;
private OperandStack<Integer> _memoriaDinamica;
private Memory<Integer> _memoria;
private ProgramMV _programa;
private ExecuteManager _gestor;
private Instrategy _in;
private Outstrategy _out;

/** Constructor de la clase CPU instancia el estado */
public CPU(){
_memoriaDinamica = new OperandStack<Integer>();
_observers = new ArrayList<CPUObserver>();
_memoria = new Memory<Integer>();
_gestor = new ExecuteManager();
}



/** Metodo que ejecuta una instruccion del programa contenido en la cpu */
public void step() throws EmpyStackException, IOException, DivZeroException, NegativeMemoryException, HaltedCPUException{
	try{
		if(isHalted())throw new HaltedCPUException();
		int i = _gestor.currentPc();		
		Instruction instr = _programa.dameInst(i);

		for(CPUObserver o: _observers) o.onStartInstrExecution(instr);
		instr.execute(_memoriaDinamica, _memoria, _gestor, _in, _out); //suponiendo que instr es la instruccion a ejecutar
		_gestor.incrementPc();
		for(CPUObserver o: _observers) o.onEndInstrExecution(_gestor.currentPc(),_memoria,_memoriaDinamica);
	}catch(Exception e){
		for(CPUObserver o : _observers) o.onError(e.getMessage());  //avisar a los oyente de que ha ocurrido un error.
		throw  e; // lanzar una excepcion otra vez
	}
}

/** Metodo que ejecuta n instrucciones */
public void stepn(int n) throws EmpyStackException, IOException, DivZeroException, NegativeMemoryException, HaltedCPUException{
	for (int i = 0; i < n | isHalted() ;i ++) step();
}

/** Metodo que ejecuta todas las instrucciones o hasta que ocurra un evento */
public void run() throws EmpyStackException, IOException, DivZeroException, NegativeMemoryException, HaltedCPUException{
	
	try {
			if(isHalted())throw new HaltedCPUException();
			else while(!isHalted()) step();
		} catch (HaltedCPUException e) {
		for(CPUObserver o : _observers) o.onError(e.getMessage());  //avisar a los oyente de que ha ocurrido un error.
		throw e;
		}
		finally {for( CPUObserver o: _observers) o.onEndRun(); } 	//avisar que la ejecucion run ha terminado

	
}

//OPCIONAL
public void pause(){
	//parar la ejecucion del run -- ver ejemplos threads,ect.
}


/** Metodo que recibe como argumento un programa y lo carga en la CPU */
public void loadProgram(ProgramMV program){ _programa = program; }

/** Metodo que comprueba que la ejecucion del programa acabo */
public boolean isHalted(){ return (_gestor.currentPc() < 0 || _gestor.currentPc() >= _programa.programSize()); }

/** Metodo que devuelve a un estado inicial los elementos de nuestra CPU */
public void reset(){
	_gestor.reset(); // reseteamos el gestor.
	_memoriaDinamica.reset(); // reseteamos la pila.
	_memoria.Reset(); // reseteamos la memoria.
	for( CPUObserver o: _observers) o.onReset(_programa); // avisamos a los oyentes de que se hizo reset.

}

/** Metodo que saca un elemento de la pila de la CPU */
public void pop() throws EmpyStackException{//puede devolver int en lugar de void
	//quita un elemento de la pola puede devolver el valor si es necesario
	//si la pila esta vacia avisa a los oyentes con un mensaje de erro
	// y lanza una excepcion
	
	try {
		_memoriaDinamica.desapila();
	
	} catch (EmpyStackException e) {
		for(CPUObserver o : _observers){ o.onError(e.getMessage()); } //avisar a los oyente de que ha ocurrido un error.
		throw  e; // lanzar una excepcion otra vez
	}
}

/** Metodo que recibe un entero y lo añade a la pila de la CPU */
public void push(int v){
	//añade v a la pila
_memoriaDinamica.apila(v);
}

/** Metodo que recibe una posicion y un valor e ingresa los datos en la memoria de la CPU */
public void setMem(int index,int value) throws NegativeMemoryException{
	
	try {
		_memoria.insertarCelda(index, value);
	} catch (NegativeMemoryException e) {
		for(CPUObserver o : _observers){ o.onError(e.getMessage()); } //avisar a los oyente de que ha ocurrido un error.
		throw  e; // lanzar una excepcion otra vez
	}
	
	//cambia el valor de la posicion index en la memoria a valor
}

/*Metodo que devuelve la pila*/
public OperandStack<Integer> getOperandStack(){ return _memoriaDinamica;}

public Memory<Integer> getMemory(){ return _memoria; }

public ProgramMV getProgram() { return _programa; }

public void setInStream(Instrategy s) throws MVError {
	if(s == null) throw new MVError("Cannot set inStream to null");
	else _in = s;
}

public void setOutStream(Outstrategy s) throws MVError{
	if (s == null) throw new MVError("Cannot set inStream to null");
	else _out = s;
}

public Instrategy getInStream(){ return _in; }

public Outstrategy getOutStream(){ return _out; }


/** Metodo toString de la Clase CPU,muestra informacion de la instruccion y su ejecucion,la memoria y la pila */
public String toString(){
	return  "El estado de la maquina tras ejecutar la instruccion: " + Constantes.SALTO() + _memoria.toString() + Constantes.SALTO() + _memoriaDinamica.toString();
}


@Override
public void addObserver(CPUObserver o) { _observers.add(o); }

@Override
public void removeObserver(CPUObserver o) { _observers.remove(o); }


}