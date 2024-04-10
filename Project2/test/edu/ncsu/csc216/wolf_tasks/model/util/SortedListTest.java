package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test for SortedList class.
 */
public class SortedListTest {

	/**
	 * Tests the SortedList constructor.
	 */
	@Test
	public void testSortedListConstructor() {
		SortedList<String> sortedList = new SortedList<>();
        assertNotNull(sortedList);
        assertEquals(0, sortedList.size());
    }

	/**
	 * Tests the add method.
	 */
	@Test
	public void addTest() {
		SortedList<Integer> sortedList = new SortedList<>();
	    sortedList.add(5);
	    sortedList.add(3);
	    sortedList.add(8);
	    assertEquals(3, sortedList.size());
	    assertTrue(sortedList.contains(3));
	    assertTrue(sortedList.contains(5));
	    assertTrue(sortedList.contains(8));
	}
	
	/**
	 * Tests the remove method.
	 */
	@Test
	public void removeTest() {
		SortedList<Integer> sortedList = new SortedList<>();
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(8);
        sortedList.remove(1);
        assertEquals(2, sortedList.size());
        assertTrue(sortedList.contains(3));
        assertFalse(sortedList.contains(5));
	}
	
	/**
	 * Tests the contains method.
	 */
	@Test
	public void containsTest() {
		SortedList<String> sortedList = new SortedList<>();
        sortedList.add("apple");
        sortedList.add("banana");
        sortedList.add("orange");
        assertTrue(sortedList.contains("banana"));
        assertFalse(sortedList.contains("grape"));
	}
	
	/**
	 * Tests the get method.
	 */
	@Test
	public void getTest() {
		 SortedList<String> sortedList = new SortedList<>();
	     sortedList.add("Hello");
	     sortedList.add("there");
	     sortedList.add("How");
	     assertEquals("Hello", sortedList.get(0));
	     assertEquals("How", sortedList.get(1));
	     assertEquals("there", sortedList.get(2));
	}
	
	/**
	 * Tests the size method.
	 */
	@Test
	public void sizeTest() {
		SortedList<Character> sortedList = new SortedList<>();
        assertEquals(0, sortedList.size());
        sortedList.add('a');
        sortedList.add('b');
        assertEquals(2, sortedList.size());
    }
}

