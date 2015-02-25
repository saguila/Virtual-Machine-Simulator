package tp.pr5.mv.strategy;
//
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Fileinstrategy implements Instrategy {

	private String _fName;
	private FileReader _f;
	
	public Fileinstrategy(String fileName) {
    _fName = fileName;
	}

	@Override
	public void close() throws IOException {
		_f.close();
	}

	@Override
	public void open() throws FileNotFoundException{
		try{
		_f = new FileReader(_fName);
		}catch (FileNotFoundException e){
			System.err.print("El fichero no existe");
		}
	}

	@Override
	public int read() throws IOException {
		if(_f.ready())
			return _f.read();
		else
			return -1;
		
	}

}