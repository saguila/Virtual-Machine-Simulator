package tp.pr5.mv.strategy;
//
import java.io.IOException;

public interface Outstrategy{
public void open() throws IOException;
public void close () throws IOException;
void write(int c) throws IOException;

}
