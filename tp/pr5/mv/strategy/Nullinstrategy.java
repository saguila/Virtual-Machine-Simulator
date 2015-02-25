package tp.pr5.mv.strategy;
//
public class Nullinstrategy implements Instrategy {

	@Override
	public void close() {}

	@Override
	public void open() {}

	@Override
	public int read() {
		return -1;
	}
}