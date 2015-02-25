package tp.pr5.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.exceptions.MVError;
import tp.pr5.mv.gui.controllers.GUIControler;
import tp.pr5.mv.strategy.Instrategy;


@SuppressWarnings("serial")
public class InputPanel extends JPanel{
private GUIControler _guiCtrl;
private JTextArea _inputTextArea;

public InputPanel(GUIControler guiCtrl){
	_guiCtrl = guiCtrl;
	initGUI();
}

private void initGUI(){
	this.setLayout(new BorderLayout());
	this.setBorder(new TitledBorder("Entrada"));
	_inputTextArea =  new JTextArea(20,15);
	_inputTextArea.setFont(new Font("Arial", Font.BOLD, 10));
	_inputTextArea.setEditable(false);
	this.add(_inputTextArea);
	Instrategy inCurr = _guiCtrl.getInStream();
	Instrategy inNew = new InStreamGUI(inCurr,_inputTextArea);
	try {
		_guiCtrl.setInStream(inNew);
	} catch (MVError e) {
	}
}
}
