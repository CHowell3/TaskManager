package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Notebook class that has an ISortedList of TaskLists, one ActiveTaskList, an AbstractTaskList for the currentTaskList,
 * a notebookName, and a boolean flag that keeps track of if the Notebook has been changed since the last save. Methods include saving
 * notebook to a file, setting its name, changing the active task list, editing tasks and more.
 */
public class Notebook {
	
	/** name of specific name */
	private String notebookName;
	
	/** if task/taskList in notebook is changed */
	private boolean isChanged;
	
	/**
	 * Constructor of notebook class that creates the notebook with specific name, initializes isChanged to true,
	 * constructs the taskList to be a SortedList and activeTaskList is constructed and set to currentTaskList
	 * @param name of the specific notebook
	 */
	public Notebook(String name) {
		setNotebookName(name);
	}
	
	/**
	 * Saves the current notebook to the given file. 
	 * isChanged is updated to false
	 * @param file used to save the notebook to
	 */
	public void saveNotebook(File file) {
		// Method not yet implemented
	}
	
	/**
	 * Returns the name of the notebook
	 * @return name of notebook
	 */
	public String getNotebookName() {
		return notebookName;
	}

	/**
	 * Sets the passed parameter as the current notebook name
	 * @param name of the notebook
	 */
	private void setNotebookName(String name) {
		notebookName = name;
	}
	
	/**
	 * Returns boolean value of the field isChanged based on whether aspects of 
	 * the notebook were changed
	 * @return true if something is changed and false otherwise
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * Sets the field isChanged to true if an aspect of the notebook was 
	 * altered and false otherwise
	 * @param b true or false
	 */
	public void setChanged(boolean b) {
		// Method not yet implemented
	}
	
	/**
	 * If the new TaskList’s name is ACTIVE_TASKS_NAME or a duplicate of an
	 * existing TaskList, then an IAE is thrown. Otherwise, the TaskList is added to the list 
	 * of task lists, the current task list is updated to the new task list, and isChanged is updated to true.
	 * @param t specific TaskList passed
	 */
	public void addTaskList(TaskList t) {
		// Method not yet implemented
	}
	
	/**
	 * Returns a list of task list names. The “Active Tasks” list is always listed first.
	 * @return Array of strings with taskLists names
	 */
	public String[] getTaskListsNames() {
		return null;
	}
	
	/**
	 * Iterates through all the TaskLists (in sorted order) 
	 * and add each active Task (in order of priority). Must clear the ActiveTaskList first
	 */
	private void getActiveTaskList() {
		// Method not yet implemented
	}
	
	/**
	 * Sets the string passed as the currentTaskList name
	 * @param taskListName String passed as parameter
	 */
	public void setCurrentTaskList(String taskListName) {
		getActiveTaskList();
	}
	
	/**
	 * Returns the new AbstractTaskList as the currentTaskList
	 * @return AbstractTaskList that is now the current task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}
	
	/**
	 * Edits a task list name and changes it to the string passed as the parameter
	 * @param taskListName that the TaskList will be changed to 
	 */
	public void editTaskList(String taskListName) {
		// Method not yet implemented
	}
	
	/**
	 * CurrentTaskList is removed and then set to the activeTaskList
	 * isChanged is updated to true.
	 */
	public void removeTaskList() {
		// Method not yet implemented
	}
	
	/**
	 * A Task can only be added directly to a TaskList. If the currentTaskList is not a TaskList do nothing with the Task. 
	 * If the currentTaskList is a TaskList, then add the task and check if the Task is active. If so, then you can update the activeTaskList. 
	 * isChanged is updated to true.
	 * @param t task added to taskList
	 */
	public void addTask(Task t) {
		// Method not yet implemented
	}
	
	/**
	 * A Task can only be edited if the currentTaskList is a TaskList; otherwise, do nothing. If the Task can be edited, 
	 * Update the fields of the Task at the specified index. 
	 * Check if the Task is active. If so, then you can update the activeTaskList... isChanged is updated to true
	 * @param idx index of task
	 * @param taskName name of task
	 * @param taskDescription description of task
	 * @param recurring whether task is recurring or not
	 * @param active whether task is active or not
	 */
	public void editTask(int idx, String taskName, String taskDescription, boolean recurring, boolean active) {
		// Method not yet implemented
	}
}

