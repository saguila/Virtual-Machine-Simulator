/**
 * 
 */
package tp.pr5.mv.cpu;


public interface StackObserver<T> {
public void onPush(int value);
public void onPop();
public void onStackReset();//Opcional en caso que tengamos el metodo reset.
}
