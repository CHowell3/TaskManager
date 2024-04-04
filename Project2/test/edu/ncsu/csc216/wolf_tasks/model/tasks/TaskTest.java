package edu.ncsu.csc216.wolf_tasks.model.tasks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

/**
 * Test for the Task class.
 */
public class TaskTest {

	/**
	 * Tests the Task constructor.
	 */
	@Test
	public void testTaskConstructor() {
		Task task = new Task("Task 1", "Description 1", true, false);
		assertNotNull(task);
		assertEquals("Task 1", task.getTaskName());
		assertEquals("Description 1", task.getTaskDescription());
		assertTrue(task.isRecurring());
		assertFalse(task.isActive());
	}
	
	/**
	 * Tests the getTaskName method.
	 */
	@Test
	public void getTaskNameTest() {
		Task task = new Task("Task 2", "Description 2", false, true);
        assertEquals("Task 2", task.getTaskName());
	}
	
	/**
	 * Tests the setTaskName method.
	 */
	@Test
	public void setTaskNameTest() {
		 Task task = new Task("Task 3", "Description 3", false, true);
	     task.setTaskName("Task 3 Updated");
	     assertEquals("Task 3 Updated", task.getTaskName());
	}
	
	/**
	 * Tests the getTaskDescription method.
	 */
	@Test
	public void getTaskDescriptionTest() {
		Task task = new Task("Task 4", "Description 4", false, true);
	    assertEquals("Description 4", task.getTaskDescription());
	}
	
	/**
	 * Tests the setTaskDescription method.
	 */
	@Test
	public void setTaskDescriptionTest() {
		 Task task = new Task("Task 5", "Description 5", false, true);
	     task.setTaskDescription("Description 5 Updated");
	     assertEquals("Description 5 Updated", task.getTaskDescription());
	}
	
	/**
	 * Tests the isRecurring method.
	 */
	@Test
	public void isRecurringTest() {
		 Task task = new Task("Task 6", "Description 6", true, true);
	     assertTrue(task.isRecurring());
	}
	
	/**
	 * Tests the setRecurring method.
	 */
	@Test
	public void setRecurringTest() {
		Task task = new Task("Task 7", "Description 7", true, true);
        task.setRecurring(false);
        assertFalse(task.isRecurring());
	}
	
	/**
	 * Tests the isActive method.
	 */
	@Test
	public void isActiveTest() {
		 Task task = new Task("Task 8", "Description 8", false, false);
	     assertFalse(task.isActive());
	}
	
	/**
	 * Tests the setActive method.
	 */
	@Test
	public void setActiveTest() {
		Task task = new Task("Task 9", "Description 9", true, false);
        task.setActive(true);
        assertTrue(task.isActive());
	}
	
	/**
	 * Tests the getTaskListName method.
	 */
	@Test
	public void getTaskListNameTest() {
		Task task = new Task("Task 10", "Description 10", true, true);
        assertEquals("", task.getTaskListName());
	}
	/**
	 * Tests the addTaskList method.
	 */
	@Test
	public void addTaskListTest() {
		Task task = new Task("Task 11", "Description 11", false, false);
        AbstractTaskList taskList = new TaskList("TaskList 11", 0);
        task.addTaskList(taskList);
        assertEquals("TaskList 11", task.getTaskListName());
	}
	
	/**
	 * Tests the completeTask method.
	 */
	@Test
	public void completeTaskTest() {
	    Task task = new Task("Task 12", "Description 12", false, true);
	    AbstractTaskList taskList = new TaskList("TaskList 12", 0);
	    taskList.addTask(task);
	    task.addTaskList(taskList);
	    assertTrue(task.isActive());
	    task.completeTask();
	    assertFalse(task.isActive());
	}	
	
	/**
	 * Tests the clone method.
	 */
	@Test
	public void cloneTest() {
		Task task1 = new Task("Task 1", "Description 1", false, false);
		
	    AbstractTaskList taskList1 = new TaskList("TaskList 1", 1);
	    AbstractTaskList taskList2 = new TaskList("TaskList 2", 2);
	    task1.addTaskList(taskList1);
	    task1.addTaskList(taskList2);
	    
	    try {
	        Task clonedTask = task1.clone();
	        
	        assertEquals(task1.getTaskName(), clonedTask.getTaskName());
	        assertEquals(task1.getTaskDescription(), clonedTask.getTaskDescription());
	        assertEquals(task1.isActive(), clonedTask.isActive());
	        assertEquals(task1.isRecurring(), clonedTask.isRecurring());
	    } catch (CloneNotSupportedException e) {
	        fail("Cloning should not throw CloneNotSupportedException");
	    }
	}
	
	/**
	 * Tests the toString method.
	 */
	@Test
	public void toStringTest() {
		Task task1 = new Task("Task 1", "Description 1", true, true);
		assertEquals("Task: " + "Task 1" + "\nDescription: " + "Description 1" + "\nRecurring: true\nActive: true", task1.toString());
		
		Task task2 = new Task("Task 2", "Description 2", false, true);
		assertEquals("Task: " + "Task 2" + "\nDescription: " + "Description 2" + "\nRecurring: false\nActive: true", task2.toString());
	}
	
}
