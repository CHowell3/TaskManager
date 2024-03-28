package edu.ncsu.csc216.wolf_tasks.model.util;

public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	private int size;
	
	public SortedList() {
		//TODO: implement method
	}
	
	public void add(E element) {
		//TODO: implement method
	}
	
	@SuppressWarnings("unchecked")
	public E remove(int idx) {
		return (E) "type";
	}
	
	private void checkIndex(int idx) {
		//TODO: implement method
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
