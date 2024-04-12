package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.io.NotebookWriter;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;
import edu.ncsu.csc216.wolf_tasks.model.util.ISwapList;

/**
 * Notebook class that has an ISortedList of TaskLists, one ActiveTaskList, an AbstractTaskList for the currentTaskList,
 * a notebookName, and a boolean flag that keeps track of if the Notebook has been changed since the last save. Methods include saving
 * notebook to a file, setting its name, changing the active task list, editing tasks and more.
 * @author Johnathan Howell and Rachel Cantrell
 */
public class Notebook {
	
	/** Name of specific notebook */
	private String notebookName;
	
	/** Boolean flag that keeps track of whether task/taskList in notebook has been changed since the last save */
	private boolean isChanged;
	
	/** Keeps track of the current task list. */
	private AbstractTaskList currentTaskList;
	
	/** List of all active tasks */
	private ActiveTaskList activeTaskList;
	
	/** List of all the taskLists in this notebook (except the active task list */
	private ISortedList<TaskList> taskLists;
	
	/**
	 * Constructor of notebook class that creates the notebook with specific name, initializes isChanged to true,
	 * constructs the taskList to be a SortedList and activeTaskList is constructed and set to currentTaskList
	 * @param name of the specific notebook
	 */
	public Notebook(String name) {
		setNotebookName(name);
		setChanged(true);
		activeTaskList = new ActiveTaskList();
		taskLists = new SortedList<TaskList>();
		currentTaskList = activeTaskList;
	}
	
	/**
	 * Saves the current notebook to the given file. 
	 * isChanged is updated to false
	 * @param file used to save the notebook to
	 */
	public void saveNotebook(File file) {
		NotebookWriter.writeNotebookFile(file, notebookName, taskLists);
		setChanged(false);
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
	 * @throws IllegalArgumentException if the name is null, empty, or matches the name of the active task list.
	 */
	private void setNotebookName(String name) {
		if(name == null || "".equals(name) || ActiveTaskList.ACTIVE_TASKS_NAME.equalsIgnoreCase(name))
			throw new IllegalArgumentException("Invalid name.");
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
		isChanged = b;
	}
	
	/**
	 * If the new TaskList’s name is ACTIVE_TASKS_NAME or a duplicate of an
	 * existing TaskList, then an IAE is thrown. Otherwise, the TaskList is added to the list 
	 * of task lists, the current task list is updated to the new task list, and isChanged is updated to true.
	 * @param t specific TaskList passed
	 */
	public void addTaskList(TaskList t) {
		if(ActiveTaskList.ACTIVE_TASKS_NAME.equalsIgnoreCase(t.getTaskListName()))
			throw new IllegalArgumentException("Invalid name.");
		try {
			taskLists.add(t);
		}
		catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid name.");
		}
		currentTaskList = t;
		isChanged = true;
		getActiveTaskList();
	}
	
	/**
	 * Returns a list of task list names. The “Active Tasks” list is always listed first.
	 * @return Array of strings with taskLists names
	 */
	public String[] getTaskListsNames() {
		int numLists = taskLists.size();
		String[] array = new String[numLists + 1];
		array[0] = ActiveTaskList.ACTIVE_TASKS_NAME;
		for(int i = 1; i <= numLists; i++) {
			array[i] = taskLists.get(i - 1).getTaskListName();
		}
		return array;
	}
	
	/**
	 * Iterates through all the TaskLists (in sorted order) 
	 * and adds each active Task (in order of priority). Must clear the ActiveTaskList first
	 */
	private void getActiveTaskList() {
		activeTaskList = new ActiveTaskList();
		int numLists = taskLists.size();
		for(int i = 0; i < numLists; i++) {
			TaskList taskList = taskLists.get(i);
			ISwapList<Task> list = taskList.getTasks();
			int numTasks = list.size();
			for(int j = 0; j < numTasks; j++) {
				Task t = list.get(j);
				if(t.isActive())
					activeTaskList.addTask(t);
			}
		}
	}
	
	/**
	 * Sets the string passed as the currentTaskList name
	 * @param taskListName String passed as parameter
	 */
	public void setCurrentTaskList(String taskListName) {
		if(taskListName.equals(ActiveTaskList.ACTIVE_TASKS_NAME)) {
			currentTaskList = activeTaskList;
			return;
		}
		int numLists = taskLists.size();
		for(int i = 0; i < numLists; i++) {
			TaskList taskList = taskLists.get(i);
			if(taskList.getTaskListName().equals(taskListName)) {
				currentTaskList = taskList;
				return;
			}
		}
		currentTaskList = activeTaskList;
	}
	
	/**
	 * Returns the new AbstractTaskList as the currentTaskList
	 * @return AbstractTaskList that is now the current task list
	 */
	public AbstractTaskList getCurrentTaskList() {
		return currentTaskList;
	}
	
	/**
	 * Edits a task list name and changes it to the string passed as the parameter
	 * @param taskListName that the TaskList will be changed to 
	 */
	public void editTaskList(String taskListName) {
		if(currentTaskList instanceof ActiveTaskList)
			throw new IllegalArgumentException("The Active Tasks list may not be edited.");
		if(taskListName.equalsIgnoreCase(ActiveTaskList.ACTIVE_TASKS_NAME)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		int numLists = taskLists.size();
		for(int i = 0; i < numLists; i++) {
			TaskList t = taskLists.get(i);
			if(t.getTaskListName().equals(taskListName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
			if(t.getTaskListName().equals(currentTaskList.getTaskListName())) {
				taskLists.remove(i);
				t.setTaskListName(taskListName);
				taskLists.add(t);
				setChanged(true);
				return;
			}
		}
		throw new IllegalArgumentException("The Active Tasks list may not be edited.");
	}
	
	/**
	 * CurrentTaskList is removed and then set to the activeTaskList
	 * isChanged is updated to true.
	 */
	public void removeTaskList() {
		if(currentTaskList instanceof ActiveTaskList)
			throw new IllegalArgumentException("The Active Tasks list may not be deleted.");
		int numLists = taskLists.size();
		for(int i = 0; i <= numLists - 1; i++) {
			TaskList t = taskLists.get(i);
			if(t.getTaskListName().equals(currentTaskList.getTaskListName())) {
				taskLists.remove(i);
				setChanged(true);
			}
		}
		currentTaskList = activeTaskList;
	}
	
	/**
	 * A Task can only be added directly to a TaskList. If the currentTaskList is not a TaskList do nothing with the Task. 
	 * If the currentTaskList is a TaskList, then add the task and check if the Task is active. If so, then you can update the activeTaskList. 
	 * isChanged is updated to true.
	 * @param t task added to taskList
	 */
	public void addTask(Task t) {
		if(currentTaskList instanceof TaskList) {
			currentTaskList.addTask(t);
			if(t.isActive())
				getActiveTaskList();
			setChanged(true);
		}
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
		if(currentTaskList instanceof ActiveTaskList)
			return;
		Task t = currentTaskList.getTask(idx);
		boolean regenerateActive = false;
		if(t.isActive())
			regenerateActive = true;
		t.setTaskName(taskName);
		t.setTaskDescription(taskDescription);
		t.setRecurring(recurring);
		t.setActive(active);
		if(t.isActive())
			regenerateActive = true;
		if(regenerateActive) {
			getActiveTaskList();
		}
		setChanged(true);
	}
}

