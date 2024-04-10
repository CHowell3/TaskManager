package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Test for AbstractTaskList class. Since AbstractTaskList is an abstract class, most of the tests are done through one of its child classes.
 */
public class AbstractTaskListTest {

	/**
	 * Name for a task list
	 * "Task List"
	 */
	public static final String TASK_LIST_NAME = "Task List";
	
	/**
	 * Name for a task list
	 * "Amazing Task List"
	 */
	public static final String TASK_LIST_NEW_NAME = "Amazing Task List";

	/**
	 * Task for testing TaskList class
	 */
	public static final Task TASK_A = new Task("Alice's present", "Get a present for Alice", false, false);

	/**
	 * Task for testing TaskList class
	 */
	public static final Task TASK_A2 = new Task("Alice's present", "Get a present for Alice", false, false);

	/**
	 * Task for testing TaskList class
	 */
	public static final Task TASK_B = new Task("Buy groceries", "Remember to get milk", true, true);

	/**
	 * Task for testing TaskList class
	 */
	public static final Task TASK_C = new Task("Caroling", "Sing carols with the gang", false, true);

	/**
	 * Task for testing TaskList class
	 */
	public static final Task TASK_D = new Task("Do decorations", "Tree, lights, and garlands", false, true);

	/**
	 * Task for testing TaskList class
	 */
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
		taskList.addTask(TASK_A);
		assertEquals(1, taskList.getTasks().size());

	}
	
	/**
	 * Tests the removeTask method
	 */
	@Test
	public void removeTaskTest() {
		TaskList taskList = new TaskList(TASK_LIST_NAME, 0);
        taskList.addTask(TASK_A);
        taskList.addTask(TASK_A2);
        taskList.addTask(TASK_B);
        taskList.addTask(TASK_C);
        assertEquals(TASK_B, taskList.removeTask(2));
        taskList.removeTask(0);
        taskList.removeTask(1);
        assertEquals(TASK_A2, taskList.getTask(0));
        taskList.removeTask(0);
	}
	
	/**
	 * Tests the getTask method
	 */
	@Test
	public void getTaskTest() {
		TaskList taskList = new TaskList(TASK_LIST_NAME, 0);
		taskList.addTask(TASK_A);
		assertEquals(TASK_A, taskList.getTask(0));
	}
	
	/**
	 * Tests the completeTask method
	 */
	@Test
	public void completeTaskTest() {
		TaskList taskList = new TaskList(TASK_LIST_NAME, 0);
		taskList.addTask(TASK_A);
		taskList.addTask(TASK_A2);
		assertEquals(0, taskList.getCompletedCount());
		taskList.completeTask(TASK_A);
		assertEquals(1, taskList.getCompletedCount());
	}
}
