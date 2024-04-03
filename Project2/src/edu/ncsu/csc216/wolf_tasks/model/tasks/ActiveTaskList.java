package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * Class that models the active task list.
 * Has a fixed name, "Active Tasks". All the active tasks are automatically added to it. 
 * @author Johnathan Howell and Rachel Cantrell
 */
public class ActiveTaskList extends AbstractTaskList {
	
	/**
	 * "Active Tasks" - the name of the Active Tasks list
	 */
	public static final String ACTIVE_TASKS_NAME = "Active Tasks";

	/**
	 * Constructor for ActiveTaskList. Calls the super constructor with the expected name and a completed count of 0. 
	 */
	public ActiveTaskList() {
		super(ACTIVE_TASKS_NAME, 0);
	}

	/**
	 * Checks if the task is active before adding it to this list.
	 * Throws an IllegalArgumentException "Cannot add task to Active Tasks" if the task is not active.
	 * @throws IllegalArgumentException if task is not active
	 */
	@Override
	public void addTask(Task t) {
		// Method not yet implemented
	}
	
	/**
	 * Ensures the paramater value matches the expected name.
	 * If the parameter isn't the expected value, an IllegalArgumentException is thrown with the message "The Active Tasks list may not be edited."
	 * @throws IllegalArgumentException if the parameter doesn't match the expected value
	 */
	@Override
	public void setTaskListName(String s) {
		// Method not yet implemented
	}
	
	/**
	 * Returns a 2D String array for display.
	 * The first column is the name of the first TaskList the task belongs to.
	 * The second column is the names of the tasks.
	 * @return the array for display
	 */
	@Override
	public String[][] getTasksAsArray() {
		return null;
	}
	
	/**
	 * Clears the Active Tasks list of all tasks.
	 */
	public void clearTasks() {
		// Method not yet implemented
	}

}
