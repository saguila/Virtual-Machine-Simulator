package tp.pr5.mv.exceptions;

@SuppressWarnings("serial")
public class InvalidInput extends Exception{

	public InvalidInput(String message){ super(message + " El campo solo se aceptara numeros enteros.");}
}
