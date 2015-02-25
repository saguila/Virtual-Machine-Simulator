package tp.pr5.mv.gui.swing;

import java.io.IOException;

import javax.swing.JTextArea;


import tp.pr5.mv.strategy.Outstrategy;

public class OutStreamGUI implements Outstrategy{
//definir atributos necesarios.
	JTextArea _outputTextArea;
	Outstrategy _old;
	StringBuilder content;
	int pos;
	
	public OutStreamGUI(Outstrategy old,JTextArea outputTextArea){
		///Inicializa los atributos.
		_old = old;
		content = new StringBuilder();
		_outputTextArea = outputTextArea; 
		pos = 0;
	}

	@Override
	public void open() throws IOException {
		// no hacer nada se supone que el old ya esta abierto.
	}

	@Override
	public void close() throws IOException {
	_old.close();
	}

	@Override
	public void write(int c) throws IOException {
		_old.write(c);
		content.append((char)c);
		_outputTextArea.setText(content.toString());
		
	}


}	
