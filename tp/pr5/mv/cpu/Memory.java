package tp.pr5.mv.cpu;

import java.util.ArrayList;

import tp.pr5.mv.exceptions.NegativeMemoryException;


/**
 * Clase que implementa la memoria,con sus celdas y con sus metodos exclusivos de memoria.
 * 
 * @author Sebastian Aguila Grupo 7.
 * @param <T>
 * 
 */

public class Memory<T> implements Observable<MemoryObserver<T>>{


private Zelda<T>[] celda; 
private int numCeldas;
private ArrayList<MemoryObserver<T>> observers;

/** Constructor de una memoria,instancia nuestro array de celdas con 100 celdas */
@SuppressWarnings("unchecked")
public Memory(){
celda = new Zelda[100];
numCeldas = 0;
observers = new ArrayList<MemoryObserver<T>>();
}

/** Metodo que ordena abriendo hueco en el lugar del orden de la celda incrementando 
 * una posicion a los siguientes,devuelve la posicion donde se debera escribir la celda 
 * */
private int ordenarInserccion(int numero){
	 int aux = numCeldas ;
boolean terminar = false;
		
		for (int i = 0 ; i < numCeldas && !terminar ; i++){
			if(numero <= celda[i].getPosicion()){
				terminar = true;
				aux = i;
			}
		}
		int devolver = aux;
		
		     for(int i = aux  ; i < numCeldas ; i++){
		    	 celda[i + 1] = celda[i];
		     }
		     return devolver;
}

/** Metodo que inserta una celda en nuestro array de celdas atributo de la clase Memory 
 * @throws NegativeMemoryException */
public void insertarCelda(int posicion,T dato) throws NegativeMemoryException{
	if(posicion < 0) throw new NegativeMemoryException(" posicion negativa:"+ posicion +".");
	if(numCeldas == celda.length){ // Si la memoria esta llena la incrementamos.
		incrementarMemoria();
	}
	
	if (numCeldas == 0){
		celda[0] = new Zelda<T>(posicion,dato);
		numCeldas++;
	}
	else{
	if (compruebaPosicion(posicion)){
		getCelda(damePosicion(posicion)).setDato(dato);
	}
	
	else{
		celda[ordenarInserccion(posicion)] = new Zelda<T>(posicion,dato);
		numCeldas ++;
	}
	}
	for(MemoryObserver<T> o: observers) o.onWrite(posicion, dato); // avisamos a los oyentes que se modifico la memoria.
}

/** Metodo que incrementa el numero de celdas en 100 cada vez que se llena */
@SuppressWarnings("unchecked")
public void incrementarMemoria(){
	
	Zelda<T> [] auxiliar;
	auxiliar = new Zelda[100 + celda.length]; // se añaden 100 mas.
	for(int i = 0 ; i <  celda.length ;i++){ // volcamos el array
		auxiliar[i] = celda[i];
	}
	celda = auxiliar; // igualamos los dos arrays.
}

/** Funcion que recorre las Celdas hasta que encuentra la posicion de memoria,si no devuelve falso,que no ha sido encontrada */
public boolean compruebaPosicion(int posicion){
	boolean encontrado = false;
	for(int i = 0 ; i < numCeldas && !encontrado ; i++){
		if(celda[i].getPosicion() == posicion){ // si la posicion concuerda con i nos da la posicion en la que se encuentra el dato;
			encontrado = true;
		}
	}
return encontrado;
}

/** Metodo que recibe una posicion y recorre nuestro array de celdas buscando esa posicion y devuelve la posicion donde se en cuentra en este array */
public int damePosicion(int posicion){
	boolean encontrado = false;
	for(int i = 0 ; i < celda.length && !encontrado ; i++){
		if(celda[i].getPosicion() == posicion){ // si la posicion concuerda con i nos da la posicion en la que se encuentra el dato;
			posicion = i;
			encontrado = true;
		}
	}
return posicion;
}

/** Metodo que devuelve una celda de nuestro array de celdas */
public Zelda<T> getCelda(int posicion) {
	return celda[posicion];
}

/** Metodo que devuelve el contador de las celdas que hay en nuestro array */
public int getContador() { return numCeldas; }

/** Metodo que devuelve un string con toda la informacion de la memoria,los datos todas sus celdas */
public String toString(){
	StringBuilder result = new StringBuilder();
	result.append("Memoria:");
	if(numCeldas > 0){
	for(int i = 0 ; i < numCeldas ; i++){
		result.append(celda[i].toString());
	}
	}
	else{
		result.append(" < Vacia > ");
	}
		
	return result.toString();
}
	 
public ArrayList<Zelda<T>> getArray(){
	ArrayList<Zelda<T>> pila = new ArrayList<Zelda<T>>();
	for(int i = 0 ; i < numCeldas ; i++) pila.add(celda[i]);
	return pila;
}

@Override
public void addObserver(MemoryObserver<T> o) {
	this.observers.add(o);
}

@Override
public void removeObserver(MemoryObserver<T> o) {
	this.observers.remove(o);
}

@SuppressWarnings("unchecked")
public void Reset(){ // opcional para el metodo reset.
	celda = new Zelda[100];
	numCeldas = 0;
    for(MemoryObserver<T> o: observers) o.onMemReset(); // avisamos a los oyentes que se hizo un reset.
}
}