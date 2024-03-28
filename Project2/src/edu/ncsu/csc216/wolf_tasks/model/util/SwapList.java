package edu.ncsu.csc216.wolf_tasks.model.util;

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
		//TODO: implement method
	}
	
	private void checkCapacity(int a) {
		//TODO: implement method
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		return (E) "index";
	}
	
	private void checkIndex(int idx) {
		add(list[0]);
		//TODO: implement method
	}
	
	@Override
	public void moveUp(int idx) {
		//TODO: implement method
	}
	
	@Override
	public void moveDown(int idx) {
		//TODO: implement method
	}
	
	@Override
	public void moveToFront(int idx) {
		//TODO: implement method
	}
	
	@Override
	public void moveToBack(int idx) {
		//TODO: implement method
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
