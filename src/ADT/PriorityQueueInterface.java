package ADT;
/** This is an interface for Priority Queue. This is queue that isn't
 * FIFO. It ranks objects for priority where the largest priority are
 * the smallest values based on comparator./
 * @author Charles
 *
 */

public interface PriorityQueueInterface {

	public abstract void insert(Object x);

	public abstract Object poll();

	public abstract Object peek();

	public abstract boolean isEmpty();

	public abstract void clear();

}