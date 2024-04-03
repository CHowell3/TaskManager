package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Custom linked list that allows duplicate elements and implements the ISwapList interface
 * @param <E> the elements in the swapList
 * @author Johnathan Howell and Rachel Cantrell
 */
public class SwapList<E> implements ISwapList<E> {
	
	/** 10 is the initial capcity of the swapList */
	private static final int INITIAL_CAPACITY = 10;
	
	/** Array of elements */
	private E[] list;
	
	/** size of the swapList */
	private int size;

	/**
	 * Constructor of the SwapList class that initializes the list field to 
	 * and array of size 10 with E elements
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
	}

	/**
	 * Method that adds the element passed as parameter to the swapList
	 * @param element that is added
	 */
	@Override
	public void add(E element) {
		checkCapacity(0);
	}
	
	/**
	 * Method that checks the capacity of the SwapList
	 * @param idx checks the element to see if it is full in the list
	 */
	private void checkCapacity(int idx) {
		// Method not yet implemented
	}
	
	/**
	 * Method that removes the element in SwapList at the index passed as parameter
	 * @param idx index that the element will be removed from
	 * @return E element that is removed from the SwapList
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		return (E) "index";
	}
	
	/**
	 * Method that checks the SwapList at the specific index passed
	 * @param idx index that will be checked in the list
	 */
	private void checkIndex(int idx) {
		add(list[0]);
	}
	
	/**
	 * Method that moves the specific element at index passed up in the list
	 * @param idx index of element that is being moved up
	 */
	@Override
	public void moveUp(int idx) {
		// Method not yet implemented
	}
	
	/**
	 * Method that moves the specific element at index passed down in the list
	 * @param idx index of element that is being moved down
	 */
	@Override
	public void moveDown(int idx) {
		// Method not yet implemented
	}
	
	/**
	 * Method that moves the specific element at index passed to the front of the list
	 * @param idx index of element that is being moved to the front
	 */
	@Override
	public void moveToFront(int idx) {
		// Method not yet implemented
	}
	
	/**
	 * Method that moves the specific element at index passed to the back of the list
	 * @param idx index of element that is being moved to the back
	 */
	@Override
	public void moveToBack(int idx) {
		// Method not yet implemented
	}
	
	/**
	 * Method that returns the specific element at the index passed
	 * @param idx index we are searching for 
	 * @return E element at that specific index
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E get(int idx) {
		return (E) "index";
	}
	
	/**
	 * Returns the size of the SwapList
	 * @return int size 
	 */
	@Override
	public int size() {
		return size;
	}
}
