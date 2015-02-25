package tp.pr5.mv.cpu;
import java.util.Scanner;

/**
 * Clase que contiene varias constantes del programa como el lector o el caracter del salto de linea.
 * 
 * @author Sebastian Aguila.
 * 
 */

public class Constantes {
	
	private static Scanner _sc = new Scanner (System.in);

	/**  Metodo que devuelve el caracter del salto de linea */
	public static String SALTO(){
		return System.getProperty("line.separator");
	}
	
	/** Metodo que lee del teclado y devuelve un string con lo intruducido */
	public static String leerConsola(){
	String linea = _sc.nextLine();
     return linea;
	}
	public static void cerrarLector(){
		_sc.close();
	}
}
