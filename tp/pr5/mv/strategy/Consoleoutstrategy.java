package tp.pr5.mv.strategy;
//
public class Consoleoutstrategy implements Outstrategy{

	@Override
	public void open() {		
	}

	@Override
	public void close() {
		
	}

	@Override
	public void write(int c) {
	System.out.print((char)c);
	}

}