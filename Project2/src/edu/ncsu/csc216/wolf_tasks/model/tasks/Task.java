package edu.ncsu.csc216.wolf_tasks.model.tasks;

import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;
import edu.ncsu.csc216.wolf_tasks.model.util.SwapList;

/**
 * Models individual tasks and stores their names, descriptions, and properties (active and recurring).
 * Also keeps an ISwapList of all the TaskLists this task belongs to.
 * Task implements the Cloneable interface. However, if the task does not belong to any TaskLists, an this method throws an exception.
 * @author Rachel Cantrell and Johnathan Howell
 */
public class Task implements Cloneable {
	
	/**
	 * The task's name.
	 */
	private String taskName;
	
	/**
	 * The task's description.
	 */
	private String taskDescription;
	
	/**
	 * Determines whether the task is active. Active tasks are included in the list of active tasks and represent the tasks the user is doing now.
	 */
	private boolean active;
	
	/**
	 * Determines whether the task is recurring. 
	 * Non-recurring tasks are deleted when they are completed.
	 * Recurring tasks are simply set to the lowest priority in their task lists.
	 */
	private boolean recurring;
	
	/**
	 * List of all taskLists that this task is part of.
	 */
	private ISwapList<AbstractTaskList> taskLists;
	
	/**
	 * Constructor for a task. Sets taskLists to an empty list.
	 * @param taskName the name of the task
	 * @param taskDetails a description of the task
	 * @param recurring if the task is recurring
	 * @param active if the task is active
	 */
	public Task(String taskName, String taskDetails, boolean recurring, boolean active){
		setTaskName(taskName);
		setTaskDescription(taskDetails);
		setActive(active);
		setRecurring(recurring);
		taskLists = new SwapList<AbstractTaskList>();
	}
	
	/**
	 * Returns the task's name.
	 * @return the task's name
	 */
	public String getTaskName() {
		return taskName;
	}
	
	/**
	 * Public helper method to Task constructor. Sets the task's name.
	 * @param taskName the name of the task
	 * @throws IllegalArgumentException if passed a null value or an empty string
	 */
	public void setTaskName(String taskName) {
		if (taskName == null || "".equals(taskName)) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskName = taskName;
			
	}
	
	/**
	 * Returns the task's description.
	 * @return the task's description
	 */
	public String getTaskDescription() {
		return taskDescription;
	}
	
	/**
	 * Public helper method to Task constructor. Set's the task's description.
	 * @param taskDescription the description of the task
	 * @throws IllegalArgumentException if passed a null value
	 */
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		this.taskDescription = taskDescription;
	}

	/**
	 * Returns the boolean value active.
	 * @return whether the task is an active task
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Changes whether the task is an active task.
	 * @param active a boolean
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Returns the boolean value recurring.
	 * @return whether the task is a recurring task
	 */
	public boolean isRecurring() {
		return recurring;
	}

	/**
	 * Changes whether the task is a recurring task.
	 * @param recurring the boolean to set
	 */
	public void setRecurring(boolean recurring) {
		this.recurring = recurring;
	}

	/**
	 * Returns an exact duplicate of the task.
	 * If taskLists is empty, a CloneNotSupportedException with the message "Cannot clone." is thrown.
	 * @throws CloneNotSupportedException if taskLists is empty
	 */
	@Override
	public Task clone() throws CloneNotSupportedException{
		if(taskLists.size() == 0) {
			throw new CloneNotSupportedException("Cannot clone.");
		}		
		Task task = new Task(taskName, taskDescription, active, recurring);
		task.taskLists = new SwapList<AbstractTaskList>();
		return task;
	}
	
	/**
	 * Returns a string representation of the task.
	 * @return a String representation of the task
	 */
	public String toString() {
		String string = "Task: " + taskName + "\nDescription: " + taskDescription;
		if (recurring && active) {
			string += "\nRecurring: true\nActive: true";
		} else {
			string += "\nRecurring: " + recurring + "\nActive: " + active;
		}
		return string;
	}
	
	/**
	 * Adds a task list to the task's list of task lists.
	 * If the task list isn't yet registered in the task, it's added to the end of taskLists.
	 * Null values cause an IllegalArgumentException to be thrown with the message "Incomplete task information."
	 * @param taskList the task list to be added
	 * @throws IllegalArgumentException if passed a null value.
	 */
	public void addTaskList(AbstractTaskList taskList) {
		if (taskList == null) {
			throw new IllegalArgumentException("Incomplete task information.");
		}
		boolean found = false;
		for (int i = 0; i < taskLists.size(); i++) {
			if (taskLists.get(i).equals(taskList)) {
				found = true;
			}
		}
		if (!found) {
			taskLists.add(taskList);
		}
	}
	
	/**
	 * Returns the name of the first task list in the task's list of task lists.
	 * If this task is not part of any task lists, an empty string is returned.
	 * @return taskListName
	 */
	public String getTaskListName() {
		if (taskLists == null || taskLists.size() == 0) {
			return "";
		}
		return taskLists.get(0).getTaskListName();
	}
	
	/**
	 * Completes a task and notifies all the TaskLists in taskLists via TaskList.completeTask(Task).
	 * If the task is recurring, a clone of the task is added to each taskList.
	 */
	public void completeTask() {
		if(isActive()) {
			setActive(false);
			for (int i = 0; i < taskLists.size(); i++) {
				taskLists.get(i).completeTask(this);
			}
			if (recurring) {
				try {
					Task cloneTask = this.clone();
					for (int i = 0; i < taskLists.size(); i++) {
						taskLists.get(i).addTask(cloneTask);
					}
				} catch (CloneNotSupportedException e) {
					System.out.println("Task cannot be cloned.");
				}
			}
		}
	}
}
