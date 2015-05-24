/**
 * 
 */
package algorithm;

/**
 * Search Class 
 * Contains:
 *     Linear Search
 *     Binary Search
 * @author charleslai
 *
 */
public class Search {
	/**
	 * A simple, "brute-force" searching algorithm.
	 * @param T[] arr - an array of objects that implement Comparable
	 * @param T query - an search query object that implements Comparable
	 */
	public static <T extends Comparable<T>> Boolean linearSearch(T[] arr, T query) {
		//Iterate through the entire array
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == query) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A Java implementation of binary search 
	 * @param T[] arr - an array of objects that implement Comparable
	 * @param T query - an search query object that implements Comparable
	 */
	public static <T extends Comparable<T>> Boolean binarySearch(T[] arr, T query) {
		int low = 0;
		int high = arr.length - 1;
		// Keep searching until we can't divide any further
		while (low <= high) {
			//Divide and Conquer Step: find midpoint
			int mid = (low + high)/2;
			T midVal = arr[mid];
			int result = midVal.compareTo(query);
			// If midVal > query - binary search bottom half
			if (result > 0) {
				high = mid - 1;
			}
			// if midVal < query - binary search top half
			else if (result < 0) {
				low = mid + 1;
			}
			// If result == 0, then value found
			else {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Class main method for testing
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5};
		String[] b = {"Hello", ",", "World", "!"};
		System.out.println(Search.linearSearch(a, 5));
		System.out.println(Search.binarySearch(a, 5));
		System.out.println(Search.linearSearch(b, "Hello"));
	}

}
