/**
 * 
 */
package algorithm;

import java.util.Arrays;

/**
 * Sort Class
 * Contains:
 *     Selection Sort
 *     Insertion Sort
 *     Quick Sort
 *     Merge Sort
 * @author charleslai
 *
 */
public class Sort<T extends Comparable<T>> {
	/**
	 * Selection sort procedure: 
	 * @param T[] arr - an array of objects that implement Comparable
	 * 
	 */
	public void selectionSort(T[] arr) {
		//Initialize values
		int iMin;
		//Iterate through the entire array
		for (int i = 0; i < arr.length; i++) {
			// Find the min element in the unsorted array arr[i .. arr.length-1]
			// Assume the min element is the first unsorted element at first
			iMin = i;
			for (int j = i+1; j < arr.length; j++) {
				// If a value in the unsorted list is < arr[iMin], update iMin
				if (arr[j].compareTo(arr[iMin]) < 0) {
					iMin = j;
				}
			}
			// If the iMin had to be updated, swap the values to maintain min invariant
			if (iMin != i) {
				swap(arr, i, iMin);
			}
		}
	}

	/**
	 * Insertion sort: A worst case O(n^2) sorting algorithm.
	 * @param T[] arr - an array of objects that implement Comparable
	 */
	public Boolean insertionSort(T[] arr) {
		//Iterate through the entire array
		for (int i = 0; i < arr.length; i++) {
			/*Comparable<?> temp = arr[i];
			int k;
			for (k = i; 0 < k && temp < arr[k-1]; k--) {
				arr[k] = arr[k-1];
			}
			arr[k] = temp;*/
		}
		return false;
	}
	
	/**
	 * Quicksort: An average case O(nlogn) sorting algorithm.
	 * @param arr:
	 * 
	 */
	public void quickSort(T[] arr) {
		return;
	}
	
	/**
	 * Mergesort: An average case O(nlogn) sorting algorithm.
	 * @param arr:
	 * 
	 */
	public void mergeSort(T[] arr){
		return;
	}

	/*===============================================================================
	 * 	
	 * 								HELPER FUNCTIONS
	 * 	
	 *==============================================================================*/
	/**
	 * Swap Procedure
	 * @param T[] arr - the array that contains the indices we want to swap
	 * @param int i - the index of the value we want to swap with arr[j]
	 * @param int j - the index of the value we want to swap with arr[i]
	 * Preconditions: i,j must both be valid indicies of arr
	 */
	public void swap (T[] arr, int i, int j){
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		Sort<Integer> intSort = new Sort<Integer>();
		Integer[] a = {5,4,3,2,1,0};
		intSort.selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

}
