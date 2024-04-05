package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Test for the TaskList class. Since TaskList is a child class of AbstractTaskList, AbstractTaskListTest must also be used to ensure full functionality.
 * @author Rachel Cantrell
 */
public class TaskListTest {
	
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
	 * Tests the TaskList constructor.
	 */
	@Test
	public void testTaskListConstructor() {
		TaskList taskList = new TaskList(TASK_LIST_NAME, 0);
		assertEquals(0, taskList.getCompletedCount());
		assertEquals(TASK_LIST_NAME, taskList.getTaskListName());
	}
	
	/**
	 * Tests the getTasksAsArray method.
	 */
	@Test
	public void getTasksAsArrayTest() {
		String[][] array = new String[2][2];
		array[0][0] = Integer.toString(1);
		array[1][0] = Integer.toString(2);
		array[0][1] = "Alice's present";
		array[1][1] = "Buy groceries";
		
		TaskList taskList = new TaskList(TASK_LIST_NAME, 0);
		taskList.addTask(TASK_A);
		taskList.addTask(TASK_B);
		String[][] listArray = taskList.getTasksAsArray();
		assertTrue(Arrays.equals(array[0], listArray[0]));
		assertTrue(Arrays.equals(array[1], listArray[1]));
	}
	
	/**
	 * Tests the compareTo method.
	 */
	@Test
	public void compareToTest() {
		TaskList taskList1 = new TaskList(TASK_LIST_NAME, 0);
		TaskList taskList2 = new TaskList(TASK_LIST_NEW_NAME, 3);
		assertTrue(taskList1.compareTo(taskList2) > 0);
	}
	
	
}
