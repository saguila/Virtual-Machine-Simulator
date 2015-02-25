package tp.pr5.mv.gui.swing;







import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp.pr5.mv.cpu.CPUObserver;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.MemoryObserver;
import tp.pr5.mv.cpu.Observable;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.cpu.StackObserver;
import tp.pr5.mv.ins.Instruction;

@SuppressWarnings("serial")
//cada cosa que recibe addObserver.
public class StatusBarPanel extends JPanel implements StackObserver<Integer>,MemoryObserver<Integer>,CPUObserver{
	
	JCheckBox mem;
	JCheckBox pila;
	JTextField nIns;
	JLabel etiqIns;
	int numInstr;
	
	public StatusBarPanel(Observable<StackObserver<Integer>> stack,Observable<MemoryObserver<Integer>> memory,Observable<CPUObserver> cpu){
		stack.addObserver(this);
		memory.addObserver(this);
		cpu.addObserver(this);
		numInstr = 0;
		initGUI();
	}
	// Implementar lo metodos de Cpuobser
	//actualizar la informacion del statusBar como indica el enunciado

	private void initGUI(){
		mem = new JCheckBox("Memoria modificada");
		pila = new JCheckBox("Pila modificada");
		nIns = new JTextField("0");
		nIns.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		etiqIns = new JLabel("Num. Instrucciones ejecutadas:");
		this.add(etiqIns);
		this.add(nIns);
		this.add(mem);
		this.add(pila);

	}

	
	@Override
	public void onStartInstrExecution(Instruction instr) {
		pila.setSelected(false);
		mem.setSelected(false);
	}

	
	@Override
	public void onStartRun() {}

	@Override
	public void onEndRun() {}

	@Override
	public void onError(String msg) {}
	

	@Override
	public void onHalt() {}

	@Override
	public void onReset(ProgramMV program) {
		pila.setSelected(false);
		mem.setSelected(false);
		numInstr = 0;
	}

	@Override
	public void onPush(int value) { pila.setSelected(true); }

	@Override
	public void onPop() { pila.setSelected(true); }

	@Override
	public void onStackReset() {}

	@Override
	public void onWrite(int index, Integer value) { mem.setSelected(true);}

	@Override
	public void onMemReset() { mem.setSelected(true); }

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria,
			OperandStack<Integer> pila) {
		numInstr++;
		nIns.setText(Integer.toString(numInstr));
		}
	
}
