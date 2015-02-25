package tp.pr5.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import tp.pr5.mv.cpu.CPUObserver;
import tp.pr5.mv.cpu.Memory;
import tp.pr5.mv.cpu.MemoryObserver;
import tp.pr5.mv.cpu.Observable;
import tp.pr5.mv.cpu.OperandStack;
import tp.pr5.mv.cpu.ProgramMV;
import tp.pr5.mv.exceptions.NegativeMemoryException;
import tp.pr5.mv.gui.controllers.GUIControler;
import tp.pr5.mv.ins.Instruction;


@SuppressWarnings("serial")
public class MemoryPanel extends JPanel implements CPUObserver, MemoryObserver<Integer>{

private GUIControler _guiCtrl;
private MemTableModel _model;
private JTextField _memPos;
private JTextField _memValue;
private JButton _setButton;
//No detecta la llamada de onWrite,ni en run ni en step,cuando no tenemos valores en el Treemap si lo detecta.
public MemoryPanel(GUIControler ctrl,Observable<MemoryObserver<Integer>> memory,Observable<CPUObserver> cpu){
	cpu.addObserver(this);
	memory.addObserver(this);
	_guiCtrl = ctrl;
	_model = new MemTableModel();
	initGUI();
	
}

//actualizar la memoria cuando se recibe aviso onwrite,no se borra todo el contenido de la memoria.
//solo añadir un elemento,no usar getArray
//Borrar la memoria cuando se recibe onMEmREset
//desactivar el boton write cuando empizae la ejecucion del run y volverlo a activar cuando ttermina


private class MemTableModel extends AbstractTableModel{
	//content es una coleccion para mantener una copia de la memoria.
	String[] colNames = {"Direccion","Valor"};
	TreeMap<Integer,Integer> _content;
	  
public MemTableModel(){
	_content = new TreeMap<Integer,Integer>();
}

//onWrite llama a setvalue cuando hay cambios en la memoria
public void setValue(int index,int value){
	_content.put(index,value);//modificar la posicion de index (en content) para que tenga el valor nuevo _content.
	_model.fireTableDataChanged(); //avisar a JTable que el modelo ha sido modificado
}

@Override
//contador de columnas
public int getColumnCount() { return 2; }

@Override
//contador de filas
public int getRowCount() { return _content.size(); }



public Object getValueAt (int rowIndex, int columnIndex) {
	 // Devolvemos la posicion
	if(columnIndex == 0){ return _content.keySet().toArray()[rowIndex]; }
	//Si la columna no es 0 es 1. Devolvemos el dato contenido
    else{ return _content.get(_content.keySet().toArray()[rowIndex]); }
 }



public String getColumnName(int col) { return colNames[col]; }

public void reset(){_content = new TreeMap<Integer,Integer>();}


}
	

private void initGUI(){
	JTable table = new JTable(_model);
	JPanel centerPanel = new JPanel (new BorderLayout());
	JPanel testPanel = new JPanel ();
	testPanel.setLayout(new BoxLayout(testPanel, BoxLayout.X_AXIS));
    _setButton  = new JButton ("Establecer");
	JLabel etiquetaPos = new JLabel("Posicion");
	JLabel etiquetaVal = new JLabel("Valor");
	_memValue = new JTextField();
	_memPos = new JTextField();
	testPanel.add(etiquetaPos);
	testPanel.add(_memPos);
	testPanel.add(etiquetaVal);
	testPanel.add(_memValue);
	testPanel.add(_setButton);
	this.setLayout(new BorderLayout());
	this.setBorder(new TitledBorder("Memoria"));
	centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
	centerPanel.add(testPanel, BorderLayout.PAGE_END);
	this.add(centerPanel);
	
	_setButton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
					try {
						_guiCtrl.memorySet(Integer.parseInt(_memPos.getText()),Integer.parseInt(_memValue.getText()));
					} catch (NumberFormatException e1) {
						InternalError("Solo se aceptan numeros");
					} catch (NegativeMemoryException e1) {
					}
		}
	});
	
}


public void InternalError(String message){ JOptionPane.showMessageDialog(this,message,"Error en el Panel Memoria",0,null); }

@Override
public void onStartInstrExecution(Instruction instr) {}

@Override
public void onStartRun() { _setButton.setVisible(false); }

@Override
public void onEndRun() { _setButton.setVisible(true); }

@Override
public void onError(String msg) {}

@Override
public void onHalt() {}

@Override
public void onReset(ProgramMV program) {
	_model.reset();
	_model.fireTableDataChanged();}

@Override
public void onWrite(int index, Integer value) {_model.setValue(index,value); }

@Override
public void onMemReset() {
	_model._content.clear();
	_model.fireTableDataChanged();
}

@Override
public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer> pila) {}
}
