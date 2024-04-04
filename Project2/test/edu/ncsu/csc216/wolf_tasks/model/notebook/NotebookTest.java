package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

/**
 * Test for Notebook class.
 */
public class NotebookTest {

	/**
	 * Notebook name for testing
	 * "Super-duper Notebook"
	 */
	public final static String NOTEBOOK_NAME = "Super-duper Notebook";
	
	/**
	 * Tests the Notebook constructor
	 */
	@Test
	public void testNotebookConstructor() {
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		assertEquals(NOTEBOOK_NAME, notebook.getNotebookName());
		assertTrue(notebook.isChanged());
	}
	
	/**
	 * Tests the saveNotebook method
	 */
	@Test
	public void saveNotebookTest() {
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		
		assertFalse(notebook.isChanged());
		
	}
	
	/**
	 * Tests the getTaskListsNames method
	 */
	@Test
	public void getTaskListsNamesTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the setCurrentTaskList method
	 */
	@Test
	public void setCurrentTaskListTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the getCurrentTaskList method
	 */
	@Test
	public void getCurrentTaskListTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the editTaskList method
	 */
	@Test
	public void editTaskListTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the removeTaskList method
	 */
	@Test
	public void removeTaskListTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the addTaskList method
	 */
	@Test
	public void addTaskTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the editTaskList method
	 */
	@Test
	public void editTaskTest() {
		fail("Not yet implemented");
	}
}
