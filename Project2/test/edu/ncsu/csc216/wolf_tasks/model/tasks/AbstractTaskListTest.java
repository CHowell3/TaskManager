package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Test for AbstractTaskList class. Since AbstractTaskList is an abstract class, most of the tests are done through one of its child classes.
 */
public class AbstractTaskListTest {

	public static final String TASK_LIST_NAME = "Task List";
	public static final String TASK_LIST_NEW_NAME = "Amazing Task List";
	
	public static final Task TASK_A = new Task("Alice's present", "Get a present for Alice", false, false);
	public static final Task TASK_A2 = new Task("Alice's present", "Get a present for Alice", false, false);
	public static final Task TASK_B = new Task("Buy groceries", "Remember to get milk", true, true);
	public static final Task TASK_C = new Task("Caroling", "Sing carols with the gang", false, true);
	public static final Task TASK_D = new Task("Do decorations", "Tree, lights, and garlands", false, true);
	public static final Task TASK_E = new Task("Exercise", "Treadmill and weights", true, false);
	
	/**
	 * Tests the AbstractTaskList constructor.
	 */
	@Test
	public void testAbstractTaskListConstructor() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> new TaskList(null, 3));
		assertEquals("Invalid name.", e.getMessage());
		
		e = assertThrows(IllegalArgumentException.class, () -> new TaskList("", 3));
		assertEquals("Invalid name.", e.getMessage());
		
		e = assertThrows(IllegalArgumentException.class, () -> new TaskList(TASK_LIST_NAME, -1));
		assertEquals("Invalid completed count.", e.getMessage());
		
		
		assertDoesNotThrow(() -> new TaskList(TASK_LIST_NAME, 0));
		
		TaskList taskList = new TaskList(TASK_LIST_NAME, 0);
		assertEquals(TASK_LIST_NAME, taskList.getTaskListName());
		assertEquals(0, taskList.getCompletedCount());
	}
	
	/**
	 * Tests the setTaskListName method
	 */
	@Test
	public void setTaskListNameTest() {
		TaskList taskList = new TaskList(TASK_LIST_NAME, 0);
		taskList.setTaskListName(TASK_LIST_NEW_NAME);
		assertEquals(TASK_LIST_NEW_NAME, taskList.getTaskListName());
	}
	
	/**
	 * Tests the addTask method
	 */
	@Test
	public void addTaskTest() {
		TaskList taskList = new TaskList(TASK_LIST_NAME, 0);
		ISwapList<Task> swapList = taskList.getTasks();
		assertEquals(0, swapList.size());
				
	}
	
	/**
	 * Tests the removeTask method
	 */
	@Test
	public void removeTaskTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the getTask method
	 */
	@Test
	public void getTaskTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the completeTask method
	 */
	@Test
	public void completeTaskTest() {
		fail("Not yet implemented");
	}
	
	/**
	 * Tests the getTasksAsArray method
	 */
	@Test
	public void getTasksAsArrayTest() {
		fail("Not yet implemented");
	}
}
