package tp.pr5.mv.gui.swing;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextArea;

import tp.pr5.mv.strategy.Instrategy;

public class InStreamGUI implements Instrategy {

	JTextArea _inputTextArea;
	Instrategy _old;
	StringBuilder content;
	int pos;
	
	public InStreamGUI(Instrategy old,JTextArea inputTextArea){
	_old = old;
	_inputTextArea = inputTextArea; 
	try{
		content =  new StringBuilder();
		int i = old.read();
		while(i!=-1){
			content.append((char) i);
	i = old.read();
		};
	inputTextArea.setText(content.toString());
	} catch(IOException e){
		e.printStackTrace();
	}
	}
	
	@Override
	public void close() throws IOException {
		_old.close();
	}

	@Override
	public void open() throws FileNotFoundException {
		// Old ya esta abierto
		}

	@Override
	public int read() throws IOException {
		char c = 0;
		if(pos != content.length()){
			c = content.charAt(pos);
			if(c != 10 && c != 13) content.setCharAt(pos,'*');
			_inputTextArea.setText(content.toString());
			pos++;
			return (int) c;
		}
		else
			return -1;
	}

}
