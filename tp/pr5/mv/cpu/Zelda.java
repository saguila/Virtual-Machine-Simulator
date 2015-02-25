package tp.pr5.mv.cpu;
/** 
 * Clase que implementa una celda de memoria,con una direccion de memoria y un dato.
 * 
 * @author Sebastian Aguila Grupo 7.
 * 
 */
public class Zelda <T> {
	private int posicion;
	private T dato;
	
	/** Constructor de una celda*/
	public Zelda(int posicion,T dato){
		this.posicion = posicion;
		this.dato = dato;
		
	}
	
/** Metodo que devuelve la posicion de una celda */
	public int getPosicion() {
		return posicion;
	}

/**Metodo que devuelve el dato contenido en esa celda */
	public T getDato() {
		return dato;
	}
	
/** Metodo que modifica el dato contenido en esa celda */
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/** Metodo toString que devuelve un String con los datos de una celda,su posicion y su dato */
	public String toString() {
		return " [" + posicion + "]:" + dato +" ";
	}
}
