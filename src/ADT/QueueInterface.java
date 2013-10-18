package ADT;
/** This is an interface for a basic queue - it is FIFO -
 * first in first out.
 */
public interface QueueInterface {
	public void add(Object x);
	public Object poll();
	public Object peek();
	public boolean isEmpty();
	public void clear();
}
