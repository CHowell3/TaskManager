package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

public class Notebook {
	
	private String notebookName;
	
	private boolean isChanged;
	
	
	public Notebook(String name) {
		setNotebookName(name);
	}
	
	public void saveNotebook(File file) {
		// Method not yet implemented
	}
	
	public String getNotebookName() {
		return notebookName;
	}

	private void setNotebookName(String name) {
		// Method not yet implemented
	}
	
	public boolean isChanged() {
		// Method not yet implemented
		return isChanged;
	}
	
	public void setChanged(boolean b) {
		// Method not yet implemented
	}
	
	public void addTaskList(TaskList t) {
		// Method not yet implemented
	}
	
	public String[] getTaskListsNames() {
		return null;
	}
	
	private void getActiveTaskList() {
		// Method not yet implemented
	}
	
	public void setCurrentTaskList(String list) {
		// Method not yet implemented
	}
	
	public AbstractTaskList getCurrentTaskList() {
		getActiveTaskList();
		return null;
	}
	
	public void editTaskList(String list) {
		// Method not yet implemented
	}
	
	public void removeTaskList() {
		// Method not yet implemented
	}
	
	public void addTask(Task t) {
		// Method not yet implemented
	}
	
	public void editTask(int x, String s, String y, boolean b, boolean p) {
		// Method not yet implemented
	}
}

