package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Test for Notebook class.
 * @author Rachel Cantrell
 */
public class NotebookTest {

	/**
	 * Notebook name for testing
	 * "Super-duper Notebook"
	 */
	public final static String NOTEBOOK_NAME = "Super-duper Notebook";
	
	/**
	 * TaskList for testing
	 * "Healthy Habits"
	 */
	public final static TaskList LIST_H = new TaskList("Healthy Habits", 2);
	
	/**
	 * TaskList for testing
	 * "Study for Stats"
	 */
	public final static TaskList LIST_S = new TaskList("Study for Stats", 5);
	
	/**
	 * Duplicate TaskList for testing
	 * "Study for Stats"
	 */
	public final static TaskList LIST_S2 = new TaskList("Study for Stats", 0);
	
	/**
	 * Illegal TaskList for testing
	 * "Active Tasks"
	 */
	public final static TaskList LIST_ACTIVE = new TaskList("Active Tasks", 5);
	
	/**
	 * Tests the Notebook constructor
	 */
	@Test
	public void testNotebookConstructor() {
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		assertEquals(NOTEBOOK_NAME, notebook.getNotebookName());
		assertTrue(notebook.isChanged());
		Exception e = assertThrows(IllegalArgumentException.class, () -> new Notebook(null));
		assertEquals("Invalid name.", e.getMessage());
		e = assertThrows(IllegalArgumentException.class, () -> new Notebook(""));
		assertEquals("Invalid name.", e.getMessage());
		e = assertThrows(IllegalArgumentException.class, () -> new Notebook("Active Tasks"));
		assertEquals("Invalid name.", e.getMessage());
	}
	
	/**
	 * Tests the saveNotebook method
	 */
	@Test
	public void saveNotebookTest() {
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		
		assertFalse(notebook.isChanged());
		
	}
	
	@Test
	public void addTaskListTest() {
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		Exception e = assertThrows(IllegalArgumentException.class, () -> notebook.addTaskList(LIST_ACTIVE));
		assertEquals("Invalid name.", e.getMessage());
		
		notebook.addTaskList(LIST_S);
		notebook.addTaskList(LIST_H);
		e = assertThrows(IllegalArgumentException.class, () -> notebook.addTaskList(LIST_S2));
		assertEquals("Invalid name.", e.getMessage());
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
		
	}
	
	/**
	 * Tests the editTaskList method
	 */
	@Test
	public void editTaskTest() {
		fail("Not yet implemented");
	}
}
