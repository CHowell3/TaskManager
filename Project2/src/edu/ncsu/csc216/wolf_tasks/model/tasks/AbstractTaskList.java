package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * Abstract class that is the superclass of the ActiveTaskList and TaskList classes.
 * @author Rachel Cantrell and Johnathan Howell
 */
public abstract class AbstractTaskList {
	
	/**
	 * The name of the task list.
	 */
	private String taskListName;
	
	/**
	 * The total number of tasks in this task list that have been completed.
	 */
	private int completedCount;

	/**
	 * List of all tasks in the taskList.
	 */
	private ISwapList<Task> tasks;
	
	/**
	 * Constructor for AbstractTaskList.
	 * Throws IllegalArgumentException "Invalid name." if the name is null or an empty string or if the completedCount is less than zero.
	 * @param taskListName the name of the task List
	 * @param completedCount the number of tasks that were completed
	 * @throws IllegalArgumentException if the name is null, an empty string, or if completedCount is less than zero.
	 */
	public AbstractTaskList(String taskListName, int completedCount) {
		if (completedCount < 0) {
			throw new IllegalArgumentException("Invalid completed count.");
		}
		setTaskListName(taskListName);
		this.completedCount = completedCount;
		this.tasks = new SwapList<>();
	}
	
	/**
	 * Returns the task list name.
	 * @return the task list name
	 */
	public String getTaskListName() {
		return taskListName;
	}

	/**
	 * Sets the taskList name.
	 * @param taskListName the new name of the taskList
	 */
	public void setTaskListName(String taskListName) {
		if (taskListName == null || "".equals(taskListName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		this.taskListName = taskListName;
	}
	
	/**
	 * Returns the list of tasks in the taskList.
	 * @return the tasks in the taskList
	 */
	public ISwapList<Task> getTasks(){
		return tasks;
	}
	
	/**
	 * Returns the number of completed tasks in this taskList.
	 * @return the number of tasks completed
	 */
	public int getCompletedCount() {
		return completedCount;
	}
	
	/**
	 * Adds a task to the end of the list. Then adds itself to the task's list of taskLists.
	 * @param t the task to be added
	 */
	public void addTask(Task t) {
		if (t == null) {
			throw new IllegalArgumentException("Task cannot be null.");
		}
		tasks.add(t);
		t.addTaskList(this);
	}
	
	/**
	 * Removes the Task at the index from the list and returns it.
	 * @param idx the index of the task to remove
	 * @return the task removed
	 */
	public Task removeTask(int idx) {
		return tasks.remove(idx);
	}
	
	/**
	 * Returns a Task at a given index.
	 * @param idx the index to be retrieved from
	 * @return the task retrieved
	 */
	public Task getTask(int idx) {
		return tasks.get(idx);
	}
	
	/**
	 * Completes the task. Increments the completed total by 1. Then it removes the task.
	 * Note: tasks are identified by ==, not .equals().
	 * @param t the task to complete
	 */
	public void completeTask(Task t) {
		if (t == null) {
			throw new IllegalArgumentException("Task cannot be null");
		}
		boolean taskFound = false;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i) == t) {
				tasks.remove(i);
				completedCount++;
				taskFound = true;
			}
		}
		
		if(!taskFound) {
			throw new IllegalArgumentException("Task not found");
		}
	}
	
	/**
	 * Returns a 2D String array meant for display in the GUI.
	 * @return the array for display
	 */
	public abstract String[][] getTasksAsArray();
}
