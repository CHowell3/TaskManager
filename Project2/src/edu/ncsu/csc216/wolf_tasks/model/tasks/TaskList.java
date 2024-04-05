package edu.ncsu.csc216.wolf_tasks.model.tasks;

/**
 * This class models a standard task list, with a variable name. It's a Child class of AbstractTaskList.
 * Holds a list of tasks in an ISwapList.
 * @author Rachel Cantrell and Johnathan Howell
 */
public class TaskList extends AbstractTaskList implements Comparable<TaskList> {

	/**
	 * Constructor for TaskList. Calls the constructor of the superclass and does nothing else.
	 * @param taskListName the name of the taskList
	 * @param completedCount the number of tasks completed in this taskList
	 */
	public TaskList(String taskListName, int completedCount) {
		super(taskListName, completedCount);
	}

	/**
	 * Returns a 2D String array for display.
	 * The first column is the priorities of the tasks, starting at 1.
	 * The second column is the names of the tasks.
	 * @return the array for display
	 */
	@Override
	public String[][] getTasksAsArray() {
		int rows = super.getTasks().size();
		String[][] array = new String[rows][2];
		for(int i = 0; i < rows; i++) {
			Task task = super.getTask(i);
			array[i][0] = Integer.toString(i + 1);
			array[i][1] = task.getTaskName();
		}
		return array;
	}

	/**
	 * Compares the taskLists by name. Returns an integer representing the difference between them.
	 * If the returned value is zero, the taskLists are considered equal.
	 * @param taskList the taskList to be compared
	 * @return int representing the difference between the taskLists
	 */
	public int compareTo(TaskList taskList) {
		return this.getTaskListName().compareToIgnoreCase(taskList.getTaskListName());
	}
}
