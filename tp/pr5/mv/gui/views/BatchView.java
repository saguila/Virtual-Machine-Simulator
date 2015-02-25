package tp.pr5.mv.gui.views;


import tp.pr5.mv.cpu.CPUObserver;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.Observable;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.ins.Instruction;


public class BatchView implements CPUObserver{

public BatchView(Observable<CPUObserver> cpu) {
	cpu.addObserver(this);
}

//...
//Implementar los metodos de Cpuobserver para tener el efecto
//modo batch (como en la practica 4).

@Override
public void onStartInstrExecution(Instruction instr) {
	// no se mete nada no tiene que imprimir la instruccio
}

@Override
public void onStartRun() {
	// no se mete nada no tiene que imprimir el estado de la maquina.
}

@Override
public void onError(String msg) { System.err.print(msg);}

@Override
public void onHalt() {
	// TODO Auto-generated method stub
	
}

@Override
public void onReset(ProgramMV program) {
	// TODO Auto-generated method stub
	
}

@Override
public void onEndRun() {
	// TODO Auto-generated method stub
	
}



@Override
public void onEndInstrExecution(int pc, Memory<Integer> memoria,
		OperandStack<Integer> pila) {
	// TODO Auto-generated method stub
	
}
}
