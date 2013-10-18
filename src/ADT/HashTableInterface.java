package ADT;

public interface HashTableInterface {
	public void insert(Object key, Object value); 
	public void update(Object key, Object value);
	public Object find(Object key); 
	public Object remove(Object key);
	public boolean isEmpty();
	public void clear();
	
}
