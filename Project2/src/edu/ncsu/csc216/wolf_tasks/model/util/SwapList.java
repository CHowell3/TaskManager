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
		if(element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		checkCapacity(size);
		list[size++] = element;
	}
	
	/**
	 * Method that checks the capacity of the SwapList
	 * @param idx checks the element to see if it is full in the list
	 */
	@SuppressWarnings("unchecked")
	private void checkCapacity(int idx) {
		if(idx == list.length) {
			E[] newList = (E[]) new Object[list.length * 2];
			for(int i = 0; i < size; i++) {
				newList[i] = list[i];
			}
			list = newList;
		}
	}
	
	/**
	 * Method that removes the element in SwapList at the index passed as parameter
	 * @param idx index that the element will be removed from
	 * @return E element that is removed from the SwapList
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		E dataY = list[idx];
		for(int i = 0; i < size - 1; i++) {
			list[i] = list[i + 1];
		}
		list[--size] = null;
		return dataY;
	}
	
	/**
	 * Method that checks the SwapList at the specific index passed
	 * @param idx index that will be checked in the list
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}
	
	/**
	 * Method that moves the specific element at index passed up in the list
	 * @param idx index of element that is being moved up
	 */
	@Override
	public void moveUp(int idx) {
		checkIndex(idx);
		if (idx > 0) {
			E moving = list[idx];
			list[idx] = list[idx - 1];
			list[idx - 1] = moving;
		}
	}
	
	/**
	 * Method that moves the specific element at index passed down in the list
	 * @param idx index of element that is being moved down
	 */
	@Override
	public void moveDown(int idx) {
		checkIndex(idx);
		if (idx < size - 1) {
			E moving = list[idx];
			list[idx] = list[idx + 1];
			list[idx + 1] = moving;
		}
	}
	
	/**
	 * Method that moves the specific element at index passed to the front of the list
	 * @param idx index of element that is being moved to the front
	 */
	@Override
	public void moveToFront(int idx) {
		checkIndex(idx);
		if (idx > 0) {
			E moving = list[idx];
			for (int i = idx; i > 0; i--) {
				list[i] = list[i - 1];
			}
			list[0] = moving;
		}
	}
	
	/**
	 * Method that moves the specific element at index passed to the back of the list
	 * @param idx index of element that is being moved to the back
	 */
	@Override
	public void moveToBack(int idx) {
		checkIndex(idx);
		if (idx < size - 1) {
			E moving = list[idx];
			for (int i = idx; i < size - 1; i++) {
				list[i] = list[i + 1];
			}
			list[size - 1] = moving;
		}
	}
	
	/**
	 * Method that returns the specific element at the index passed
	 * @param idx index we are searching for 
	 * @return E element at that specific index
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		return list[idx];
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