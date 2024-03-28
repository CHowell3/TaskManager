package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * This class is a custom list that sorts all elements added via their .comparable() method.
 * Does not allow duplicate elements to be added to the list.
 * @param <E> the type of Object being stored
 * @author Johnathan Howell
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	private int size;
	
	public SortedList() {
		// Method not yet implemented
	}
	
	public void add(E element) {
		// Method not yet implemented
	}
	
	@SuppressWarnings("unchecked")
	public E remove(int idx) {
		return (E) "type";
	}
	
	private void checkIndex(int idx) {
		// Method not yet implemented
	}
	
	public boolean contains(E element) {
		checkIndex(0);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public E get(int idx) {
		return (E) "type";
	}
	
	public int size() {
		return size;
	}
}
