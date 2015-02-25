package tp.pr5.mv.gui.controllers;

import tp.pr5.mv.cpu.CPU;



public class BatchControler extends Controler{


public BatchControler(CPU cpu) {
		super(cpu);
	}

//Simplemente ejecuta el run de controller
//como lo que tengo en la practica 4 del modo batch
//no muestra nada en consola,la vista se encarga de eso
public void start(){
	run();
}

}
