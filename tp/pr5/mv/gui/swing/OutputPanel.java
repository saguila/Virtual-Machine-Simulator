package tp.pr5.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import tp.pr5.mv.exceptions.MVError;
import tp.pr5.mv.gui.controllers.GUIControler;
import tp.pr5.mv.strategy.Outstrategy;


@SuppressWarnings("serial")
public class OutputPanel extends JPanel{
private GUIControler _guiCtrl;
private JTextArea _outputTextArea;

public OutputPanel(GUIControler guiCtrl){
	_guiCtrl = guiCtrl;
	initGUI();
}

private void initGUI(){
	this.setLayout(new BorderLayout());
	this.setBorder(new TitledBorder("Salida"));
	_outputTextArea =  new JTextArea(20,15);
	_outputTextArea.setFont(new Font("Arial", Font.BOLD, 10));
	_outputTextArea.setEditable(false);
	this.add(_outputTextArea);
	Outstrategy inCurr = _guiCtrl.getOutStream();
	Outstrategy inNew = new OutStreamGUI(inCurr,_outputTextArea);
	_outputTextArea.getText();
	try {
		_guiCtrl.setOutStream(inNew);
	} catch (MVError e) {
	}
}
}
