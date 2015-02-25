package tp.pr5.mv;

import tp.pr5.mv.gui.controllers.BatchControler;
import tp.pr5.mv.gui.controllers.GUIControler;
import tp.pr5.mv.gui.controllers.InteractiveControler;







import tp.pr5.mv.gui.views.BatchView;
import tp.pr5.mv.gui.views.InteractiveView;
import tp.pr5.mv.gui.views.SwingView;

import java.io.IOException;

import tp.pr5.mv.args.*;
import tp.pr5.mv.command.CommandInterpreter;
import tp.pr5.mv.command.CommandParser;
import tp.pr5.mv.command.Run;
import tp.pr5.mv.cpu.CPU;
import tp.pr5.mv.cpu.Constantes;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.exceptions.CommandInvalidException;
import tp.pr5.mv.exceptions.DivZeroException;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.exceptions.HaltedCPUException;
import tp.pr5.mv.exceptions.InstructionInvalidException;
import tp.pr5.mv.exceptions.MVError;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.exceptions.NoFileProgramException;
import tp.pr5.mv.strategy.Consoleinstrategy;
import tp.pr5.mv.strategy.Consoleoutstrategy;
import tp.pr5.mv.strategy.Fileinstrategy;
import tp.pr5.mv.strategy.Fileoutstrategy;
import tp.pr5.mv.strategy.Instrategy;
import tp.pr5.mv.strategy.Nullinstrategy;
import tp.pr5.mv.strategy.Nulloutstrategy;
import tp.pr5.mv.strategy.Outstrategy;

@SuppressWarnings("unused")
public class TPMV {
private static final int _BATCH_MODE = 0;
private static final int _INTER_MODE = 1;
private static final int _WINDOW_MODE = 2;
private static final int _NULL_STREAM = 3;
private static final int _STD_STREAM = 4;
private static final int _FILE_STREAM = 5;


private static CPU _cpu;

private static int _executionMode = _INTER_MODE;

private static int _inStreamMode = _NULL_STREAM;
private static int _outStreamMode = _NULL_STREAM;
private static String _inStreamFileName = null;
private static String _outStreamFileName = null;
private static String _programFileName = null;

public static void main(String[] args){
	startMV(args);
}


public static void startMV(String[] args){
	_cpu = new CPU();
	try{
		Cli.parseOption(args);
		switch (_executionMode){
		case _INTER_MODE:
			interactiveMode();break;
		case _BATCH_MODE:
			batchMode();break;
		case _WINDOW_MODE:
			windowMode();break;
		}
	}catch(Exception e){
		System.err.println("Error:" + e.getMessage());
		System.exit(1);
	}
	
}

private static void interactiveMode() throws MVError, InstructionInvalidException, IOException, HaltedCPUException, EmpyStackException, DivZeroException, NegativeMemoryException{
	//Crear y abrir los inStream y outStream y pasarlos al cpu.
	String line;
	Instrategy in = new Nullinstrategy();
	Outstrategy out = new Nulloutstrategy();
	
	if(_inStreamFileName != null){
	in = new Fileinstrategy(_inStreamFileName);
	_inStreamMode = _FILE_STREAM;
	}
	
	if(_outStreamFileName != null){
		out = new Fileoutstrategy(_outStreamFileName);
		_outStreamMode = _FILE_STREAM;
	}
	
		in.open();
		out.open();
	

	_cpu.setInStream(in);
	_cpu.setOutStream(out);
	
	//leer el programa
	ProgramMV program = _programFileName == null ?
			ProgramMV.read_program():
			ProgramMV.read_program(_programFileName);
_cpu.loadProgram(program);
System.out.println("Se ha cargado con exito el siguiente programa:");
System.out.println("----------------------------------------------");
System.out.println(program);
CommandInterpreter.configureCommandInterpreter(_cpu);

//Crear el controlador y la vista
InteractiveControler ctrl = new InteractiveControler(_cpu);
InteractiveView view = new InteractiveView(_cpu);
ctrl.start();
Constantes.cerrarLector();
	_cpu.getOutStream().close();
	_cpu.getInStream().close();


}

private static void batchMode()throws MVError, IOException, NoFileProgramException, HaltedCPUException, InstructionInvalidException{
	if(_programFileName == null) throw new NoFileProgramException("en el modo batch es obligatorio.");
	Instrategy in = new Consoleinstrategy();
	_inStreamMode = _STD_STREAM;
	Outstrategy out = new Consoleoutstrategy();
	_outStreamMode = _STD_STREAM;
	
	if(_inStreamFileName != null){
	in = new Fileinstrategy(_inStreamFileName);
	_inStreamMode = _FILE_STREAM;
	}
	
	if(_outStreamFileName != null){
		out = new Fileoutstrategy(_outStreamFileName);
		_outStreamMode = _FILE_STREAM;
	}
	
	
		in.open();
		out.open();
	
	_cpu.setInStream(in);
	_cpu.setOutStream(out);
	
	//leer el programa
	ProgramMV program = ProgramMV.read_program(_programFileName);
	_cpu.loadProgram(program);
//Crear el controlador y la vista
	BatchControler ctrl = new BatchControler(_cpu);
	BatchView view = new BatchView(_cpu);
	ctrl.start();
	_cpu.getInStream().close();
	_cpu.getOutStream().close();
			
}


private static void  windowMode() throws IOException, MVError, InstructionInvalidException, NoFileProgramException, EmpyStackException{
	// crear y abrir los ficheros inStream y outStream y pasarlos al CPU
	// son ficheros o nula ,el MainWindow ya los enlaza con el GUI.
	//···
	if(_programFileName == null) throw new NoFileProgramException("en el modo grafico es obligatorio.");
	Instrategy in = new Nullinstrategy();
	Outstrategy out = new Nulloutstrategy();
	
	if(_inStreamFileName != null){
	in = new Fileinstrategy(_inStreamFileName);
	_inStreamMode = _FILE_STREAM;
	}
	
	if(_outStreamFileName != null){
		out = new Fileoutstrategy(_outStreamFileName);
		_outStreamMode = _FILE_STREAM;
	}
	
		in.open();
		out.open();
	
	_cpu.setInStream(in);
	_cpu.setOutStream(out);
//leer el programa y cargarlo en la cpu
	ProgramMV program = ProgramMV.read_program(_programFileName);
	_cpu.loadProgram(program);
	//Crear el contenedor y la vista
GUIControler ctrl = new GUIControler(_cpu);
SwingView view = new SwingView(ctrl,_cpu,_cpu.getOperandStack(),_cpu.getMemory());
ctrl.start();//en este caso start no hace nada,swing se encarga
}



public static void set_inStreamFileName(String inStreamFileName) {
	TPMV._inStreamFileName = inStreamFileName;
}

public static void set_outStreamFileName(String outStreamFileName) {
	TPMV._outStreamFileName = outStreamFileName;
}

public static void set_programFileName(String programFileName) {
	TPMV._programFileName = programFileName;
}

public static void set_executionMode(int executionMode) {
	TPMV._executionMode = executionMode;
}

public static void set_inStreamMode(int inStreamMode){
	TPMV._inStreamMode = inStreamMode;
}

public static void set_outStreamMode(int outStreamMode){
	TPMV._outStreamMode = outStreamMode;
}

}