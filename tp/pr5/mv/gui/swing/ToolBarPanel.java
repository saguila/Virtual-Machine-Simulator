package tp.pr5.mv.gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.cpu.CPUObserver;
import tp.pr5.mv.cpu.Observable;
import tp.pr5.mv.gui.controllers.GUIControler;
import tp.pr5.mv.gui.views.SwingView;



@SuppressWarnings("serial")
public class ToolBarPanel extends JPanel{
private GUIControler _guiCtrl;

public ToolBarPanel(GUIControler guiCtrl,Observable<CPUObserver> cpu){
	_guiCtrl = guiCtrl;
	initGUI();
}
private void initGUI(){
	
	this.setBorder(new TitledBorder("Acciones"));
	
	JButton stepButton = new JButton("Step");
	stepButton.setIcon(createImageIcon("step.png"));
	stepButton.setToolTipText("Step");
	this.add(stepButton);
	stepButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				_guiCtrl.step();
			}
	});
	
	JButton runButton = new JButton("Run");
	runButton.setIcon(createImageIcon("run.png"));
	runButton.setToolTipText("Run");
	this.add(runButton);
	runButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				_guiCtrl.run();			
		}
	});
	
 
	JButton pauseButton = new JButton("Pause");
	pauseButton.setIcon(createImageIcon("pause.png"));
	pauseButton.setToolTipText("Pause");
	this.add(pauseButton);
	pauseButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		_guiCtrl.pause();
		}
	});
	
	JButton resetButton = new JButton("Reset");
	resetButton.setIcon(createImageIcon("reset.png"));
	resetButton.setToolTipText("Reset");
	this.add(resetButton);
	resetButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		_guiCtrl.reset();
		}
	});
	
	
	JButton exitButton = new JButton("Exit");
	exitButton.setIcon(createImageIcon("exit.png"));
	exitButton.setToolTipText("Exit");
	this.add(exitButton);
	exitButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try {
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "¿Esta seguro que desea salir del programa?", "¿Salir?",
				        JOptionPane.YES_NO_OPTION);
				    if (confirmed == JOptionPane.YES_OPTION){
				    	
				    }
				_guiCtrl.quit();
			} catch (IOException e1) {
			};
		}
	});
		
}
private static ImageIcon createImageIcon(String path){
	java.net.URL imgURL = SwingView.class.getResource(path);
	if(imgURL != null) return new ImageIcon(imgURL);
	return null;
}
}
