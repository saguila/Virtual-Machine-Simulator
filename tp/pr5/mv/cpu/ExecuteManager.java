package tp.pr5.mv.cpu;

public class ExecuteManager {
private int _nextInstruction;
private int _actualPc;
private boolean _halt;

/** Constructor por defecto del control de ejecucion */
public ExecuteManager(){
	_nextInstruction = 0;
	_actualPc = 0;
	_halt = false;
}

public void incrementPc(){
	_actualPc ++;
	_nextInstruction ++;
}
public void incrementPc(Integer param){
	_actualPc = param - 1;
}
public boolean equalsPc(){
	boolean equals = false;
	if(_actualPc == _nextInstruction){
		equals = true;
	}
		return equals;
}

public int get_nextInstruccion() {
	return _nextInstruction;
}

public void set_nextInstruccion(int _nextInstruccion) {
	this._nextInstruction = _nextInstruccion;
}

public int currentPc() {
	return _actualPc;
}

public void set_actualPc(int _actualPc) {
	this._actualPc = _actualPc;
}

public boolean is_halt() {
	return _halt;
}

public void set_halt(boolean _halt) {
	this._halt = _halt;
}
public void reset(){
	_nextInstruction = 0;
	_actualPc = 0;
}

}


