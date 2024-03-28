package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * This class is a custom list that sorts all elements added via their .comparable() method.
 * Does not allow duplicate elements to be added to the list.
 * @param <E> the type of Object being stored
 * @author Johnathan Howell
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** size of the list */
	private int size;
	
	/**
	 * Constructor of SortedList class
	 */
	public SortedList() {
		// Method not yet implemented
	}
	
	/**
	 * Method to add specific element to the sortedList. Should throw a NullPointerException with message 
	 * “Cannot add null element.” if the parameter is null. Should throw an IllegalArgumentException 
	 *  with message “Cannot add duplicate element” if the parameter is a duplicate of an existing element.
	 *  @param E element to be added to the list
	 */
	public void add(E element) {
		// Method not yet implemented
	}
	
	/**
	 * Method to remove spefic element from the sorted list at index passed by parameter
	 * @param idx index that will be removed from the list
	 * @return E element that is removed
	 */
	@SuppressWarnings("unchecked")
	public E remove(int idx) {
		return (E) "type";
	}
	
	/**
	 * Method to check the value that is at the index passed by parameter
	 * @param idx index that will be check in the list
	 */
	private void checkIndex(int idx) {
		// Method not yet implemented
	}
	
	/**
	 * Method that checks if the list contains the element that is passed as paramaeter
	 * @param E element that we are checking for
	 * @return true if the list contains the element, false otherwise
	 */
	public boolean contains(E element) {
		checkIndex(0);
		return true;
	}
	
	/**
	 * Method that returns the element from the specific index passed as parameter
	 * @param idx index we are looking at in the list
	 * @return E element that is at that index
	 */
	@SuppressWarnings("unchecked")
	public E get(int idx) {
		return (E) "type";
	}
	
	/**
	 * Method that checks the size of the sortedList
	 * @return int size 
	 */
	public int size() {
		return size;
	}
}
