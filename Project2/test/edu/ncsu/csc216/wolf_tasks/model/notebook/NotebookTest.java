package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
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
	public final static TaskList LIST_S2 = new TaskList("Study for stats", 0);
	
	/**
	 * Illegal TaskList for testing
	 * "Active Tasks"
	 */
	public final static TaskList LIST_ACTIVE = new TaskList("Active tasks", 5);
	
	/** Task for testing ActiveTaskList*/
	public static final Task TASK_A = new Task("Alice's present", "Get a present for Alice", false, false);

	/** Task for testing ActiveTaskList*/
	public static final Task TASK_B = new Task("Buy groceries", "Remember to get milk", true, true);

	/** Task for testing ActiveTaskList*/
	public static final Task TASK_C = new Task("Caroling", "Sing carols with the gang", false, true);

	/** Task for testing ActiveTaskList*/
	public static final Task TASK_D = new Task("Do decorations", "Tree, lights, and garlands", false, true);

	/** Task for testing ActiveTaskList*/
	public static final Task TASK_E = new Task("Exercise", "Treadmill and weights", true, true);
	
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
		
		assertEquals(LIST_H, notebook.getCurrentTaskList());
		assertTrue(notebook.isChanged());
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
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		notebook.addTaskList(LIST_H);
		assertEquals(LIST_H, notebook.getCurrentTaskList());
		notebook.addTaskList(LIST_S);
		assertEquals(LIST_S, notebook.getCurrentTaskList());
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, notebook.getCurrentTaskList().getTaskListName());
		notebook.setCurrentTaskList("Healthy Habits");
		assertEquals(LIST_H, notebook.getCurrentTaskList());
		notebook.setCurrentTaskList("Not a name");
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, notebook.getCurrentTaskList().getTaskListName());
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
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		notebook.addTaskList(LIST_H);
		notebook.saveNotebook(null);
		notebook.addTask(TASK_A);
		
		assertTrue(notebook.isChanged());
		assertEquals(1, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_A, notebook.getCurrentTaskList().getTask(0));
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		assertEquals(0, notebook.getCurrentTaskList().getTasks().size());
		
		notebook.saveNotebook(null);
		notebook.addTask(TASK_B);
		assertTrue(notebook.isChanged());
		assertEquals(0, notebook.getCurrentTaskList().getTasks().size());
		notebook.setCurrentTaskList("Healthy Habits");
		assertEquals(1, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_A, notebook.getCurrentTaskList().getTask(0));
		
		notebook.saveNotebook(null);
		notebook.addTask(TASK_B);
		assertTrue(notebook.isChanged());
		assertEquals(2, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_A, notebook.getCurrentTaskList().getTask(0));
		assertEquals(TASK_B, notebook.getCurrentTaskList().getTask(1));
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		assertEquals(1, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_B, notebook.getCurrentTaskList().getTask(0));
		
	}
	
	/**
	 * Tests the editTaskList method
	 */
	@Test
	public void editTaskTest() {
		fail("Not yet implemented");
	}
}
