package edu.ncsu.csc216.wolf_tasks.model.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the SwapList class.
 */
public class SwapListTest {

	/**
	 * Tests the SwapList constructor.
	 */
	@Test
	public void testSwapListConstructor() {
		SwapList<String> swapList = new SwapList<>();
		assertNotNull(swapList);
		assertEquals(0, swapList.size());
	}
	
	/**
	 * Tests the add method.
	 */
	@Test
	public void addTest() {
		SwapList<String> swapList = new SwapList<>();
        swapList.add("Element 1");
        assertEquals(1, swapList.size());
        assertEquals("Element 1", swapList.get(0));
	}
	
	/**
	 * Tests the remove method.
	 */
	@Test
	public void removeTest() {
		SwapList<String> swapList = new SwapList<>();
        swapList.add("Element 1");
        String removed = swapList.remove(0);
        assertEquals(0, swapList.size());
        assertEquals("Element 1", removed);
	}
	
	/**
	 * Tests the moveUp method.
	 */
	@Test
	public void moveUpTest() {
		 SwapList<String> swapList = new SwapList<>();
	     swapList.add("Element 1");
	     swapList.add("Element 2");
	     swapList.moveUp(1);
	     assertEquals("Element 2", swapList.get(0));
	     assertEquals("Element 1", swapList.get(1));
	}
	
	/**
	 * Tests the moveDown method.
	 */
	@Test
	public void moveDownTest() {
		SwapList<String> swapList = new SwapList<>();
        swapList.add("Element 1");
        swapList.add("Element 2");
        swapList.moveDown(0);
        assertEquals("Element 2", swapList.get(0));
        assertEquals("Element 1", swapList.get(1));
	}
	
	/**
	 * Tests the moveToFront method.
	 */
	@Test
	public void moveToFrontTest() {
		SwapList<String> swapList = new SwapList<>();
	    swapList.add("Element 1");
	    swapList.add("Element 2");
	    swapList.moveToFront(1);
	    assertEquals("Element 2", swapList.get(0));
	    assertEquals("Element 1", swapList.get(1));	}
	
	/**
	 * Tests the moveToBack method.
	 */
	@Test
	public void moveToBackTest() {
		SwapList<String> swapList = new SwapList<>();
        swapList.add("Element 1");
        swapList.add("Element 2");
        swapList.moveToBack(0);
        assertEquals("Element 2", swapList.get(0));
        assertEquals("Element 1", swapList.get(1));
	}
	
	/**
	 * Tests the get method.
	 */
	@Test
	public void getTest() {
		SwapList<String> swapList = new SwapList<>();
	    swapList.add("Element 1");
	    swapList.add("Element 2");
	    assertEquals("Element 2", swapList.get(1));
	}
	
	/**
	 * Tests the size method.
	 */
	@Test
	public void sizeTest() {
		SwapList<String> swapList = new SwapList<>();
	    assertEquals(0, swapList.size());
	    swapList.add("Element 1");
	    assertEquals(1, swapList.size());
	    swapList.remove(0);
	    assertEquals(0, swapList.size());
	}
}
