package tp.pr5.mv.cpu;
import java.io.FileNotFoundException;

import tp.pr5.mv.exceptions.InstructionInvalidException;
import tp.pr5.mv.ins.*;
import tp.pr5.mv.FileRead;

/** Clase que representa a un programa */
public class ProgramMV {

	private Instruction [] _program;
	private int _counter;
	
	public ProgramMV(Instruction [] program){
		_program = program;
		_counter = 0;
	}

	public ProgramMV (){
		_program = new Instruction[100];
		_counter = 0;
	}
	
	public static ProgramMV read_program(){
		ProgramMV program = new ProgramMV();
		String line;
		 System.out.println("Introduce la secuencia de instrucciones del programa");
		 do
		 {
			System.out.print(">- ");
			 line =  Constantes.leerConsola();
			 
			 if (!line.equalsIgnoreCase("end")){
				 Instruction ins = InstructionParser.parse(line);
				 if (ins != null) program.addInstruction(ins);
				 else System.out.println("Error: Instruccion incorrecta");
				 }
		 }while(!line.equalsIgnoreCase("END")); // Si es distinto de final  seguimos cargando el programa
		 System.out.println("Se ha introducido el siguiente programa :");
		 System.out.println(program);
		return  program;
	}
	
	public static ProgramMV read_program(String programFileName) throws InstructionInvalidException{
		ProgramMV program = new ProgramMV();
		Instruction ins = null;
		try{
		FileRead archivo = new FileRead(programFileName);
		String salida,entrada;
		String [] tokSalida;
	
		do{
		salida = "";
		entrada = archivo.readLine();
		if(!entrada.equals("")){
		tokSalida = entrada.split(" ");
		for (int i = 0 ; i < tokSalida.length && !tokSalida[i].equals(";");i++){
			if(i > 0)
				salida = salida + " ";
			salida = salida + tokSalida[i];
		}
		
		if(salida != "" &&  archivo.status()){
			ins = InstructionParser.parse(salida);
			if(ins != null){
	program.addInstruction(ins);
			}
			else throw new InstructionInvalidException(salida);
		}
		}
		}while(archivo.status());
		}catch(FileNotFoundException e){
		System.err.print(e.getMessage());
		}
		return program;	
	}
	
	public Instruction dameInst(int i){
		return _program[i];
	}
	
	private void incrementSize(){
		Instruction [] auxiliar;
		auxiliar = new Instruction[100 + _program.length];
		for(int i = 0 ; i < _program.length;i++){
			auxiliar[i] = _program[i];
			_program = auxiliar;
		}
		
	}
	public void addInstruction(Instruction instruccion)
	{
		if(_counter == _program.length){
			incrementSize();
		}
		_program[_counter] = instruccion;
		_counter++;
	}
	
	
	public int programSize(){
		return _counter;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < _counter; i++){
			result.append((i + " : " + _program[i].toString())+ Constantes.SALTO());
		}
		return result.toString();
	}
	

}
