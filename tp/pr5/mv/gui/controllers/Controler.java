package tp.pr5.mv.gui.controllers;

import java.io.IOException;

import tp.pr5.mv.cpu.CPU;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.MVError;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Outstrategy;

//Los métodos del controlador no lanzan ninguna excepción 
//hacia la vista, tienen que capturar todas las excepciones
//lanzadas por el CPU y simplemente no hacer nada. La vista ya
//recibe avisos del CPU si ocurre algún error.  El Controlador 
//no puede tener acceso a la vista  Tenéis que definir una jerarquía
//de controladores

public abstract class Controler {
private CPU _cpu;

public Controler(CPU cpu){
	_cpu = cpu;
}

public void reset(){
	_cpu.reset();
}

public void step(){
	try{
		_cpu.step();
	}catch(Exception e){
		
	}
}

/* Metodo que ejecuta el run de la cpu. */
public void run(){ try{ _cpu.run(); }catch(Exception e){} }

/* Metodo que ejecuta el pop de la cpu. */
public void pop() throws EmpyStackException{ _cpu.pop(); }

/* Metodo que ejecuta el push de la cpu.*/
public void push(int v){ _cpu.push(v); }

/* Metodo que el setMem de la cpu. */
public void memorySet(int i,int v) throws NegativeMemoryException{ _cpu.setMem(i,v); }

/* Metodo que devuelve el programa actual. */
public ProgramMV getProgram(){ return _cpu.getProgram(); }

/* Metodo que cambia el inStream. */
public void setInStream(Instrategy in) throws MVError{ _cpu.setInStream(in); }

/* Metodo que devuelve el inStream actual */
public Instrategy getInStream(){ return _cpu.getInStream(); }

/* Metodo que  cambia el OutStream. */
public void setOutStream(Outstrategy out) throws MVError{ _cpu.setOutStream(out);}

/* Metodo que devuelve el OutStream actual. */
public Outstrategy getOutStream(){ return _cpu.getOutStream(); }

/* Metodo que ejecuta el pause de la cpu. */
public void pause(){ _cpu.pause(); }

public void loadProgram(ProgramMV program) { _cpu.loadProgram(program); }

public abstract void start();

public void quit() throws IOException{
this.getOutStream().close();
this.getInStream().close();
System.exit(0);
}

}
