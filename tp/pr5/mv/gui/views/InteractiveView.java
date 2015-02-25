package tp.pr5.mv.gui.views;

import tp.pr5.mv.cpu.CPUObserver;
import tp.pr5.mv.cpu.Constantes;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.Observable;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.ins.Instruction;


//el parametro cpu tiene que tener el tipo Observable<CPUObserver>
//para asegurarnos que no hay acceso directo al cpu desde la vista.
public class InteractiveView implements CPUObserver{
	Observable<CPUObserver> _cpu;
	
	public InteractiveView(Observable<CPUObserver> cpu){	
		cpu.addObserver(this);
		_cpu = cpu;
}
//...
//Implementar los metodos CPUobserver para tener el efecto del modo
//interactivo

	@Override
	public void onStartInstrExecution(Instruction instr) {
		System.out.println("Comienza la ejecucion de  " + instr.toString());
	}
	
	@Override
	public void onEndInstrExecution(int pc,Memory<Integer> memoria,OperandStack<Integer> pila) {
		String line = "------------------------------------------------";
		System.out.println("PC actual :: " + pc +  Constantes.SALTO() + pila.toString() +  Constantes.SALTO() + memoria.toString() + Constantes.SALTO()  + line );
	}

	@Override
	public void onStartRun() {}

	@Override
	public void onEndRun() {}
	
	@Override
	public void onError(String msg) { System.err.print(msg); }

	@Override
	public void onHalt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(ProgramMV program) {
		// TODO Auto-generated method stub
		
	}

	

}
