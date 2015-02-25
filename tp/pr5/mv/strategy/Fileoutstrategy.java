package tp.pr5.mv.strategy;
//
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fileoutstrategy implements Outstrategy{
	private PrintWriter _pw;
	private FileWriter _s;
	private String _fName;

	public Fileoutstrategy(String fileName) {
		_fName = fileName;
	}

	@Override
	public void open() throws IOException {
		_s = new FileWriter(_fName);
		_pw = new PrintWriter(_fName);
	}

	@Override
	public void close() throws IOException {
	_s.close();	
	_pw.close();
	}

	@Override
	public void write(int c) {
		_pw.print((char)c);
	}

}

