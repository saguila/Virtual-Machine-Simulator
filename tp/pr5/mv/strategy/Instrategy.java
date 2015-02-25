package tp.pr5.mv.strategy;
//
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Instrategy {
public void close() throws IOException;
public void open() throws FileNotFoundException;
public int read() throws IOException;
}
