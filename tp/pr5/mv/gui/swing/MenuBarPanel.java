package tp.pr5.mv.gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.exceptions.InstructionInvalidException;
import tp.pr5.mv.gui.controllers.GUIControler;



@SuppressWarnings("serial")
public class MenuBarPanel extends JPanel implements ActionListener{
	private JFileChooser fileChoose;
	private GUIControler _guiCtrl;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem loadProgram;
	public MenuBarPanel(GUIControler guiCtrl){
		_guiCtrl = guiCtrl;
		fileChoose = new  JFileChooser();
		CreateMenuBar();
	}
	
	public JMenuBar CreateMenuBar(){
		loadProgram = new JMenuItem("Cargar nuevo programa");
		menuBar = new JMenuBar();
		menu = new JMenu("Mas opciones");
		menu.add(loadProgram);
		menuBar.add(menu);
		loadProgram.addActionListener(this);
		return menuBar;
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loadProgram) {
            int returnVal = fileChoose.showOpenDialog(MenuBarPanel.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChoose.getSelectedFile();
            try {
            	ProgramMV program = ProgramMV.read_program(file.getAbsolutePath());
					 _guiCtrl.loadProgram(program);
					 _guiCtrl.reset();
            } catch (InstructionInvalidException e1) {
					internalError("El programa seleccionado contiene errores","No se pudo cargar el programa",0);
				}
                 
            }
            else internalError("No ha seleccionado ningun programa","Cancelado por el usuario",2); 
            } 
	}

	private void internalError(String description,String title,int type){JOptionPane.showMessageDialog(this,description,title,type,null);}
}
