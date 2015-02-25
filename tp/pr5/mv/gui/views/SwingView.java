package tp.pr5.mv.gui.views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import tp.pr5.mv.cpu.CPUObserver;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.MemoryObserver;
import tp.pr5.mv.cpu.Observable;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.cpu.StackObserver;
import tp.pr5.mv.gui.controllers.GUIControler;
import tp.pr5.mv.gui.swing.InputPanel;
import tp.pr5.mv.gui.swing.MemoryPanel;
import tp.pr5.mv.gui.swing.MenuBarPanel;
import tp.pr5.mv.gui.swing.OutputPanel;
import tp.pr5.mv.gui.swing.ProgramPanel;
import tp.pr5.mv.gui.swing.StackPanel;
import tp.pr5.mv.gui.swing.StatusBarPanel;
import tp.pr5.mv.gui.swing.ToolBarPanel;
import tp.pr5.mv.ins.Instruction;

@SuppressWarnings("serial")
public class SwingView extends JFrame implements CPUObserver{
	
	private GUIControler ctrl;
	private Observable<CPUObserver> cpu;
	private Observable<StackObserver<Integer>> stack;
	private Observable<MemoryObserver<Integer>> memory;

	private ToolBarPanel _toolBar;
	private ProgramPanel _programView;
	private StackPanel _stackView;
	private OutputPanel _outputView;
	private InputPanel _inputView;
	private MemoryPanel _memoryView;
	private StatusBarPanel _statusBar;
	private MenuBarPanel _menu;

	public SwingView(GUIControler ctrl,Observable<CPUObserver> cpu,Observable<StackObserver<Integer>> stack,Observable<MemoryObserver<Integer>> memory){
		super("Maquina Virtual");
		
		this.cpu = cpu;
		this.stack = stack;
		this.memory = memory;
		this.ctrl = ctrl;
		initGUI();
		cpu.addObserver(this);
	}
	
	private void initGUI(){
		
		
		
	
		_menu = new MenuBarPanel(ctrl);
		
		_toolBar = new ToolBarPanel(ctrl,cpu);
		_programView = new ProgramPanel(ctrl,cpu);
		_stackView = new StackPanel(ctrl,stack,cpu);
		_memoryView = new MemoryPanel(ctrl,memory,cpu);
		_inputView = new InputPanel(ctrl);
		_outputView = new OutputPanel(ctrl);
		_statusBar = new StatusBarPanel(stack,memory,cpu);
		JPanel mainPanel = new JPanel(new BorderLayout());
		JPanel centerPanel = new JPanel (new GridBagLayout());
		JPanel secondPanel = new JPanel(new GridLayout(0, 1, 0, 3));
		secondPanel.add(_inputView);
		secondPanel.add(_outputView);
		this.setContentPane(mainPanel);
		mainPanel.add(_toolBar, BorderLayout.PAGE_START);
		mainPanel.add(_programView, BorderLayout.LINE_START);
		mainPanel.add(_statusBar,BorderLayout.PAGE_END);
		GridBagConstraints c = new GridBagConstraints();
	      c.gridx = 0;
	      c.gridy = 0;
	      c.weightx = 1;
	      c.fill = GridBagConstraints.HORIZONTAL;
		  c.ipady = 800;
		  c.weighty = 0.5;  
		
		centerPanel.add(_stackView, c);

		  c.gridx = 1;
	      c.gridy = 0;
	      c.weightx = 1;

		centerPanel.add(_memoryView, c);

	       c.gridx = 0;
		   c.gridy = 1;
		   c.weightx = 0.0;
		   c.gridwidth = 3;
		   c.ipady = 300;
		   c.weighty = 0.1; 

		centerPanel.add(secondPanel, c);

		mainPanel.add(centerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		this.setSize(800, 600);
		this.setJMenuBar(_menu.CreateMenuBar());
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "¿Esta seguro que desea salir del programa?", "¿Salir?",
			        JOptionPane.YES_NO_OPTION);
			    if (confirmed == JOptionPane.YES_OPTION){
			    	try {
						ctrl.quit();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			    }
			  }
			});
	}
	
	//METODOS DE 
	@Override
	public void onStartInstrExecution(Instruction instr) {}
	@Override
	public void onStartRun() {}
	@Override
	public void onError(String msg) { JOptionPane.showMessageDialog(this,msg,"Error",0,null); }
	@Override
	public void onHalt() {}
	@Override
	public void onReset(ProgramMV program) {}
	@Override
	public void onEndRun() {}
	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria,OperandStack<Integer> pila) {}
}
