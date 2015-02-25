package tp.pr5.mv.strategy;


import java.io.IOException;

public class Consoleinstrategy implements Instrategy {
	

	@Override
	public void close(){
		
	}

	@Override
	public void open(){
	}

	@Override
	public int read() {
		try{
			int c = System.in.read();
			return c;
		}catch (IOException e){
			return -1;
		}
		
	}

}
