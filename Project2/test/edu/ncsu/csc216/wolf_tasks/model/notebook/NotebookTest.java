package edu.ncsu.csc216.wolf_tasks.model.notebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;

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
	 * File for IO tests and testing isChanged
	 */
	public static final File FILE = new File("test-files/actual_out.txt");
	
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
		notebook.saveNotebook(FILE);
		assertFalse(notebook.isChanged());
		
	}
	
	/**
	 * Tests the addTaskList method
	 */
	@Test
	public void addTaskListTest() {
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		Exception e = assertThrows(IllegalArgumentException.class, () -> notebook.addTaskList(LIST_ACTIVE));
		assertEquals("Invalid name.", e.getMessage());
		
		notebook.saveNotebook(FILE);
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
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		String[] array1 = {ActiveTaskList.ACTIVE_TASKS_NAME};
		assertTrue(Arrays.equals(array1, notebook.getTaskListsNames()));
		
		notebook.addTaskList(LIST_S);
		String[] array2 = {ActiveTaskList.ACTIVE_TASKS_NAME, "Study for Stats"};
		assertTrue(Arrays.equals(array2, notebook.getTaskListsNames()));
		
		notebook.addTaskList(LIST_H);
		String[] array3 = {ActiveTaskList.ACTIVE_TASKS_NAME, "Healthy Habits", "Study for Stats"};
		assertTrue(Arrays.equals(array3, notebook.getTaskListsNames()));		
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
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		assertThrows(IllegalArgumentException.class, () -> notebook.editTaskList("Peanuts"));
		
		notebook.addTaskList(LIST_H);
		notebook.addTaskList(LIST_S);
		assertThrows(IllegalArgumentException.class, () -> notebook.editTaskList(ActiveTaskList.ACTIVE_TASKS_NAME));
		assertThrows(IllegalArgumentException.class, () -> notebook.editTaskList("active TaSKS"));
		assertThrows(IllegalArgumentException.class, () -> notebook.editTaskList("StudY For sTAts"));
		
		notebook.saveNotebook(FILE);
		notebook.editTaskList("Aapplesauce");
		assertTrue(notebook.isChanged());
		String[] array = {ActiveTaskList.ACTIVE_TASKS_NAME, "Aapplesauce", "Healthy Habits"};
		assertTrue(Arrays.equals(array, notebook.getTaskListsNames()));
		notebook.saveNotebook(FILE);
		notebook.editTaskList("Study for Stats");
		assertTrue(notebook.isChanged());
	}
	
	/**
	 * Tests the removeTaskList method
	 */
	@Test
	public void removeTaskListTest() {
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		Exception e = assertThrows(IllegalArgumentException.class, () -> notebook.removeTaskList());
		assertEquals("The Active Tasks list may not be deleted.", e.getMessage());
		notebook.addTaskList(LIST_H);
		notebook.addTaskList(LIST_S);
		notebook.saveNotebook(FILE);
		
		notebook.removeTaskList();		
		assertTrue(notebook.isChanged());
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, notebook.getCurrentTaskList().getTaskListName());
		
	}
	
	/**
	 * Tests the addTaskList method
	 */
	@Test
	public void addTaskTest() {
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		notebook.addTaskList(LIST_H);
		notebook.saveNotebook(FILE);
		notebook.addTask(TASK_A);
		
		assertTrue(notebook.isChanged());
		assertEquals(1, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_A, notebook.getCurrentTaskList().getTask(0));
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		assertEquals(0, notebook.getCurrentTaskList().getTasks().size());
		
		notebook.saveNotebook(FILE);
		notebook.addTask(TASK_B);
		assertFalse(notebook.isChanged());
		assertEquals(0, notebook.getCurrentTaskList().getTasks().size());
		notebook.setCurrentTaskList("Healthy Habits");
		assertEquals(1, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_A, notebook.getCurrentTaskList().getTask(0));
		
		notebook.saveNotebook(FILE);
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
		Notebook notebook = new Notebook(NOTEBOOK_NAME);
		notebook.addTaskList(LIST_H);
		notebook.addTask(TASK_A);
		notebook.addTask(TASK_B);
		notebook.addTask(TASK_C);
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		notebook.saveNotebook(FILE);
		
		notebook.editTask(1, "Buy baby toys", "Babysitting for Billy", false, true);
		assertFalse(notebook.isChanged());
		
		notebook.setCurrentTaskList("Healthy Habits");
		notebook.editTask(1, "Buy baby toys", "Babysitting for Billy", false, true);
		assertTrue(notebook.isChanged());
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		assertEquals(2, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_B, notebook.getCurrentTaskList().getTask(0));
		assertEquals(TASK_C, notebook.getCurrentTaskList().getTask(1));
		
		notebook.saveNotebook(FILE);
		notebook.setCurrentTaskList("Healthy Habits");
		notebook.editTask(0, "Anger Alice", "Dispose of a present for Alice", false, true);
		assertTrue(notebook.isChanged());
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		assertEquals(3, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_A, notebook.getCurrentTaskList().getTask(0));
		assertEquals(TASK_B, notebook.getCurrentTaskList().getTask(1));
		assertEquals(TASK_C, notebook.getCurrentTaskList().getTask(2));
		
		notebook.saveNotebook(FILE);
		notebook.setCurrentTaskList("Healthy Habits");
		notebook.editTask(0, "Anger Alice", "Dispose of a present for Alice", false, false);
		assertTrue(notebook.isChanged());
		notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
		assertEquals(2, notebook.getCurrentTaskList().getTasks().size());
		assertEquals(TASK_B, notebook.getCurrentTaskList().getTask(0));
		assertEquals(TASK_C, notebook.getCurrentTaskList().getTask(1));
	}
}
