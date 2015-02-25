package tp.pr5.mv.cpu;

import java.util.ArrayList;

import tp.pr5.mv.exceptions.EmpyStackException;

/** 
 * Clase que implemeta una pila,con sus metodos exclusivos y su comportamiento.
 * 
 * @author Sebastian Aguila Grupo 7.
 */

public class OperandStack <T> implements Observable<StackObserver<T>>{
	private T [] pila;
	private int numElem;
	private ArrayList<StackObserver<T>> observers;

	@SuppressWarnings("unchecked")
	public OperandStack(){
		pila = ((T[])  new Object[10]);
		numElem = 0;
		observers = new ArrayList<StackObserver<T>>();
	}
	
/** Metodo que devuelve la cima de la pila */
public int getCima(){
	return (Integer) pila[numElem - 1];
}


/** Metodo que recibe un numero y lo apila */
@SuppressWarnings("unchecked")
public void apila(Integer numero){
if(numElem < pila.length){
pila[numElem] = (T) numero;
numElem ++;	
	}
else{
	resize();
	pila[numElem] = (T) numero;
	numElem ++;	
}
for(StackObserver<T> o: observers)o.onPush(numero);
}

/** Metodo que saca un elemento de la pila,si no hay elementos no se hace nada 
 * @throws EmpyStackException */
public void desapila() throws EmpyStackException{
if(numElem > 0){
numElem -= 1;
for(StackObserver<T> o: observers)o.onPop();
}
else throw new EmpyStackException("Pop");
}

/** Metodo que devuelve el contador de la pila */
public int numElem(){
return numElem;
}




@SuppressWarnings("unchecked")
private void resize(){
T [] aux = ((T[])  new Object[10 + pila.length]);;
for(int i = 0 ; i < numElem ; i++){
	aux[i] = pila[i];
}
pila = aux;
}


/** Metodo toString que muestra el estado de la pila,todo su contenido */
public String toString() {
	StringBuilder result = new StringBuilder();
	result.append("Pila de operandos :");
	
	if(numElem >  0){
			for (int i = 0 ; i < numElem ; i ++) {
		   result.append( " " + pila[i] + " ");
		}
	}
	
	else{
		result.append(" " + " < Vacia >");
	}
	return result.toString();
	}

public void restoreStack(int size){
	numElem = size;
}

@Override
public void addObserver(StackObserver<T> o) {
	this.observers.add(o);
	
}

@Override
public void removeObserver(StackObserver<T> o) {
	this.observers.remove(o);
}

/* añade v a la pila y avisa a los oyentes usando on push */	
public void push(int v){
	this.apila(v);
	for(StackObserver<T> o: observers){
	o.onPush(v);
	}
}

public int pop() throws EmpyStackException{
	int n = this.getCima();
	this.desapila();
	for(StackObserver<T> o: observers) o.onPop();
	
	return n;
}
/* Borra el contenido de la memoria y avisa a los oyentes usando onMemReset */
@SuppressWarnings("unchecked")
public void reset(){
	pila = ((T[])  new Object[10]);
	numElem = 0;
	for(StackObserver<T> o: observers) o.onStackReset();
}

}
