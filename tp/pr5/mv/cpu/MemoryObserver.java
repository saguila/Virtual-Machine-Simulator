package tp.pr5.mv.cpu;

public interface MemoryObserver<T> {
public void onWrite(int index,T value);
public void onMemReset(); // Opcional en caso de tener metodo reset.
}
