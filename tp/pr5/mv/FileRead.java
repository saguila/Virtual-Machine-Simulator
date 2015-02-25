package tp.pr5.mv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileRead{
private Scanner _sc;
private FileReader _s;
private boolean _active;

public FileRead(String nFile) throws FileNotFoundException{
	_active = true;

	_sc = new Scanner(new FileReader(nFile));
	_s = new FileReader(nFile);


}

public String readLine(){
	String line = "";
	if(_sc.hasNext()){
		line = _sc.nextLine().trim();
	}
	else{
		_sc.close();
		_active = false;
	}
	
	return line;
}
public char readChar() throws IOException{
	char c =' ';

		if(_s.ready()){
			c = (char)_s.read();
		}		
		else{
			_s.close();
			_active = false;
		}
	return c;
}

public boolean status(){
	return _active;
}
}