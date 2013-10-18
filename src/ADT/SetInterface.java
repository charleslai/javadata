package ADT;
/** This is an interface for a Set ADT. Properties of a set is
 * that the set contains no duplicates. It makes no promises
 * about ordering but iteration over a set is still guaranteed
 */
public interface SetInterface {
	public void insert(Object x);
	public boolean contains(Object x);
	public void remove(Object x);
	public boolean isEmpty(Object x);
	public void clear();
	//for (Object x: Set) {}; How do I write this in interface?
}
