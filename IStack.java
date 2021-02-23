
/**
 * 
 */

/**
 * @author moises
 *
 */
public interface IStack<E> { //Interface con los metodos propios de la interface
	
	public boolean push(E element);
	
	public E peek();
	
	public E pop();
	
	public int count();
	
	public boolean isEmpty();
}
