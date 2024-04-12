package edu.ncsu.csc216.wolf_tasks.model.util;


/**
 * This class is a custom list that sorts all elements added via their .comparable() method.
 * Does not allow duplicate elements to be added to the list.
 * @param <E> the type of Object being stored
 * @author Johnathan Howell and Rachel Cantrell
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	private static class ListNode<E> {
		
		/**
		 * Data stored by this list node
		 */
		E data;
		
		/**
		 * Reference to the next ListNode ini the list
		 */
		ListNode<E> next;
		
		ListNode(E data){
			this.data = data;
			
			this.next = null;
		}
	}
		
	/** size of the list */
	private int size;
	
	/**
	 * Reference to the first node in the list. If this is lost, so is the entire list.
	 */
	private ListNode<E> front;
	
	/**
	 * Constructor of SortedList class
	 */
	public SortedList() {
		front = null;
		
		size = 0;
	}
	
	/**
	 * Method to add specific element to the sortedList. Should throw a NullPointerException with message - 
	 * Cannot add null element - if the parameter is null. Should throw an IllegalArgumentException 
	 *  with message - Cannot add duplicate element - if the parameter is a duplicate of an existing element.
	 *  @param element to be added to the list
	 */
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		
		if(contains(element)) {
			throw new IllegalArgumentException("Cannot add duplicate element.");
		}
		
		ListNode<E> newNode = new ListNode<>(element);
		if(front == null || element.compareTo(front.data) < 0) {
			newNode.next = front;
			front = newNode;
		} else {
			ListNode<E> start = front;
			while(start.next != null && element.compareTo(start.next.data) > 0) {
				start = start.next;
			}
			newNode.next = start.next;
			start.next = newNode;
		}
		size++;
	}
	
	/**
	 * Method to remove spefic element from the sorted list at index passed by parameter
	 * @param idx index that will be removed from the list
	 * @return E element that is removed
	 */
	public E remove(int idx) {
		checkIndex(idx);
		E dataX;
		if(idx == 0) {
			dataX = front.data;
			front = front.next;
		} else {
			ListNode<E> start = front;
			for (int i = 0; i < idx - 1; i++) {
				start = start.next;
			}
			dataX = start.next.data;
			start.next = start.next.next;
		}
		size--;
		return dataX;
	}
	
	/**
	 * Method to check the value that is at the index passed by parameter
	 * @param idx index that will be check in the list
	 */
	private void checkIndex(int idx) {
		if(idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index."); 
		}
	}
	
	/**
	 * Method that checks if the list contains the element that is passed as paramaeter
	 * @param element that we are checking for
	 * @return true if the list contains the element, false otherwise
	 */
	public boolean contains(E element) {
		ListNode<E> start = front;
		while (start != null) {
			if (start.data.compareTo(element) == 0) {
				return true;
			}
			start = start.next;
		}
		return false;
	}
	
	/**
	 * Method that returns the element from the specific index passed as parameter
	 * @param idx index we are looking at in the list
	 * @return E element that is at that index
	 */
	public E get(int idx) {
		checkIndex(idx);
		ListNode<E> current = front;
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}
	
	/**
	 * Method that checks the size of the sortedList
	 * @return int size 
	 */
	public int size() {
		return size;
	}
}
