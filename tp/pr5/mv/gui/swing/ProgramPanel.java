package tp.pr5.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.cpu.CPUObserver;
import tp.pr5.mv.cpu.Constantes;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.Observable;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.gui.controllers.GUIControler;
import tp.pr5.mv.ins.Instruction;

@SuppressWarnings("serial")
public class ProgramPanel extends JPanel implements CPUObserver{

	private GUIControler _guiCtrl;
	private JTextArea _programTextArea;
	private ProgramMV _program;
	private int _pc;
	
	public ProgramPanel(GUIControler guiCtrl,Observable<CPUObserver> cpu) {
		_guiCtrl = guiCtrl;
		cpu.addObserver(this);
		initGUI();
	}

	private void initGUI(){ 
		_program = _guiCtrl.getProgram();
		_pc = 0;
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Programa"));
		_programTextArea = new JTextArea(20,15);
		_programTextArea.setFont(new Font("Arial", Font.BOLD, 12));
		_programTextArea.setEditable(false);
		this.add(new JScrollPane(_programTextArea));
		showProgram();
	}
	
	/* como el updateView en la practica 4,usa los atributos pc y program*/
	private void showProgram() {
		//actualiza el programa modificando los atributos pc y program y llamando
		//a show program
		String t = "";
		for (int i = 0; i < _program.programSize(); i++){
			if (i == _pc) t += "* " + i + " :" + _program.dameInst(i).toString() + Constantes.SALTO();
			else t += "  " + i + " :" + _program.dameInst(i).toString() + Constantes.SALTO();
		}
		_programTextArea.setText(t);
	}

	@Override
	public void onStartInstrExecution(Instruction instr) {}

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
	_program = program;
	_pc = 0;
	showProgram();
	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria,
			OperandStack<Integer> pila) {
		this.showProgram();
		_pc = pc;
		}
}