package datastructure;

public class ArrayList<T> {
	private T[] array;
	private int length;
	private double loadFactor = .85;
	
	@SuppressWarnings("unchecked")
	public ArrayList(){
		array = (T[]) new Object[10];
	}
	
	public ArrayList(T[] array){
		this.array = array;
	}
	
	@SuppressWarnings("unchecked")
	public void add(T v){
		if (length/array.length > loadFactor) {
			// Double arraylist size
			T[] temparray = array;
			array = (T[]) new Object[array.length * 2];
			// Copy elements into new array
			for(int i = 0; i < length; i++) {
				array[i] = temparray[i];
			}
		}
		// Push the value onto the end of the arraylist
		array[length+1] = v;
		length++;
	}
	
	public void remove(int k){
		// Enforce arraylist bounds
		assert k < length;
		// Push down values and leave last item
		for(; k < length-1; k++) {
			array[k] = array[k+1];
		}
		length--;
		
	}
	
	public T get(int k){
		// Enforce k is a valid index
		assert k < length;
		return array[k];
		
	}
	
	public void set(int k, T v){
		// Enforce k is a valid index 
		assert k < length;
		array[k] = v;
	}
	
	public int getLength() {
		return length;
	}
	
	public double getLoadFactor() {
		return loadFactor;
	}

	public void setLoadFactor(double loadFactor) {
		this.loadFactor = loadFactor;
	}
}
