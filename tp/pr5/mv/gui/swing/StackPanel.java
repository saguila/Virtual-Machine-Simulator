package tp.pr5.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;














import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.cpu.CPUObserver;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.Observable;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.cpu.StackObserver;
import tp.pr5.mv.exceptions.EmpyStackException;
import tp.pr5.mv.gui.controllers.GUIControler;
import tp.pr5.mv.ins.Instruction;


// Se actualiza la pila cuando se recibe avisos onPop y onPush de la pila.
// No se borra todo el contenido de la pila ,solo se añade y se quita el primer elemento del model
// Opcional borrar el contenido de la pila cuando se recibe el aviso on stackReset.
// desactivar los botones push y pop cuando empieza el run y volverlos a activar despues.

@SuppressWarnings("serial")
public class StackPanel extends JPanel implements StackObserver<Integer>,CPUObserver{

	private GUIControler _guiCtrl;
	private JTextField _pila;
	private JList<Integer> _areaPila;
	private int numElem;
	private DefaultListModel<Integer> _model;
	
public StackPanel(GUIControler guiCtrl,Observable<StackObserver<Integer>> stack,Observable<CPUObserver> cpu) {
	    _guiCtrl = guiCtrl;
	    stack.addObserver(this);
	    cpu.addObserver(this);
		initGUI();
numElem = 0;
	}

	
	private void initGUI() {
		JPanel centerPanel = new JPanel (new BorderLayout());
		JPanel testPanel = new JPanel ();
		testPanel.setLayout(new BoxLayout(testPanel, BoxLayout.X_AXIS));
		JButton pushButton  = new JButton ("Push");	
		JButton popButton  = new JButton ("Pop");
		_pila = new JTextField();
		JLabel text = new JLabel("Valor");
		testPanel.add(text);
		testPanel.add(_pila);
		testPanel.add(pushButton);
		testPanel.add(popButton);
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Pila de Elementos"));
		_model = new DefaultListModel<Integer>();
		_areaPila = new JList<Integer>(_model);
		centerPanel.add(new JScrollPane(_areaPila), BorderLayout.CENTER);
		centerPanel.add(testPanel, BorderLayout.PAGE_END);
		this.add(centerPanel);
		this.setFont(new Font("Arial", Font.BOLD, 16));
		
		pushButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					_guiCtrl.push(Integer.parseInt(_pila.getText()));
					}catch(NumberFormatException e1){
					InternalError("Solo se aceptan numeros");
				}
			}
		});
		
		popButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
					try {
						_guiCtrl.pop();
					} catch (EmpyStackException e1) {
					}
			}
		});
		

	}
	
	public void InternalError(String message){ JOptionPane.showMessageDialog(this,message,"Error en el Panel Pila",0,null); }
	@Override
	public void onPush(int value) { _model.add(numElem,value); }
	@Override
	public void onPop() { _model.remove(numElem); }
	@Override
	public void onStackReset() {}
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
	public void onReset(ProgramMV program) {_model.removeAllElements();}
	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria,OperandStack<Integer> pila) {}
	
}
