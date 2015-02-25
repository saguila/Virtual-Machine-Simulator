package tp.pr5.mv.gui.controllers;

import java.io.IOException;

import tp.pr5.mv.command.CommandInterpreter;
import tp.pr5.mv.command.CommandParser;
import tp.pr5.mv.cpu.CPU;
import tp.pr5.mv.cpu.Constantes;
import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.HaltedCPUException;
import tp.pr5.mv.exceptions.NegativeMemoryException;

public class InteractiveControler extends Controler{


public InteractiveControler(CPU cpu) { super(cpu); }

//un bucle donde en cada iteracion pida el comando (STEP,RUN,PUSH,ect)
	//al usuario y el metodo que corresponde (de Controler)
	//Como lo que teneis en la practica 4 del modo interactivo
	//no muestra nada en consola la vista se encarga de esto

public void start(){ //
	//meter todo lo anterior aqui.
	String line;
	CommandInterpreter command;
	System.out.println("Introduce Commandos -/STEP/STEPN/RUN/QUIT/WRITE/PUSH/POP-");
	do{
		//leer y ejecutar comando
		System.out.print(Constantes.SALTO() + ">.-");
		try{
			 line = Constantes.leerConsola();
			 command = CommandParser.parseCommand(line); // recoge bien la instruccion.
			 if(command != null) command.executeCommand();
			 else System.out.print("Commando no valido");
			 
			}catch(EmpyStackException e){
				}catch(DivZeroException e){
				}catch(NegativeMemoryException e){
				} catch (IOException e) { 
				} catch (HaltedCPUException e) {
				}finally{
				}
		
}while(!CommandInterpreter.isQuit());
}
}