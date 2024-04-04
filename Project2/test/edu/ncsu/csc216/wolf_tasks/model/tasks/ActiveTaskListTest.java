package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

/**
 * Test for the ActiveTaskList class. Since ActiveTaskList is a child class of AbstractTaskList, AbstractTaskListTest must also be used to ensure full functionality.
 */
public class ActiveTaskListTest {

	public static final Task TASK_A = new Task("Alice's present", "Get a present for Alice", false, false);
	public static final Task TASK_B = new Task("Buy groceries", "Remember to get milk", true, true);
	public static final Task TASK_C = new Task("Caroling", "Sing carols with the gang", false, true);
	public static final Task TASK_D = new Task("Do decorations", "Tree, lights, and garlands", false, true);
	public static final Task TASK_E = new Task("Exercise", "Treadmill and weights", true, true);
	
	/**
	 * Tests the ActiveTaskList constructor.
	 */
	@Test
	public void testActiveTaskListConstructor() {
		ActiveTaskList activeTasks = new ActiveTaskList();
		assertEquals(ActiveTaskList.ACTIVE_TASKS_NAME, activeTasks.getTaskListName());
		assertEquals(0, activeTasks.getTasks().size());
	}
	
	/**
	 * Tests the addTask method.
	 */
	@Test
	public void addTaskTest() {
		ActiveTaskList activeTasks = new ActiveTaskList();
		Exception e = assertThrows(IllegalArgumentException.class, () -> activeTasks.addTask(TASK_A));
		assertEquals("Cannot add task to Active Tasks.", e.getMessage());
		
		activeTasks.addTask(TASK_B);
		activeTasks.addTask(TASK_C);
		
		assertEquals(TASK_B, activeTasks.getTask(0));
		assertEquals(TASK_C, activeTasks.getTask(1));
	}
	
	/**
	 * Tests the setTaskListName method.
	 */
	@Test
	public void setTaskListNameTest() {
		ActiveTaskList activeTasks = new ActiveTaskList();
		Exception e = assertThrows(IllegalArgumentException.class, () -> activeTasks.setTaskListName("Random name"));
		assertEquals("The Active Tasks list may not be edited.", e.getMessage());
		
		assertDoesNotThrow(() -> activeTasks.setTaskListName(ActiveTaskList.ACTIVE_TASKS_NAME));
	}
	
	/**
	 * Tests the getTasksAsArray method.
	 */
	@Test
	public void getTasksAsArrayTest() {
		String[][] array = new String[2][2];
		array[0][0] = array[0][1] = ActiveTaskList.ACTIVE_TASKS_NAME;
		array[1][0] = "Do decorations";
		array[1][1] = "Exercise";
		
		ActiveTaskList activeTasks = new ActiveTaskList();
		activeTasks.addTask(TASK_D);
		activeTasks.addTask(TASK_E);
		String[][] listArray = activeTasks.getTasksAsArray();
		assertTrue(Arrays.equals(array[0], listArray[0]));
		assertTrue(Arrays.equals(array[1], listArray[1]));
	}
	
	/**
	 * Tests the clearTasks method.
	 */
	@Test
	public void clearTasksTest() {
		ActiveTaskList activeTasks = new ActiveTaskList();
		activeTasks.addTask(TASK_B);
		activeTasks.addTask(TASK_C);
		
		activeTasks.clearTasks();
		assertEquals(0, activeTasks.getTasks().size());
	}
}
