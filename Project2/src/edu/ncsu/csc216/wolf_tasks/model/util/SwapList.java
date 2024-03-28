package edu.ncsu.csc216.wolf_tasks.model.util;

/**
 * Custom linked list that allows duplicate elements.
 * @param <E> the type of Object stored here
 * @author Johnathan Howell
 */
public class SwapList<E> implements ISwapList<E>{
	
	private static final int INITIAL_CAPACITY = 10;
	
	private E[] list;
	
	private int size;

	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
	}

	@Override
	public void add(E element) {
		checkCapacity(0);
	}
	
	private void checkCapacity(int a) {
		// Method not yet implemented
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		return (E) "index";
	}
	
	private void checkIndex(int idx) {
		add(list[0]);
	}
	
	@Override
	public void moveUp(int idx) {
		// Method not yet implemented
	}
	
	@Override
	public void moveDown(int idx) {
		// Method not yet implemented
	}
	
	@Override
	public void moveToFront(int idx) {
		// Method not yet implemented
	}
	
	@Override
	public void moveToBack(int idx) {
		// Method not yet implemented
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E get(int idx) {
		return (E) "index";
	}
	
	@Override
	public int size() {
		return size;
	}
}
